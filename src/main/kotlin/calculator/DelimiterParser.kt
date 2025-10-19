package calculator

class DelimiterParser {
    fun parse(input: String): ParseResult {
        if (input.startsWith("//")) {
            val delimiterEndIndex = input.indexOf("\n")
            val customDelimiter = input.substring(2, delimiterEndIndex)
            val numbersString = input.substring(delimiterEndIndex + 1)
            val delimiters = listOf(",", ":", customDelimiter)
            return ParseResult(numbersString, delimiters)
        }

        return ParseResult(input, listOf(",", ":"))
    }

    data class ParseResult(
        val numbersString: String,
        val delimiters: List<String>
    )
}