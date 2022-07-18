object Flattener {
    var flattenedSource: MutableList<Int> = mutableListOf()

    fun flatten(source: Collection<Any?>): List<Any> {
        flattenedSource = mutableListOf()
        flattenList(source.toList())
        return flattenedSource
    }

    private fun flattenList(item: List<*>) : List<Any>{
        item.filterNotNull().forEach { intOrList ->
            if (intOrList is Int) {
                flattenedSource.add(intOrList)
            }else {
                flattenList(intOrList as List<*>)
            }
        }
        return flattenedSource
    }
}