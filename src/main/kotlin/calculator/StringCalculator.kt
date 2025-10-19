package calculator

class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }

        val numbers = input.split(",", ":")
        return numbers.sumOf { it.toInt() }
    }
}