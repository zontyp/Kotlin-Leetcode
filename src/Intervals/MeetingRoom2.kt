package Intervals

import java.util.TreeMap
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