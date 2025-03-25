package DP

class LongestPalindromicSubstring {
    private var longestPalindrome: String = ""

    fun countPali(s: String, l: Int, r: Int) {
        var l = l
        var r = r
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        // After loop, the actual palindrome is between (l+1) and (r-1)
        val candidate = s.substring(l + 1, r)
        if (candidate.length > longestPalindrome.length) {
            longestPalindrome = candidate
        }
    }

    fun longestPalindrome(s: String): String {
        for (i in s.indices) {
            countPali(s, i, i)   // Odd-length palindromes
            countPali(s, i, i + 1) // Even-length palindromes
        }
        return longestPalindrome
    }
}

fun main() {
    val obj = LongestPalindromicSubstring()
    println(obj.longestPalindrome("babad")) // Expected Output: "bab" or "aba"
    println(obj.longestPalindrome("cbbd"))  // Expected Output: "bb"
}
