package Intervals
import java.lang.Integer.max
/*
LC 56
https://leetcode.com/problems/merge-intervals/description/
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the
non-overlapping intervals that cover all the intervals in the input.

solution :
if we check one interval with all others then we are done
why we do not need to do that ?
if we sort by start time , then its guaranteed that for a,b,c
if b , a not overlapping then c,a will also not overlap

Two intervals [a, b] and [c, d] overlap if:
c ≤ b
to merge :

[start = a, end = max(b, d)]

just check current and prev

 */
fun main() {
    val intervals = arrayOf(intArrayOf(1,4), intArrayOf(4,5))
    MergeIntervals().merge(intervals).forEach { it.forEach { println(it) } }
}
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy{it[0]}
        val output = mutableListOf<IntArray>()
        output.add(intervals[0])
        for(curr in intervals.sliceArray(1 until intervals.size)){
            val (currFirst,currSecond) = curr
            val prevSecond = output.last()[1]
            if(prevSecond >= currFirst){
                output.last()[1] = max(prevSecond,currSecond)
            }
            else{
                output.add(curr)
            }
        }
        return output.toTypedArray()
    }
}