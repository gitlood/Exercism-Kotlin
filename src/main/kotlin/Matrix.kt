data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(matrix: List<List<Int>>? = null) {
    private val localMatrixRows: List<List<Int>>? = matrix
    private val minColumnIndexes: MutableMap<String, Int> = mutableMapOf()
    private val maxRowIndexes: MutableMap<String, Int> = mutableMapOf()

    var saddlePoints: Set<MatrixCoordinate> = setOf()

    init {
        greaterEqualRow()
        saddlePoints = if (matrix?.get(0)?.isNotEmpty() == true) {
            createColumns()
            compareRowsAndIndexes()
        } else {
            emptySet()
        }
    }

    private fun compareRowsAndIndexes(): Set<MatrixCoordinate> {
        val matrixPoints: MutableSet<MatrixCoordinate> = mutableSetOf()
        val rowKeys = maxRowIndexes.keys
        val colKeys = minColumnIndexes.keys

        if (rowKeys.indices.last > colKeys.indices.last) {
            rowKeys.forEach { rowKey ->
                var colValueCounter = 0
                colKeys.forEach { colKey ->
                    if (minColumnIndexes[colKey] == maxRowIndexes[rowKey]) {
                        matrixPoints.add(
                            MatrixCoordinate(
                                Integer.parseInt(rowKey[0].toString()) + 1,
                                Integer.parseInt(colKey[0].toString()) + 1
                            )
                        )
                    }
                    colValueCounter += 1
                }
            }
        } else {
            colKeys.forEach { colKey ->
                var rowValueCounter = 0
                rowKeys.forEach { rowKey ->
                    if (minColumnIndexes[colKey] == maxRowIndexes[rowKey]) {
                        matrixPoints.add(
                            MatrixCoordinate(
                                Integer.parseInt(rowKey[0].toString()) + 1,
                                Integer.parseInt(colKey[0].toString()) + 1
                            )
                        )
                    }
                    rowValueCounter += 1
                }
            }
        }
        return matrixPoints
    }

    private fun greaterEqualRow() {
        var rowCounter = 0
        localMatrixRows?.forEach { row ->
            var rowValueCounter = 0
            row.forEach { rowValue ->
                if (rowValue == row.maxOrNull()) {
                    maxRowIndexes["${rowCounter}${rowValueCounter}"] = rowValue
                }
                rowValueCounter += 1
            }
            rowCounter +=1
        }
    }

    private fun createColumns() {
        val localMatrixColumns: MutableList<MutableList<Int>> = mutableListOf()
        (0 until localMatrixRows?.get(0)?.size!!).forEach { _ ->
            localMatrixColumns.add(mutableListOf())
        }
        var rowCounter = 0
        localMatrixRows.forEach { row ->
            row.forEach { rowValue ->
                localMatrixColumns[rowCounter].add(rowValue)
                rowCounter += 1
            }
            rowCounter = 0
        }
        var columnCounter = 0
        localMatrixColumns.forEach { column ->
            var columnValueCounter = 0
            column.forEach { columnValue ->

                if (columnValue == column.minOrNull()) {
                    minColumnIndexes["${columnCounter}${columnValueCounter}"] = columnValue
                }
                columnValueCounter += 1
            }
            columnCounter += 1
        }
    }
}