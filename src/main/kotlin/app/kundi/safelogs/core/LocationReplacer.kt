package app.kundi.safelogs.core

import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import opennlp.tools.tokenize.SimpleTokenizer
import opennlp.tools.util.Span

private val classLoader = Thread.currentThread().contextClassLoader
private val locationFinderEn = NameFinderME( TokenNameFinderModel( classLoader.getResourceAsStream("models/en-ner-location.bin") ) )
private val tokenizer = SimpleTokenizer.INSTANCE

val LocationReplacer: Replacer = {
        originalText, occurrenceReplacement ->
                val tokens = tokenizer.tokenize(originalText)
                val peopleFoundSpans = locationFinderEn.find(tokens)
                val peopleFoundArray = Span.spansToStrings(peopleFoundSpans, tokens)
                originalText.replace(peopleFoundArray, occurrenceReplacement)
}
