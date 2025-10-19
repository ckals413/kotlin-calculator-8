package calculator

class StringCalculator {
    fun calculate(input: String): Int {
        if (input.isEmpty()) {
            return 0
        }
        return input.toInt()
    }
}