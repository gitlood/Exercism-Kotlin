object Flattener {

    fun flatten(source: Collection<Any?>): List<Any> {
        return convertToMap(source.filterNotNull())
    }

    private fun convertToMap(theSource: Collection<Any>): MutableList<Int> {
        val theSourceMap: MutableList<Int> = mutableListOf()
        theSource.forEach { item ->
            if (item is Int) {
                theSourceMap.add(item)
            }
            if (item is List<*>) {
                item.filterNotNull().forEach { firstLevelInt ->
                    if (firstLevelInt is Int) {
                        theSourceMap.add(firstLevelInt)
                    } else if (firstLevelInt is List<*>) {
                        firstLevelInt.forEach { secondLevelInt ->
                            if (secondLevelInt is Int) {
                                theSourceMap.add(secondLevelInt)
                            } else if (secondLevelInt is List<*>) {
                                secondLevelInt.forEach { thirdLevelInt ->
                                    if (thirdLevelInt is Int) {
                                        theSourceMap.add(thirdLevelInt)
                                    } else if (thirdLevelInt is List<*>)
                                        theSourceMap.add(thirdLevelInt[0] as Int)
                                }
                            }
                        }
                    }
                }
            }
        }
        return theSourceMap
    }
}
