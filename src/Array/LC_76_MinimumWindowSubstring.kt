package Array
/*
https://leetcode.com/problems/minimum-window-substring/description/
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t
(including duplicates) is included in the window. If there is no such substring,
return the empty string "".

idea:
You're cleaning a messy room (s) and need only 3 things (t): 🪪 passport, 🔋 charger, 🪥 toothbrush.

You keep adding items to your bag (expanding right) until you have everything.

Once your bag is valid (has all items), you try to remove items from the front (shrinking left) to make it lighter.

You stop shrinking when removing any more would make it invalid (e.g., removing passport).

Each time this happens, you record the lightest valid bag so far.

This ensures you always track the smallest valid window.

---------------------------------------------------------------------------
You’re walking through a grocery store (s) with a shopping list (t) for 🥛 milk, 🍞 bread, 🥚 eggs.

You walk forward aisle by aisle (expanding right), picking up items.

As soon as your basket has everything, you try to rewind from the start (shrinking left) to see if you can skip any aisles.

You stop when skipping would leave out something on the list.

The aisle span you just found is your quickest possible valid grocery trip so far.

Keep doing this and track the shortest one — that’s your answer.


algo:
expand (right++) → check if valid
if valid:
    shrink (left++) greedily → get smallest window ending at right
    update answer if better
repeat

 */
fun main() {
    println(MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"))
}
class MinimumWindowSubstring {
    fun minWindow(s: String, t: String): String {
        val targetMap = mutableMapOf<Char, Int>()
        val windowMap = mutableMapOf<Char, Int>()
        var result = ""
        for (c in t) {
            targetMap[c] = targetMap.getOrDefault(c, 0) + 1
        }
        var left = 0

        var totalMatches = 0
        for(right in 0 until s.length){
//            println(s.substring(left, right))
            if (targetMap.containsKey(s[right])) {
                windowMap[s[right]] = windowMap.getOrDefault(s[right], 0) + 1
                if(windowMap[s[right]] == targetMap[s[right]]){
                    totalMatches++
                }
            }

            while(totalMatches == targetMap.size){
                if(result.isEmpty() || result.length > right - left + 1){
//                    println(right)
//                    println(totalMatches)
//                    println(targetMap)
//                    println(s[left])
                    result = s.substring(left, right+1)
                }
                if(targetMap.containsKey(s[left])){
                    if(windowMap[s[left]]!! == targetMap[s[left]]!!)
                    totalMatches--
                    windowMap[s[left]] = windowMap[s[left]]!! - 1
                }
                left++
            }
        }
        return result
    }

}
