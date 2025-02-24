package Array

fun main() {
    TopKFreq_LC347().topKFreq(intArrayOf(1,1,2,2,2,3,3),3).forEach { println(it) }
}
class TopKFreq_LC347 {

    fun topKFreq(nums:IntArray,k:Int):IntArray{
        val numToCount = hashMapOf<Int,Int>()
        for(myNum in nums){
            numToCount.computeIfAbsent(myNum){0}
            numToCount.put(myNum,numToCount.get(myNum)!!.plus(1))
//            println(numToCount)
        }
        val countToNum = MutableList<MutableList<Int>>(nums.size+1){mutableListOf()}
        for ((k,v) in numToCount){
            countToNum.get(v).add(k)
        }
        val output = IntArray(k){0}
        var currIndex = 0
        for (curr in countToNum.reversed()){
            if(!curr.isEmpty()){
                for(elem in curr) {

                    if(currIndex == k)
                        return output
                    output[currIndex] = elem
                    currIndex++
                }
            }

        }
        return output
    }

}