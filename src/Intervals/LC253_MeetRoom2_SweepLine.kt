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
class LC253_MeetRoom2_SweepLine {
}