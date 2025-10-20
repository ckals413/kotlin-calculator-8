package calculator

class InputValidator {
    fun validateNumber(numberString: String): Int {
        val number = numberString.toIntOrNull()
            ?: throw IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: $numberString")

        if (number < 0) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다: $number")
        }

        return number
    }
}