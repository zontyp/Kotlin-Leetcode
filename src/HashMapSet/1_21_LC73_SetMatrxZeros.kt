package HashMapSet
/*
LC 73
https://leetcode.com/problems/set-matrix-zeroes/description/
Given an m x n integer matrix matrix, if an element is 0,
set its entire row and column to 0's.
You must do it in place.

✅ Key Challenge:
If you start setting rows/columns to zero immediately, you might:
Accidentally wipe out info needed to process future cells.
Cause a chain reaction of zeros beyond what was originally zero.
🧠 Core Insight:
Don't modify the matrix while you're scanning it — mark first, then update in a second pass.
That’s the core in-place trick behind this problem.
 */

fun main() {
    LC73_SetMatrxZeros().setZeroes(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6)
    ))
}

class LC73_SetMatrxZeros {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val numRows = matrix.size - 1
        val numColumns = matrix[0].size - 1

        // Flags to remember if first row or first column originally had any zero
        var firstRowHasZero = false
        var firstColHasZero = false

        // First pass: scan the matrix to mark zeros
        for (r in 0..numRows)
            for (c in 0..numColumns) {
                // If any element in the first row is zero, mark the flag
                if (r == 0 && matrix[r][c] == 0)
                    firstRowHasZero = true

                // If any element in the first column is zero, mark the flag
                if (c == 0 && matrix[r][c] == 0)
                    firstColHasZero = true

                // If a zero is found (not in first row or column), mark the corresponding row and column headers
                if (r != 0 && c != 0 && matrix[r][c] == 0) {
                    matrix[0][c] = 0  // Mark column in first row
                    matrix[r][0] = 0  // Mark row in first column
                }
            }

        //marking is done
        //now make zeros as per marking

        // Zero out all columns based on markers in the first row (excluding first column)
        for (c in 1..numColumns) {
            if (matrix[0][c] == 0) {
                for (r in 1..numRows) {
                    matrix[r][c] = 0
                }
            }
        }

        // Zero out all rows based on markers in the first column (excluding first row)
        for (r in 1..numRows) {
            if (matrix[r][0] == 0) {
                for (c in 1..numColumns) {
                    matrix[r][c] = 0
                }
            }
        }

        // If the original first row had a zero, set entire first row to zero
        if (firstRowHasZero) {
            for (c in 0..numColumns) {
                matrix[0][c] = 0
            }
        }

        // If the original first column had a zero, set entire first column to zero
        if (firstColHasZero) {
            for (r in 0..numRows) {
                matrix[r][0] = 0
            }
        }
    }
}
