import java.util.*

private val random = Random()
private fun List<*>.randomSample(n: Int) = (0 until n).map { this[random.nextInt(this.size)] }
private val names = mutableSetOf<String>()
private val letters = ('A'..'Z').toList()
private val numbers = ('0'..'9').toList()
class Robot {
    var name: String
    init {
        name = generateName()
    }

    fun reset() {
        name = generateName()
    }

    private tailrec fun generateName(): String {
        val name = letters.randomSample(2).plus(numbers.randomSample(3)).joinToString("")
        return when {
            names.add(name) -> name
            else -> generateName()
        }
    }
}