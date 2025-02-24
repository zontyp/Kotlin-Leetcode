package Array

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
                }
                currWidth--
            }
            return maxWater
            }

        }
