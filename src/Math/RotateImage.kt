package Math

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