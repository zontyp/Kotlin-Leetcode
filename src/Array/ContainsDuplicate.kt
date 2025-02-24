package Array

class ContainsDuplicate {
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