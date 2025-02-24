package Intervals

class InsertIntervals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for(curr in intervals){
            when{
                //current is greater
                newInterval[1] < curr[0] -> {
                    result.add(newInterval)
                    return (result + intervals.sliceArray(intervals.indexOf(curr) until intervals.size)).toTypedArray()
                }
                //current is lesser
                newInterval[0] > curr[1] ->{
                    result.add(curr)
                }
                //current need to be merged
                else -> {
                    newInterval[0] = Math.min(newInterval[0],curr[0])
                    newInterval[1] = Math.max(newInterval[1],curr[1])
                }
            }
        }
        result.add(newInterval)
        return result.toTypedArray()
    }
}