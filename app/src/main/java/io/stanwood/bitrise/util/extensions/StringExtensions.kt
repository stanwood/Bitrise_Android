package io.stanwood.bitrise.util.extensions

import android.graphics.Color
import android.graphics.Typeface
import android.text.ParcelableSpan
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import java.util.Stack

private val ansiRegex by lazy { Regex("\u001B\\[[;\\d]*m") }

fun String.stripAnsiEscapes() = replace(ansiRegex, "")

private val red by lazy { Color.parseColor("#f44336") }
private val green by lazy { Color.parseColor("#4caf50") }
private val yellow by lazy { Color.parseColor("#ffeb3b") }
private val blue by lazy { Color.parseColor("#2196f3") }
private val magenta by lazy { Color.parseColor("#e91e63") }
private val cyan by lazy { Color.parseColor("#00bcd4") }

fun getSpan(code: String?): ParcelableSpan? =
    when(code) {
        "0" -> null
        "1" -> StyleSpan(Typeface.BOLD)
        "3" -> StyleSpan(Typeface.ITALIC)
        "4" -> UnderlineSpan()
        "30" -> ForegroundColorSpan(Color.BLACK)
        "31" -> ForegroundColorSpan(red)
        "32" -> ForegroundColorSpan(green)
        "33" -> ForegroundColorSpan(yellow)
        "34" -> ForegroundColorSpan(blue)
        "35" -> ForegroundColorSpan(magenta)
        "36" -> ForegroundColorSpan(cyan)
        "37" -> ForegroundColorSpan(Color.WHITE)
        "40" -> BackgroundColorSpan(Color.BLACK)
        "41" -> BackgroundColorSpan(red)
        "42" -> BackgroundColorSpan(green)
        "43" -> BackgroundColorSpan(yellow)
        "44" -> BackgroundColorSpan(blue)
        "45" -> BackgroundColorSpan(magenta)
        "46" -> BackgroundColorSpan(cyan)
        "47" -> BackgroundColorSpan(Color.WHITE)
        else -> null
    }

class AnsiInstruction(code: String) {
    val spans: List<ParcelableSpan> by lazy {
        listOfNotNull(getSpan(colorCode), getSpan(decorationCode))
    }

    var colorCode: String? = null
        private set

    var decorationCode: String? = null
        private set

    init {
        val colorCodes =
            code
                .substringAfter('[')
                .substringBefore('m')
                .split(';')

        when (colorCodes.size) {
            3 -> {
                colorCode = colorCodes[1]
                decorationCode = colorCodes[2]
            }
            2 -> {
                colorCode = colorCodes[0]
                decorationCode = colorCodes[1]
            }
            1 -> {
                decorationCode = colorCodes[0]
            }
        }
    }
}

data class AnsiSpan(
    val instruction: AnsiInstruction,
    val start: Int,
    val end: Int)

fun String.ansiEscapeToSpannable(): Spannable {
    val spannable = SpannableString(this.stripAnsiEscapes())
    val stack = Stack<AnsiSpan>()
    val spans = mutableListOf<AnsiSpan>()
    val matches = ansiRegex.findAll(this)
    var offset = 0

    matches.forEach { result ->
        val stringCode = result.value
        val start = result.range.endInclusive
        val end = result.range.endInclusive + 1
        val ansiInstruction = AnsiInstruction(stringCode)
        offset += stringCode.length
        when (ansiInstruction.decorationCode) {
            "0" -> {
                val topInstruction = stack.pop().copy(end = end - offset)
                spans.add(topInstruction)
            }
            else -> {
                val instruction = AnsiInstruction(stringCode)
                val span = AnsiSpan(
                    instruction,
                    start - offset,
                    0
                )
                stack.push(span)
            }
        }
    }

    spans.forEach { ansiSpan ->
        ansiSpan.instruction.spans.forEach {
            spannable.setSpan(it, ansiSpan.start, ansiSpan.end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        }
    }

    return spannable
}
