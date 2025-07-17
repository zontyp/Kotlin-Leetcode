package BinarySearch
/*
idea:
when m *m < x
and
m*m > x
then what to return
we cannot return m

consider the case l = m = h
now two condition can happen
1) either l = m + 1 , we get out of loop
so we cannot return that l = m + 1 as its unchecked for as loop ends
2) h = m - 1
we return this h as it is rounded down value of invalid m.

its bit tough to figure why we return h
probably l = m + 1 is already checked earlier , thats why we reached the case l = m = h
and at l = m = h
h is the only valid value

 */

fun main() {
    LC69_SqrtX().mySqrt(8).let { println(it) }
}
class LC69_SqrtX {
    fun mySqrt(x: Int): Int {
        var l = 1
        var h = x
        while(l <= h){
            val m = l + (h - l) / 2
          when{
              m == x/m -> return m
              m < x/m -> {
                  l = m+1
              }
              else -> {
                  h = m - 1
              }
          }
        }
        return h
    }
}