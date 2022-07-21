class RotationalCipher(private var start: Int) {
    private val lowerCaseMap: MutableMap<Int, Char> = mutableMapOf()

    var index: Int = 0

    fun encode(text: String): String {
        val plain: CharArray = "abcdefghijklmnopqrstuvwxyz".toCharArray()
        val textCharArray: CharArray = text.toCharArray()
        val cypherAddress: MutableList<Int> = mutableListOf()
        val returnString: StringBuilder = StringBuilder()
        plain.forEachIndexed { index, letter -> lowerCaseMap[index] = letter }

        textCharArray.forEach { letter ->
            index = start
            if (!letter.isLetter()) {
                cypherAddress.add(160)
            } else {
                if (!letter.isWhitespace()) {
                    if (lowerCaseMap.values.indexOf(letter.lowercaseChar()) + (start) > 25) {
                        index = if (letter.isLowerCase()) {
                            (lowerCaseMap.values.indexOf(letter.lowercaseChar()) + (start) - 26)
                        } else {
                            (lowerCaseMap.values.indexOf(letter.lowercaseChar()) + (start) - 26) + 25
                        }
                    } else {
                        index += if (letter.isLowerCase()) {
                            lowerCaseMap.values.indexOf(letter)
                        } else {
                            lowerCaseMap.values.indexOf(letter.lowercaseChar()) + 25
                        }
                    }
                    cypherAddress.add(index)
                } else {
                    cypherAddress.add(144)
                }
            }
        }

        cypherAddress.forEachIndexed { index, address ->
            returnString.append(
                if (address == 144) {
                    " "
                } else if (address == 160) {
                    text.toCharArray()[index]
                } else if (address < 26) {
                    plain[address]
                } else {
                    plain[address - 25].uppercaseChar()
                }
            )
        }
        return returnString.toString()
    }
}