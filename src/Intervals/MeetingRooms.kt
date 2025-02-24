package Intervals
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