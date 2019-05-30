package app.kundi.safelogs.core

import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import opennlp.tools.util.Span

private val locationFinderEn = NameFinderME( TokenNameFinderModel( classLoader.getResourceAsStream("models/en-ner-location.bin") ) )

val LocationReplacer: Replacer = {
        originalText, occurrenceReplacement ->
                val tokens = tokenizer.tokenize(originalText)
                val locationsFoundSpans = locationFinderEn.find(tokens)
                val locationsFoundArray = Span.spansToStrings(locationsFoundSpans, tokens)
                originalText.replace(locationsFoundArray, occurrenceReplacement)
}
