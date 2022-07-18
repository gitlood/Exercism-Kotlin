object Flattener {
    fun flatten(source: Collection<Any?>): List<Any> {
        return source.flatMap {
            when (it) {
                is List<*> -> flatten(it)
                else -> listOf(it)
            }
        }.filterNotNull()
    }
}