package Array
/*
LC 242
https://leetcode.com/problems/valid-anagram/description/
Given two strings s and t, return true
if t is an anagram of s, and false otherwise.
idea:
make frequency array
for both strings and check if frequency arrays are equal
to save space
make one array
increment for s , decrement for t
and check if freq array is 0
 */
class LC242_ValidAnagram {

    // Function to check if two strings are anagrams
    fun isAnagram(s: String, t: String): Boolean {
        // If lengths differ, they cannot be anagrams
        if (s.length != t.length) return false

        // Create an array to count character frequencies for 26 lowercase letters
        val freqArr = IntArray(26)

        // Traverse both strings simultaneously
        for (i in s.indices) {
            // Increment count for char in s
            freqArr[s[i] - 'a']++
            // Decrement count for char in t
            freqArr[t[i] - 'a']--
        }

        // If all counts are zero, they are anagrams
        return freqArr.all { it == 0 }
    }
}

// Main function to test the code
fun main() {
    val solver = LC242_ValidAnagram()

    val test1 = solver.isAnagram("anagram", "nagaram")
    println("Test 1: ${test1} (Expected: true)")

    val test2 = solver.isAnagram("rat", "car")
    println("Test 2: ${test2} (Expected: false)")

    val test3 = solver.isAnagram("aacc", "ccac")
    println("Test 3: ${test3} (Expected: false)")
}
