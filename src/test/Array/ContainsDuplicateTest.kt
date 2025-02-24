package test.Array
import Array.ContainsDuplicate
import org.junit.jupiter.api.Test
import org.jetbrains.annotations.TestOnly

class ContainsDuplicateTest {
    @Test
    fun testContainsDuplicate(){
        assert(ContainsDuplicate.hasDuplicate(intArrayOf(1,2,3,4)))
        assert(!ContainsDuplicate.hasDuplicate(intArrayOf(1,2,3,4,3,5)))
    }

}