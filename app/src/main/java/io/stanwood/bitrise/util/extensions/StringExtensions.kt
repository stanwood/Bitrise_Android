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

fun getSpan(code: String?): ParcelableSpan? =
    when(code) {
        "0" -> null
        "1" -> StyleSpan(Typeface.BOLD)
        "3" -> StyleSpan(Typeface.ITALIC)
        "4" -> UnderlineSpan()
        "30" -> ForegroundColorSpan(Color.BLACK)
        "31" -> ForegroundColorSpan(Color.RED)
        "32" -> ForegroundColorSpan(Color.GREEN)
        "33" -> ForegroundColorSpan(Color.YELLOW)
        "34" -> ForegroundColorSpan(Color.BLUE)
        "35" -> ForegroundColorSpan(Color.MAGENTA)
        "36" -> ForegroundColorSpan(Color.CYAN)
        "37" -> ForegroundColorSpan(Color.WHITE)
        "40" -> BackgroundColorSpan(Color.BLACK)
        "41" -> BackgroundColorSpan(Color.RED)
        "42" -> BackgroundColorSpan(Color.GREEN)
        "43" -> BackgroundColorSpan(Color.YELLOW)
        "44" -> BackgroundColorSpan(Color.BLUE)
        "45" -> BackgroundColorSpan(Color.MAGENTA)
        "46" -> BackgroundColorSpan(Color.CYAN)
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
