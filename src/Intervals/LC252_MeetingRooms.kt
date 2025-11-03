package Intervals
/*
LC 252
https://neetcode.io/problems/meeting-schedule

overlapping means end of one interval should not be greater or
equal to start of other interval.
so we need to check every pair with each other

but if we sort by start times - we need to check only each group of 2 intervals
a,b,c => sorted intervals
if a does not overlap with b
its guaranteed that a will not overlap with c

 */
 class Interval {
         var start: Int = 0
         var end: Int = 0
         constructor(start: Int, end: Int) {
                 this.start = start
                 this.end = end
             }
     }
class MeetingRooms {
    fun canAttendMeetings(intervals: List<Interval?>): Boolean {
        // Write your code here
        intervals.sortedBy { it?.start }.let{
           for(i in 1 until it.size){
               if(it[i] == null)
               continue
               if(it[i - 1]!!.end > it[i]!!.start)
                   return false
           }
        }
        return true
    }
}