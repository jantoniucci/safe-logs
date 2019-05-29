package app.kundi.safelogs.core

import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import opennlp.tools.tokenize.SimpleTokenizer
import opennlp.tools.util.Span

private val classLoader = Thread.currentThread().contextClassLoader
private val personFinderEn = NameFinderME( TokenNameFinderModel( classLoader.getResourceAsStream("models/en-ner-person.bin") ) )
private val tokenizer = SimpleTokenizer.INSTANCE

fun String.replace(oldValues: Array<String>, newValue: String): String =
        oldValues.fold(this) { acc, old -> acc.replace(old.replace(" .", "."), newValue, ignoreCase = true) }

val NameReplacer: Replacer = {
        originalText, occurrenceReplacement ->
                val tokens = tokenizer.tokenize(originalText)
                val peopleFoundSpans = personFinderEn.find(tokens)
                val peopleFoundArray = Span.spansToStrings(peopleFoundSpans, tokens)
                originalText.replace(peopleFoundArray, occurrenceReplacement)
}
