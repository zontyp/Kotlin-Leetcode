package DP

fun main() {
    val a = intArrayOf(10,9,2,5,3,7,101,18)
    println(LongestIncreasingSubsequence().lengthOfLIS(a))
}
class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        //store the smallest ending element of all increasing subsequences
        val smallestEndingList = mutableListOf<Int>()
        for (num in nums) {
            val index = smallestEndingList.binarySearch(num)
            if (index < 0) {
                //convert the index position returned by binary search to insertion point
                val insertionPoint = -index - 1
                if (insertionPoint == smallestEndingList.size) {
                    //append
                    smallestEndingList.add(num)
                } else {
                    //insert at correct position
                    smallestEndingList[insertionPoint] = num
                }
            }
        }
        return smallestEndingList.size
    }
}