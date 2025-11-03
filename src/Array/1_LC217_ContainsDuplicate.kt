package Array
/*
Given an integer array nums,
return true if any value appears at least twice in the array,
 and return false if every element is distinct.

Explaination - As we see a number - we need to lookup if it is present
so we use hashset for lookup as its o(1)
if element is not present in hashset - we add it
so that it can be looked up next time.

how to implement without extra space
sort the array and then check neighbouring elements nums[i] and nums[i-1]
 */
class `1_LC217_ContainsDuplicate` {
    companion object{
        fun hasDuplicate(nums:IntArray):Boolean{
            val myHashset = hashSetOf<Int>()
            for (n in nums){
                if(n in myHashset)
                    return false
                else
                    myHashset.add(n)
            }
            return true
        }
    }
}