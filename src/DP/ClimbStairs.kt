package DP

class ClimbStairs {
    fun climbStairs(n: Int): Int {
        var one = 1
        var two = 1
        for(i in 0 ..(n - 2)){
            var tmp = one
            one += two
            two = tmp
        }
        return one
    }
}