package app.kundi.safelogs.core

import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import opennlp.tools.util.Span

private val organizationFinderEn = NameFinderME( TokenNameFinderModel( classLoader.getResourceAsStream("models/en-ner-organization.bin") ) )

val OrganizationReplacer: Replacer = {
        originalText, occurrenceReplacement ->
                val tokens = tokenizer.tokenize(originalText)
                val organizationFoundSpans = organizationFinderEn.find(tokens)
                val organizationFoundArray = Span.spansToStrings(organizationFoundSpans, tokens)
                originalText.replace(organizationFoundArray, occurrenceReplacement)
}
