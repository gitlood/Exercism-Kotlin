import java.lang.Integer.toBinaryString

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val handshake: MutableList<Signal> = mutableListOf()
        val binary = toBinaryString(number).toCharArray().reversed()

        binary.indices.forEach {
            if (it < 4 && binary[it] == '1') {
                handshake.add(signals()[it])
            }
        }
        return if (binary.size > 4) {
            handshake.reversed()
        } else {
            handshake
        }
    }

    private fun signals(): List<Signal> {
        return listOf(
            Signal.WINK,
            Signal.DOUBLE_BLINK,
            Signal.CLOSE_YOUR_EYES,
            Signal.JUMP
        )
    }
}