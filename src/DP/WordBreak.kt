package DP

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordSet = wordDict.toSet()
        val dp = BooleanArray(s.length + 1){false}
        dp[0] = true
        for(i in 1..s.length){
            for(j in 0 until i){
                //dp[j] is true if substring from 0 to j is present in wordDict
//                check for next words from j to i
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.length]
    }
}