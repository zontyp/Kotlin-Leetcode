package Array.TwoPointer.ReadWrite

fun sortColors4(nums: IntArray): Unit {
    var l = 0
    var m = 0
    var r = nums.size - 1
    while(m <= r){
        when(nums[m]){
            0->{
                swapElement(l,m,nums)
                m++
                l++
            }
            3->{
                swapElement(m,r,nums)
                r--
            }
            else-> {
                m++
            }
        }
    }
    var midL = l
    var midM = l
    var midR = r
    while(midM <= midR){
        when(nums[midM]) {
            1 -> {
            swapElement(midL,midM,nums)
            midL++
            midM++
            }

            2 -> {
                swapElement(midM,midR,nums)
                midR--
            }
        }
    }
}