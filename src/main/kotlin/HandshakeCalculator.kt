import java.lang.Integer.toBinaryString

object HandshakeCalculator {
    private val signals = setupSignals()
    fun calculateHandshake(number: Int): List<Signal> {
        val handshake: MutableList<Signal> = mutableListOf()
        var binary = toBinaryString(number).toCharArray().reversed()
        var reverse = false
        if (binary.size > 4) {
            reverse = true
            binary = binary.subList(0, 4)
        }
        for (i in binary.indices) {
            if (binary[i] == '1') {
                handshake.add(signals[i])
            }
        }
        return if (reverse) {
            handshake.reversed()
        } else {
            handshake
        }
    }

    private fun setupSignals(): List<Signal> {
        return listOf(
            Signal.WINK,
            Signal.DOUBLE_BLINK,
            Signal.CLOSE_YOUR_EYES,
            Signal.JUMP
        )
    }
}