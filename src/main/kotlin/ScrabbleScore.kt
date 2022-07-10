object ScrabbleScore {

    private fun scoreLetter(c: Char): Int {
        return when (c) {
            in "aeioulnrst" -> 1
            in "dg" -> 2
            in "bcmp" -> 3
            in "fhvwy" -> 4
            in "k" -> 5
            in "jx" -> 8
            in "qz" -> 10
            else -> 0
        }
    }

    fun scoreWord(word: String): Int {
        var score = 0
        for (c: Char in word.lowercase().toCharArray()) {
            score += scoreLetter(c)
        }
        return score
    }
}
