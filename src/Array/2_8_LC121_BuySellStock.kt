package Array

fun main() {
    BuySellStock().maxProfit(intArrayOf(7,1,5,3,6,4)).let { println(it) }
}
    class BuySellStock {
        fun maxProfit(prices: IntArray): Int {
            var minSoFar = prices[0]
            var maxProfit = Int.MIN_VALUE
            for(p in prices){
                var currProfit = p - minSoFar
                maxProfit = Math.max(maxProfit,currProfit)
                minSoFar = Math.min(minSoFar,p)
            }
            return maxProfit
    }
}