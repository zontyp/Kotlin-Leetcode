package Array

/*
LeetCode 125: Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into
lowercase letters and removing all non-alphanumeric characters, it reads
the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

idea:
use two pointer and check if left part of string is same as right part
*/

class ValidPalindrome_LC125 {

    fun isPalindrome(s: String): Boolean {
        // Step 1: Convert string to lowercase and remove non-alphanumeric characters
        val filtered = s.lowercase().filter { it.isLetterOrDigit() }

        // Step 2: Use two-pointer technique to compare characters from both ends
        var i = 0
        var j = filtered.length - 1

        while (i < j) {
            if (filtered[i] != filtered[j]) {
                return false // Mismatch found, not a palindrome
            }
            i++
            j--
        }

        // If loop completes, string is a valid palindrome
        return true
    }
}

// Main function to test the isPalindrome function
fun main() {
    val checker = ValidPalindrome_LC125()

    println(checker.isPalindrome("A man, a plan, a canal: Panama")) // true
    println(checker.isPalindrome("race a car"))                     // false
    println(checker.isPalindrome(" "))                              // true
    println(checker.isPalindrome("Madam"))                          // true
    println(checker.isPalindrome("No lemon, no melon"))             // true
}
