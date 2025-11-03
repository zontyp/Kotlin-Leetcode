package Intervals
/*
LC 57
https://leetcode.com/problems/insert-interval/description/

You are given an array of non-overlapping intervals, intervals
where intervals[i] = [starti, endi] represent the start and the end
of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents
the start and end of another interval.


Insert newInterval into intervals such that intervals is still sorted
in ascending order by starti and intervals still does not have any overlapping
 intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

solution :

Note that you don't need to modify intervals in-place. You can make a new array and return it.
3 cases :
current interval is less than , greater than or overlapping with newInterval

if its overlapping - change newinterval by taking min of start of curr, newInterval , max of end
if overlapping case occurs - we change the newInterval itself to be the new expanded one.

how to add array to list
(result + intervals.sliceArray(intervals.indexOf(curr) until intervals.size)).toTypedArray()


 */
class `2_25_LC57_InsertIntervals` {
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