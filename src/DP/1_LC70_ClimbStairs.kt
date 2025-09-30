package DP
/*
LC70
ways to reach third step are = ways to reach from step 1 + ways to reach from step 2

we precalculate for step 0 , step 1
now we need to repeat the calculation for (n - 1) times or from 2 to n => 2..n
 */
class ClimbStairs {
    fun climbStairs(n: Int): Int {
        // If there's only 1 or 2 steps, the number of ways to climb is n itself
        if (n <= 2) return n

        var previousStep = 1      // Ways to reach step 1
        var twoStepsBefore = 1    // Ways to reach step 0

        // Loop from step 2 to step n
        for (step in 2..n) {
            val currentWays = previousStep + twoStepsBefore
            twoStepsBefore = previousStep
            previousStep = currentWays
        }

        // previousStep now contains the number of ways to reach step n
        return previousStep
    }
}

fun main() {
    val solution = ClimbStairs()
    val n = 5
    println("Number of ways to climb $n steps: ${solution.climbStairs(n)}")
}
