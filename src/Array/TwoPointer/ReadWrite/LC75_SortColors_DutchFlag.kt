package Array.TwoPointer.ReadWrite
/*

when we swap with r -
we need to recheck that element is a 1 or a 0? so we cannot increment m after swapping with r
 */
    fun swapElement(a:Int,b:Int,nums:IntArray){
        var temp = nums[a]
        nums[a] = nums[b]
        nums[b] = temp
    }
    fun sortColors(nums: IntArray): Unit {
        var l = 0
        var m = 0
        var r = nums.size - 1
        while(m<=r)
            when(nums[m]){
                0 -> {
                    swapElement(l,m,nums)
                    l++
                    m++
                }
                1-> {
                    m++
                }
                2 -> {
                    swapElement(m,r,nums)
                    r--
                }
            }
        }


fun main() {
    val input = intArrayOf(2,1,2,0,0)
    sortColors(input)
    input.forEach {
        println(it)
    }
}