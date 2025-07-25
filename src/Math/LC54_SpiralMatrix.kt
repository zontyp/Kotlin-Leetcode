package Math
/*
LC 54
https://leetcode.com/problems/spiral-matrix/description/
idea:
we need to move in below order:
l-r
t-b
r-l
b-t

at every iteration  we need to reduce the boundaries to enter inside in spiral way
so we keep 4 boundary indexes - t,b,l,r
t,l = 0
b,r = n - 1
when we cover first row - we increment t
when we cover last row - we decrement b

when we cover first column - l++
when we cover last column r --

we also check if t > b and l > r to stop traversing further

 */
class LC54_SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1
        val result = mutableListOf<Int>()
        while(top <= bottom && left <= right){
            //l -> r
            for(i in left..right)
                result.add(matrix[top][i])
            top++
            //t -> b
            for(i in top..bottom)
                result.add(matrix[i][right])
            right--
            //r -> l
            if(top <= bottom) {
            for(i in right downTo left)
                result.add(matrix[bottom][i])
                    bottom--
                }
            //b->t
            if(left <= right){
                for(i in bottom downTo top)
                    result.add(matrix[i][left])
                left ++
            }
        }
        return result
    }
}