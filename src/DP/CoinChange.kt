package DP

fun main() {
    val coins = intArrayOf(1, 2, 5)
    val amount = 11
    println(CoinChange().coinChange(coins, amount))
}
class CoinChange {
    fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (coin in coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1)
            }
        }
    }
    return if (dp[amount] > amount) -1 else dp[amount]
    }
}