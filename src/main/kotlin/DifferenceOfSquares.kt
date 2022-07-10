class Squares(private val square: Int) {
    fun sumOfSquares() = (1..square).sumOf { it.square() }
    fun squareOfSum() = (1..square).sum().square()
    fun difference() = squareOfSum() - sumOfSquares()
}

private fun Int.square() = this * this