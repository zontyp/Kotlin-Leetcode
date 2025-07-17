package Intervals
/*
LC 57
3 cases :
current interval is less than , greater than or overlapping with newInterval

if its overlapping - change newinterval by taking min of start of curr, newInterval , max of end
if overlapping case occurs - we change the newInterval itself to be the new expanded one.

how to add array to list
(result + intervals.sliceArray(intervals.indexOf(curr) until intervals.size)).toTypedArray()


 */
class LC57_InsertIntervals {
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