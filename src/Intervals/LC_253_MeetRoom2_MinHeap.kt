package Intervals
/*
think as hotel cashier / front desk
new interval comes in and tells start,end
cashier sees the existing booked room end time
it has already ended means start of new < existing end
it removes that room from booked and stores end time of new interval
if all rooms are full means start of new < earliest existing end time / min heap
then just add the new end time to the heap

size of heap = rooms used

we sort start time as we want to simulate time moving forward,
just like a real schedule
 */
import java.util.PriorityQueue
class LC_253_MeetRoom2_MinHeap {


    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        // Sort meetings by start time
        intervals.sortBy { it[0] }

        // Min-heap to track end times of ongoing meetings
        val minHeap = PriorityQueue<Int>()

        // Add end time of the first meeting
        minHeap.add(intervals[0][1])

        // Iterate through the rest of the meetings
        for (i in 1 until intervals.size) {
            val currentStart = intervals[i][0]
            val currentEnd = intervals[i][1]

            // If a room is free (i.e., meeting has ended), reuse it
            if (currentStart >= minHeap.peek()) {
                minHeap.poll()
            }

            // Allocate current meeting (new or reused room)
            minHeap.add(currentEnd)
        }

        // Number of rooms needed = heap size
        return minHeap.size
    }

}