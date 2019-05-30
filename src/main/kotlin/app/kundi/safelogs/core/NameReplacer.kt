package app.kundi.safelogs.core

import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import opennlp.tools.util.Span

private val personFinderEn = NameFinderME( TokenNameFinderModel( classLoader.getResourceAsStream("models/en-ner-person.bin") ) )

val NameReplacer: Replacer = {
        originalText, occurrenceReplacement ->
                val tokens = tokenizer.tokenize(originalText)
                val peopleFoundSpans = personFinderEn.find(tokens)
                val peopleFoundArray = Span.spansToStrings(peopleFoundSpans, tokens)
                originalText.replace(peopleFoundArray, occurrenceReplacement)
}
