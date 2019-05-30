package app.kundi.safelogs.core

import opennlp.tools.tokenize.SimpleTokenizer

fun String.replace(oldValues: Array<String>, newValue: String): String =
    oldValues.fold(this) { acc, old -> acc.replace(old.replace(" .", "."), newValue, ignoreCase = true) }

val classLoader = Thread.currentThread().contextClassLoader
val tokenizer = SimpleTokenizer.INSTANCE

typealias Replacer = (originalText: String, occurrenceReplacement: String) -> String