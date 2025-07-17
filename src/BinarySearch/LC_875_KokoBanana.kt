package BinarySearch
import kotlin.math.ceil
/*
idea:
we need to find number of bananas that can be eaten in one hour
number of bananas eaten in one hour is the speed.
lowest speed = l = 1
highest speed = r = piles.max
m = l + (r-l)/2
calculate hours required for eating m bananas
th = sum((p.long + m - 1)/m)
if th > h speed is slow - increase speed
if th < h  speed is fast - decrease speed

while calculating th - p is 10 raise to 9 , so adding thrice will overflow int
so we convert to long
no need to convert long to int
as long th can be compared with int h

if we use ceil function to calculate th
sum(ceil(p.double/m))
and then convert the double to int - again int overflow can happen as p is 10 power 9

Int.MAX_VALUE ≈ 2.1 × 10⁹
 */
fun main() {
    val piles = intArrayOf(805306368,805306368,805306368)
    val h = 1000000000
    val result = LC_875_KokoBanana().minEatingSpeed(piles, h)
    println("Minimum eating speed: $result") // Expected: 4
}

class LC_875_KokoBanana {
    fun calculateHoursForMid(m: Int, piles: IntArray): Long {
        var totalHoursToEat = 0L
        for (p in piles) {
            totalHoursToEat += (p.toLong() + m - 1) / m // cant use ceil here as get error
        }

        return totalHoursToEat
    }

    //    [3,6,7,11]
    //1,2,2,3
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var l = 1 // lowest eating speed is 1
        var r = piles.max() // highest eating speed
        var answer = r
        while(l<=r){
            val m = l + (r-l)/2
            val totalHoursForMid = calculateHoursForMid(m,piles)
            when{
                totalHoursForMid > h -> l = m + 1 // time taken is more // avbl time is less // increase speed
                totalHoursForMid <= h -> {
                    answer = m
                    r = m - 1 //time taken is less //available time is more // decrease speed
                }
            }
        }
        return answer
    }
}