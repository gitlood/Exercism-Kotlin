object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        val wordMap: MutableMap<String, Int> = mutableMapOf()
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

        words.forEach{ word ->
            if (!wordMap.containsKey(word)) {
                wordMap[word] = 1
            } else {
                wordMap[word] = wordMap[word]!!.inc()
            }
        }
        return wordMap
    }
}