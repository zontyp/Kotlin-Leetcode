package BinarySearch

/*
LC 74 - Search a 2D Matrix
https://leetcode.com/problems/search-a-2d-matrix/

Given a matrix where each row is sorted and the first integer of each row
is greater than the last integer of the previous row, determine if a target exists.

Idea:
Treat the 2D matrix as a flat 1D sorted array.
Apply binary search on the range 0 to rows*cols - 1.
Convert the 1D index (mid) to 2D indices using:
    row = mid / cols
    col = mid % cols

    cols is total number of columns .
    mid is midpoint of 1d array
    row, col are the co ordinates of the matrix

    each cell of matrix can be placed in 1 d array
    if i is index of array
    row = i / cols
    col = i % cols
*/

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    val target = 3

    val result = LC74_Search2dMatrix().searchMatrix(matrix, target)
    println("Target $target found: $result")
}

class LC74_Search2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        // Binary search on the virtual flattened array
        var low = 0
        var high = rows * cols - 1

        while (low <= high) {
            val mid = low + (high - low) / 2

            // Convert 1D index to 2D indices
            val row = mid / cols
            val col = mid % cols

            when {
                matrix[row][col] == target -> return true
                matrix[row][col] < target -> low = mid + 1
                else -> high = mid - 1
            }
        }

        return false // Target not found
    }
}
