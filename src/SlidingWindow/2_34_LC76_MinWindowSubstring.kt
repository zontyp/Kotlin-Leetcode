package SlidingWindow

/*
https://leetcode.com/problems/minimum-window-substring/

🎯 Problem:
Given two strings s and t, return the minimum window in s
that contains all the characters in t (including duplicates).
If there is no such window, return an empty string "".

🧠 Algorithm:
expand (right++) → check if valid
if valid:
    shrink (left++) greedily → get smallest window ending at right
    update answer if better
repeat

💡 Idea:
This is a classic **sliding window** problem where we expand the window
to include all characters in `t`,
then try to **shrink** it as much as possible while still keeping it valid.

👣 Real-World Analogies:

🧳 Messy Room Analogy:
- You're packing your bag (window in `s`) and need 3 things (characters in `t`)
like 🪪passport, 🔋charger, 🪥toothbrush.
- Once your bag has everything ✅, you try to lighten it up (shrink the window).
- Whenever you reach a lighter valid bag, save it! That's your best answer so far.

🛒 Grocery Aisle Analogy:
- You're walking through aisles (string `s`) to pick up
 items on your list (string `t`: 🥛, 🍞, 🥚).
- You go forward until you have everything,
then walk back from the start to skip unnecessary aisles.
- Save the shortest aisle span that satisfies your list.

📐 Sliding Window Pattern:
- `right` expands the window ➡️
- `left` shrinks the window ⬅️
 */

class LC76_MinWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val targetMap = mutableMapOf<Char, Int>() // ✅ Needed chars from t
        val windowMap = mutableMapOf<Char, Int>() // 📦 Current window char counts

        // 🧾 Build target frequency map
        for (ch in t) {
            targetMap[ch] = targetMap.getOrDefault(ch, 0) + 1
        }

        var left = 0                   // 🔍 Left pointer of window
        var totalMatches = 0           // ✅ How many characters have been fully matched
        var result = ""                // 🪞 Best (smallest) valid window so far

        for (right in s.indices) {
            val ch = s[right]

            // ➕ Add character at right pointer to window map
            if (ch in targetMap) {
                windowMap[ch] = windowMap.getOrDefault(ch, 0) + 1
                if (windowMap[ch] == targetMap[ch]) {
                    totalMatches++ // 🎯 One more character fully matched
                }
            }

            // ✅ Try shrinking from the left while window is valid
            while (totalMatches == targetMap.size) {
                // 🎯 Found a valid window, check if it's the smallest
                if (result.isEmpty() || right - left + 1 < result.length) {
                    result = s.substring(left, right + 1)
                }

                val leftChar = s[left]

                // 🧹 Remove character at left pointer from window map
                if (leftChar in targetMap) {
                    if (windowMap[leftChar] == targetMap[leftChar]) {
                        totalMatches-- // ❌ Window became invalid
                    }
                    windowMap[leftChar] = windowMap[leftChar]!! - 1
                }

                left++ // ⬅️ Move left pointer forward
            }
        }

        return result // 🏁 Return smallest valid window
    }
}

// 🚀 Main function to run and test
fun main() {
    val solver = LC76_MinWindowSubstring()

    val s = "ADOBECODEBANC"
    val t = "ABC"

    val result = solver.minWindow(s, t)
    println("🧪 Minimum window substring: \"$result\"") // Expected: "BANC"
}
