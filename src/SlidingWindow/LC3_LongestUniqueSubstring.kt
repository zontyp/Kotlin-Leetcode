package SlidingWindow
/*
LC 3
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
Given a string s, find the length of the longest substring without duplicate characters.

idea:
Keep a window ([left, right]) where all characters are unique.
If you see a repeated character, shrink the window from the left until it's valid again.
Track the maximum window length along the way.
 */
fun main() {
    LongestUniqueSubstring()
        .lengthOfLongestSubstring("abba")
        .let{ println(it) } // Expected output: 2
}

class LongestUniqueSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty())
            return 0

        var l = 0 // Left pointer of the window
        val lookupCharArr = IntArray(128) { -1 } // Stores the last seen index of each character (ASCII)
        var result = 0 // Stores the length of the longest valid substring found so far

        for (r in 0 until s.length) { // Right pointer of the window
            val curentCharInd = s[r].code // Get ASCII value of current character

            // If the current character was seen inside the current window
            if (lookupCharArr[curentCharInd] >= l) {
                // Move the left pointer just past the last occurrence of the current character
                l = lookupCharArr[curentCharInd] + 1

            }

            // Calculate the window size and update result if it's the largest so far
            result = maxOf(result, r - l + 1)

            // Update the last seen index of the current character
            lookupCharArr[curentCharInd] = r

            // Optional debug logs to visualize how the window shifts
//            println("---------------")
//            println(s[l]..s[r])
//            println("l = $l")
//            println("r = $r")
//            println("result = $result")
//            println("---------------")
        }

        return result
    }
}
