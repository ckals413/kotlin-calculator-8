package calculator

class DelimiterParser {
    fun parse(input: String): ParseResult {
        if (!input.startsWith("//")) {
            return ParseResult(input, listOf(",", ":"))
        }

        return parseCustomDelimiter(input)
    }

    private fun parseCustomDelimiter(input: String): ParseResult {
        // \n 또는 \\n 중 먼저 나오는 위치 찾기
        val realNewlineIndex = input.indexOf('\n')
        val literalNewlineIndex = input.indexOf("\\n")

        val delimiterEndIndex = when {
            realNewlineIndex != -1 && literalNewlineIndex != -1 -> minOf(realNewlineIndex, literalNewlineIndex)
            realNewlineIndex != -1 -> realNewlineIndex
            literalNewlineIndex != -1 -> literalNewlineIndex
            else -> throw IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.")
        }

        val customDelimiter = extractCustomDelimiter(input, delimiterEndIndex)
        val numbersString = extractNumbersString(input, delimiterEndIndex)

        return ParseResult(numbersString, listOf(",", ":", customDelimiter))
    }

    private fun extractCustomDelimiter(input: String, endIndex: Int): String {
        return input.substring(2, endIndex)
    }

    private fun extractNumbersString(input: String, startIndex: Int): String {
        val offset = if (input[startIndex] == '\n') 1 else 2
        return input.substring(startIndex + offset)
    }

    data class ParseResult(
        val numbersString: String,
        val delimiters: List<String>
    )
}