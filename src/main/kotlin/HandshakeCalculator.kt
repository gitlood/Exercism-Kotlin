import helper.Signal

object HandshakeCalculator {
    private val signals : MutableMap<Int, Signal> = mutableMapOf()
    fun calculateHandshake(number: Int): List<Signal> {
        val handshake: MutableList<Signal> = mutableListOf()
        var keys: MutableSet<Int> = signals.keys
        setupSignals()
        var binary: Int = Integer.parseInt(Integer.toBinaryString(number))
            while (binary >= 10000) {
                binary -= 10000
                keys = keys.reversed().toMutableSet()
        }
        if (signals.containsKey(binary)) {
            signals[binary]?.let { handshake.add(it) }
        } else {
            (keys).forEach {
                if (it <= binary) {
                    signals[it]?.let { it1 ->
                        handshake.add(it1)
                        binary -= it
                    }
                }
            }
        }
        return handshake
    }

    private fun setupSignals() {
        signals[1] = Signal.WINK
        signals[10] = Signal.DOUBLE_BLINK
        signals[100] = Signal.CLOSE_YOUR_EYES
        signals[1000] = Signal.JUMP
    }
}