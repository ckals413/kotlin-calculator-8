package calculator

class StringCalculator {
    private val delimiterParser = DelimiterParser()

    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }

        val parseResult = delimiterParser.parse(input)
        val numbers = parseResult.numbersString.split(*parseResult.delimiters.toTypedArray())

        return numbers.sumOf { it.toInt() }
    }
}