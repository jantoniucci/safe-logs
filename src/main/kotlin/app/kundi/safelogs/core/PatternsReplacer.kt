package app.kundi.safelogs.core

val patternsMap = hashMapOf(
    "[EMAIL]" to Regex("([a-z0-9_\\-.+]+)@\\w+(\\.\\w+)*"),
    "[CREDITCARD]" to Regex("\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}|\\d{4}[ -]?\\d{6}[ -]?\\d{4}\\d?"),
    "[ZIPCODE]" to Regex("\\b\\d{5}\\b(-\\d{4})?"),
    "[IPADDRESS]" to Regex("\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(:\\d{1,5})?\\b"),
    "[USERNAME]" to Regex("(user( ?name)?|login)(:|\\sis)? \\S+"),
    "[PASSWORD]" to Regex("(pass(word|phrase)?|secret)(:|\\sis)? \\S+"),
    "[CREDENTIALS]" to Regex("(login(\\scred(ential)?s?| info(rmation)?)?|cred(ential)?s) ?(:|is|are)?\\s*\\S+")

)

val PatternsReplacer: Replacer = {
        originalText, occurrenceReplacement ->
                patternsMap.entries.fold(originalText, {
                    acc, entry ->
                        acc.replace(entry.value, entry.key)
                })
}
