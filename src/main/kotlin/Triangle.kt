class Triangle<out T : Number>(private val a: T, private val b: T, private val c: T) {
    init {
        require(checkTriangleHasThreeSides() && checkTriangleInequality())
    }

    val isEquilateral: Boolean = a == b && a == c
    val isIsosceles: Boolean = a == b || a == c || b == c
    val isScalene: Boolean = a != b && a != c

    private fun checkTriangleHasThreeSides(): Boolean {
        return (a != 0 || b != 0 || c != 0)
    }

    private fun checkTriangleInequality(): Boolean {
        val sides = listOf(a, b, c).map { it.toInt() }
        return sides.all { side ->
            side <= sides.sum().minus(side)
        }
    }
}