object HandshakeCalculator {
    private val signals : MutableMap<Int, Signal> = setupSignals()
    fun calculateHandshake(number: Int): List<Signal> {
        val handshake: MutableList<Signal> = mutableListOf()
        var keys: MutableSet<Int> = signals.keys
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

    private fun setupSignals(): MutableMap<Int, Signal> {
        return mutableMapOf(
        1 to Signal.WINK,
        10 to Signal.DOUBLE_BLINK,
        100 to Signal.CLOSE_YOUR_EYES,
        1000 to Signal.JUMP)
    }
}