package Math
/*
LC48
Idea:
rotate = transpose + reverse

how to derive intutionally:
hold the last column of a 3 * 3 with your fingers
now rotate it
you moved it from third column to third row
so you tool transpose
but the top element went to the right instead of left (as in transpose)
so you reversed the transpose

so
rotation = transpose + reverse

you can also do reverse rows followed by transpose

hold first row and rotate it
it will come in that position if it was the third row and we took the transpose .
 */
fun main() {
    val a = RotateImage()
    a.rotate(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))
}
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        matrix.reverse()
        println(matrix.contentDeepToString())
        for(i in matrix.indices){
            for(j in i+1 until matrix[i].size){
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }

        }
    }
}