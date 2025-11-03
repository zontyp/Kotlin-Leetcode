package Array
/*
https://leetcode.com/problems/container-with-most-water/description/
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.


suppose both containers are of same height
if we move either - still height of existing will be the bottleneck

so if both containers have same height - move both pointers
.
we are on l , r
smaller between l , r is t-small .
for successive attempt to succeed we need smaller between l,r to be higher than t-small.
so we just ignore t-small of current attempt.
 */
fun main() {
    println(ContainerMaxWater_LC11().maxArea(intArrayOf(1,1)))
}
class ContainerMaxWater_LC11 {
        fun maxArea(height: IntArray): Int {
            var i = 0
            var j = height.size - 1
            var currWidth = height.size - 1
            var maxWater = Int.MIN_VALUE
            var currMaxWater = 0
            while(i < j){
                currMaxWater = currWidth * Math.min(height[i],height[j])
                maxWater = Math.max(currMaxWater,maxWater)
                when{
                    height[i] < height[j] -> i++
                    else -> j--
                    //if both heights are same - we can move both pointers as well.
                }
                currWidth--
            }
            return maxWater
            }

        }
