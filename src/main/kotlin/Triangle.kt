class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    init{
        testing()
    }
    val isEquilateral: Boolean = a == b && a == c
    val isIsosceles: Boolean = a == b || a == c || b == c
    val isScalene: Boolean = a != b && a != c

    private fun testZeros():Boolean {
        return (a != 0 || b != 0 || c != 0)
    }

    private fun testInequalityViolation(): Boolean {
        val a1 = a.toInt()
        val b1 = b.toInt()
        val c1 = c.toInt()
        return !(a1 > b1 + c1 || b1 > a1 + c1 || c1 > a1 + b1)
    }

    private fun testing() {
        if (!(testZeros() && testInequalityViolation())) {
            throw IllegalArgumentException()
        }
    }
}