package SlidingWindow
/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 idea:

 we need to change one alphabet k times
 which alphabet will you change to make the longest substring
 you will change the alphabet with the max frequency

 when is a string valid - when windowlength - maxfrequency < k
 till string is valid - keep expanding (increment r)
 when string becomes invalid
 shrink the window by incrementing l

 frequency map - make array of 26 alphabets instead of mutable map



 */
class LC424_LongRepChrRepl {

    // Function to find the length of the longest substring that can be made of one repeating character
    // by replacing at most 'k' characters.
    fun characterReplacement(s: String, k: Int): Int {
        var l = 0 // Left pointer of the window
        var maxLength = 0 // Stores the result: max valid window length
        val freqMapArr = IntArray(26) { 0 } // Frequency array for A-Z (26 uppercase letters)
        var maxFreq = 0 // Max frequency of a single character in the current window

        // Expand the window one character at a time with right pointer
        for (r in s.indices) {
            val currentCharIndex = s[r] - 'A' // Convert char to index (0 for A, 1 for B, ..., 25 for Z)
            freqMapArr[currentCharIndex]++ // Increment the frequency of current character
            maxFreq = maxOf(maxFreq, freqMapArr[currentCharIndex]) // Update the max frequency in the window

            // If replacements needed > k, shrink window from left
            while ((r - l + 1) - maxFreq > k) {
                val charToRemoveIndex = s[l] - 'A'
                freqMapArr[charToRemoveIndex]-- // Remove leftmost character from window
                l++ // Move left pointer forward
            }

            // Update maxLength if current window is longer
            maxLength = maxOf(maxLength, r - l + 1)
        }

        return maxLength
    }
}

fun main() {
    val solver = LC424_LongRepChrRepl()
    val input = "AABABBA"
    val k = 1
    val result = solver.characterReplacement(input, k)
    println("Longest substring length with at most $k replacements: $result") // Expected: 4
}
