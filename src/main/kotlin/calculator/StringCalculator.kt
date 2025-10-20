package calculator

class StringCalculator {
    private val delimiterParser = DelimiterParser()

    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }

        val parseResult = delimiterParser.parse(input)
        val numbers = parseResult.numbersString
            .split(*parseResult.delimiters.toTypedArray())
            .map { it.trim() }              // 공백 제거
            .filter { it.isNotEmpty() }     // 빈 문자열 제거

        return numbers.sumOf { it.toInt() }
    }
}