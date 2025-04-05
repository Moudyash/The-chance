package Week01

fun test(name: String, result: Boolean, correctResult: Boolean) {
    if (result == correctResult) {
        println("Success: $name.")
    } else {
        println("Failed: $name.")
    }
}

fun isValidSudoku(board: List<List<Any>>): Boolean {
    if (board.size != 9 || board.any { it.size != 9 }) {
        return false
    }

    // Check for invalid characters
    for (row in board) {
        for (cell in row) {
            if (cell != '-' && (cell !in '1'..'9')) {
                return false
            }
        }
    }

    // Check rows, columns, and subgrids
    for (i in 0 until 9) {
        val seenRow = mutableSetOf<Any>()
        val seenCol = mutableSetOf<Any>()
        val seenSubgrid = mutableSetOf<Any>()

        for (j in 0 until 9) {
            // Check row
            val rowValue = board[i][j]
            if (rowValue != '-' && !seenRow.add(rowValue)) {
                return false
            }

            // Check column
            val colValue = board[j][i]
            if (colValue != '-' && !seenCol.add(colValue)) {
                return false
            }

            // Check 3x3 subgrid
            val subgridValue = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3]
            if (subgridValue != '-' && !seenSubgrid.add(subgridValue)) {
                return false
            }
        }
    }

    return true
}

fun main() {
    // Test 1: Valid Sudoku board
    val validSudoku = listOf(
        listOf('2', '7', '-', '-', '3', '-', '-', '8', '-'),
        listOf('4', '-', '-', '5', '9', '1', '-', '-', '-'),
        listOf('-', '6', '3', '-', '-', '-', '-', '4', '-'),
        listOf('1', '-', '-', '-', '7', '-', '-', '-', '5'),
        listOf('9', '-', '-', '6', '-', '2', '-', '-', '3'),
        listOf('8', '-', '-', '-', '1', '-', '-', '-', '7'),
        listOf('-', '5', '-', '-', '-', '-', '7', '9', '-'),
        listOf('-', '-', '-', '7', '2', '4', '-', '-', '8'),
        listOf('-', '3', '-', '-', '8', '-', '-', '1', '6')
    )
    test("Valid Sudoku", isValidSudoku(validSudoku), true)

    // Test 2: Invalid Sudoku with duplicate in row
    val invalidRowBoard = listOf(
        listOf('2', '7', '-', '-', '3', '-', '-', '8', '-'),
        listOf('4', '-', '-', '5', '9', '1', '-', '-', '-'),
        listOf('-', '6', '3', '-', '-', '-', '-', '4', '-'),
        listOf('1', '-', '-', '-', '7', '-', '-', '-', '5'),
        listOf('9', '-', '-', '6', '-', '2', '-', '-', '3'),
        listOf('8', '-', '-', '-', '1', '-', '-', '-', '7'),
        listOf('-', '5', '-', '-', '-', '-', '7', '9', '-'),
        listOf('-', '-', '-', '7', '2', '4', '-', '-', '8'),
        listOf('2', '3', '-', '-', '8', '-', '-', '1', '6') // Duplicate '2' in first column and first row
    )
    test("Invalid Sudoku (Row Duplicate)", isValidSudoku(invalidRowBoard), false)

    // Test 3: Invalid Sudoku with duplicate in column
    val invalidColumnBoard = listOf(
        listOf('2', '7', '-', '-', '3', '-', '-', '8', '-'),
        listOf('4', '-', '-', '5', '9', '1', '-', '-', '-'),
        listOf('-', '6', '3', '-', '-', '-', '-', '4', '-'),
        listOf('1', '-', '-', '-', '7', '-', '-', '-', '5'),
        listOf('9', '-', '-', '6', '-', '2', '-', '-', '3'),
        listOf('8', '-', '-', '-', '1', '-', '-', '-', '7'),
        listOf('-', '5', '-', '-', '-', '-', '7', '9', '-'),
        listOf('2', '-', '-', '7', '2', '4', '-', '-', '8'), // Duplicate '2' in first column
        listOf('-', '3', '-', '-', '8', '-', '-', '1', '6')
    )
    test("Invalid Sudoku (Column Duplicate)", isValidSudoku(invalidColumnBoard), false)

    // Test 4: Invalid Sudoku with invalid characters
    val invalidCharacterBoard = listOf(
        listOf('2', '7', '-', '-', '3', '-', '-', '8', '-'),
        listOf('4', '-', '-', '5', '9', '1', '-', '-', '-'),
        listOf('-', '6', '3', '-', 'X', '-', '-', '4', '-'), // 'X'
        listOf('1', '-', '-', '-', '7', '-', '-', '-', '5'),
        listOf('9', '-', '-', '6', '-', '2', '-', '-', '3'),
        listOf('8', '-', '-', '-', '1', '-', '-', '-', '7'),
        listOf('-', '5', '-', '-', '-', '-', '7', '9', '-'),
        listOf('-', '-', '-', '7', '2', '4', '?', '-', '8'), // '?'
        listOf('-', '3', '-', '-', '8', '-', '-', '1', '6')
    )
    test("Invalid Sudoku (Character Error)", isValidSudoku(invalidCharacterBoard), false)

    // Test 5: Invalid Sudoku size
    val invalidSizeBoard = listOf(
        listOf('2', '7', '-', '-', '3', '-'),
        listOf('4', '-', '-', '5', '9', '1'),
        listOf('-', '6', '3', '-', '-', '-'),
        listOf('1', '-', '-', '-', '7', '-'),
        listOf('9', '-', '-', '6', '-', '2'),
        listOf('8', '-', '-', '-', '1', '-')
    )
    test("Invalid Sudoku Size", isValidSudoku(invalidSizeBoard), false)

    // Test 6: Invalid Sudoku with negative number characters
    val negativeNumberBoard = listOf(
        listOf('2', '7', '-', '-', '3', '-', '-', '8', '-'),
        listOf('4', '-', '-', '5', '9', '1', '-', '-', '-'),
        listOf('-', '6', '3', '-', "−2", '-', '-', '4', '-'), // '−2'
        listOf('1', '-', '-', '-', '7', '-', '-', '-', '5'),
        listOf('9', '-', '-', '6', '-', '2', '-', '-', '3'),
        listOf('8', '-', '-', '-', '1', '-', '-', '-', '7'),
        listOf('-', '5', '-', '-', '-', '-', '7', '9', '-'),
        listOf('-', '-', '-', '7', '2', '4', '-', '-', '8'),
        listOf('-', '3', '-', '-', '8', '-', '-', '1', '6')
    )
    test("Invalid Sudoku (Negative Numbers)", isValidSudoku(negativeNumberBoard), false)
}