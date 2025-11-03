package Intervals
/*
LC253
make list of sorted start times, sorted end times
If start[i] < end[j]:

A meeting starts before another ends → need a new room

rooms++, move i to next start time

Else:

The earliest meeting has ended, so we can reuse a room

Move j to next end time, and move i

You’re just counting how many meetings have started but not ended yet.

A meeting starts → increment

A meeting ends → decrement

imagine a timeline and focus on the dots of start , end time in the time line

 */

/*
LC253 - Meeting Rooms II

Approach: Sweep Line / Two Pointer
---------------------------------
1️⃣ Extract start and end times separately.
2️⃣ Sort both arrays.
3️⃣ Traverse using two pointers:
    - If a meeting starts before another ends (start[i] < end[j]):
        ➤ Need a new room → rooms++
        ➤ Move to next start time (i++)
    - Else:
        ➤ A meeting ended → free a room
        ➤ Move both pointers (j++, i++)

Essentially counting how many meetings overlap at a given moment.

Time: O(n log n)
Space: O(n)
*/

class LC253_MeetRoom2_SweepLine {

    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        val starts = intervals.map { it[0] }.sorted()
        val ends = intervals.map { it[1] }.sorted()

        var rooms = 0
        var maxRooms = 0
        var i = 0
        var j = 0

        while (i < starts.size) {
            if (starts[i] < ends[j]) {
                rooms++              // A meeting starts before another ends
                maxRooms = maxOf(maxRooms, rooms)
                i++
            } else {
                rooms--              // A meeting ended, free a room
                j++
            }
        }

        return maxRooms
    }
}
