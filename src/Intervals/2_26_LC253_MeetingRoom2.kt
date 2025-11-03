package Intervals
/*

https://neetcode.io/problems/meeting-schedule-ii
Given an array of meeting time interval objects
consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
find the minimum number of days required to schedule all
meetings without any conflicts.

LC 253
 in meeting rooms - we just need to check if overlap is there or no
 in meeting room 2 - we need to count the number of overlaps
 overlaps may not be consecutive
 0,30
 5,10
 12,15

 12,15 is overlapping with 0,30 although they are not consecutive
 so if we just check consecutive - we miss out on that info
 so we store start time , end time as keys in a map , we sort the map
 and then add every value - the max value after adding any value is the result

 if we get start time - we add a room , if we get end time -
  we decrease a room . so we add start time, end time as keys in a map and sort the map .
for start time we add 1 to the value of the map
 */
//class Interval(var start: Int, var end: Int) {}
fun main() {
    val one = Interval(1,5)
    val two = Interval(2,6)
    val three = Interval(3,7)

    val four = Interval(8,10)
    val five = Interval(6,8)
    MeetingRoom2().minMeetingRooms(listOf(one,two,three,four)).let{ println(it) }
}
class MeetingRoom2 {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        var lookup = mutableMapOf<Int,Int>()
        for(curr in intervals){
            lookup.put(curr.start,lookup.getOrDefault(curr.start,0) + 1)
            lookup.put(curr.end,lookup.getOrDefault(curr.end,0) - 1)
        }
        lookup = lookup.toSortedMap()
        var numRooms = 0
        var result = 0
        for(curr in lookup.values){
            numRooms += curr
            result = Math.max(result,numRooms)
        }
        return result
    }
}