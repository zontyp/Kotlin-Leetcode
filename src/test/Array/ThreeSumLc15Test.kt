package test.Array
import Array.ContainsDuplicate
import Array.ThreeSumLC15
import org.junit.jupiter.api.Test
import org.jetbrains.annotations.TestOnly

class ThreeSumLc15Test {
    @Test
    fun testThreeSum(){
        assert(ThreeSumLC15.threeSum(intArrayOf(1,2,-3,4)).equals(listOf(listOf(-3,1,2))))
        assert(ThreeSumLC15.threeSum(intArrayOf(1,1,2,-3,4)).equals(listOf(listOf(-3,1,2))))
        assert(ThreeSumLC15.threeSum(intArrayOf(1,1,2,2,-3,4)).equals(listOf(listOf(-3,1,2))))
        assert(ThreeSumLC15.threeSum(intArrayOf(1,1,2,2,-3,-3,4)).equals(listOf(listOf(-3,1,2))))
    }

}