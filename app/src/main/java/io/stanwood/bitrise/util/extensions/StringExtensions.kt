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

enum class AnsiCode(val code: Byte) {
    RESET(0),
    BOLD(1),
    ITALIC(3),
    UNDERSCORE(4),
    FOREGROUND_BLACK(30),
    FOREGROUND_RED(31),
    FOREGROUND_GREEN(32),
    FOREGROUND_YELLOW(33),
    FOREGROUND_BLUE(34),
    FOREGROUND_MAGENTA(35),
    FOREGROUND_CYAN(36),
    FOREGROUND_WHITE(37),
    BACKGROUND_BLACK(40),
    BACKGROUND_RED(41),
    BACKGROUND_GREEN(42),
    BACKGROUND_YELLOW(43),
    BACKGROUND_BLUE(44),
    BACKGROUND_MAGENTA(45),
    BACKGROUND_CYAN(46),
    BACKGROUND_WHITE(47);

    val span: ParcelableSpan?
        get() = when(this) {
            RESET -> null
            BOLD -> StyleSpan(Typeface.BOLD)
            ITALIC -> StyleSpan(Typeface.ITALIC)
            UNDERSCORE -> UnderlineSpan()
            FOREGROUND_BLACK -> ForegroundColorSpan(Color.BLACK)
            FOREGROUND_RED -> ForegroundColorSpan(Color.RED)
            FOREGROUND_GREEN -> ForegroundColorSpan(Color.GREEN)
            FOREGROUND_YELLOW -> ForegroundColorSpan(Color.YELLOW)
            FOREGROUND_BLUE -> ForegroundColorSpan(Color.BLUE)
            FOREGROUND_MAGENTA -> ForegroundColorSpan(Color.MAGENTA)
            FOREGROUND_CYAN -> ForegroundColorSpan(Color.CYAN)
            FOREGROUND_WHITE -> ForegroundColorSpan(Color.WHITE)
            BACKGROUND_BLACK -> BackgroundColorSpan(Color.BLACK)
            BACKGROUND_RED -> BackgroundColorSpan(Color.RED)
            BACKGROUND_GREEN -> BackgroundColorSpan(Color.GREEN)
            BACKGROUND_YELLOW -> BackgroundColorSpan(Color.YELLOW)
            BACKGROUND_BLUE -> BackgroundColorSpan(Color.BLUE)
            BACKGROUND_MAGENTA -> BackgroundColorSpan(Color.MAGENTA)
            BACKGROUND_CYAN -> BackgroundColorSpan(Color.CYAN)
            BACKGROUND_WHITE -> BackgroundColorSpan(Color.WHITE)
        }

    companion object {
        fun fromByte(code: Byte) =
            AnsiCode
                .values()
                .firstOrNull { ansi -> ansi.code == code }

        fun fromString(code: String) = fromByte(code.toByte())
    }
}

class AnsiInstruction(code: String) {
    val spans: List<ParcelableSpan> by lazy {
        listOfNotNull(colorCode?.span, decorationCode?.span)
    }

    var colorCode: AnsiCode? = null
        private set

    var decorationCode: AnsiCode? = null
        private set

    init {
        val colorCodes =
            code
                .substringAfter('[')
                .substringBefore('m')
                .split(';')

        when (colorCodes.size) {
            3 -> {
                colorCode = colorCodes[1].let { AnsiCode.fromString(it) }
                decorationCode = colorCodes[2].let { AnsiCode.fromString(it) }
            }
            2 -> {
                colorCode = colorCodes[0].let { AnsiCode.fromString(it) }
                decorationCode = colorCodes[1].let { AnsiCode.fromString(it) }
            }
            1 -> {
                decorationCode = colorCodes[0].let { AnsiCode.fromString(it) }
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
            AnsiCode.RESET -> {
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
