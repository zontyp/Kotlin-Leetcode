package Greedy

fun main() {
    JumpGame().canJump(intArrayOf(2,0)).let{ println(it) }
}
class JumpGame {
    fun canJump(nums: IntArray): Boolean {

        fun dfs(currInd:Int):Boolean{
            if(currInd == nums.size - 1)
                return true
            val end = Math.min(nums.size - 1,currInd+nums[currInd])
            for(i in currInd+1 .. end) {
                if(dfs(i))
                    return true
            }
            return false
        }
        return dfs(0)
    }
}