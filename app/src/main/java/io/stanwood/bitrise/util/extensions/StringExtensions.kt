package io.stanwood.bitrise.util.extensions

private val ansiRegex by lazy { Regex("\u001B\\[[;\\d]*m") }

fun String.stripAnsiEscapes() = replace(ansiRegex, "")