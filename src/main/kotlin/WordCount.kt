import java.util.*

object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val words: MutableList<String> = phrase.lowercase()
            .replace(","," ")
            .replace("[^A-Za-z0-9 ']".toRegex(),"")
            .replace("\n","")
            .splitToSequence(' ')
            .filter { it.isNotEmpty() }
            .toList().toMutableList()

        words.forEachIndexed{index, word->
            if(word.startsWith("'")){
                words[index] = word.substring(1, word.length-1)
            }
        }
        return words.associateWith { word -> Collections.frequency(words, word) }
    }
}