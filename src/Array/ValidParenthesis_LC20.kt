package Array
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


idea:

if its opening bracket add to queue
if its closing bracket - remove first from queue and check if it
is opposite of current
 */
fun main() {
    // Test case for valid parentheses
    ValidParenthesis_LC20().isValid("([])").let { println(it) } // Expected: true
}

class ValidParenthesis_LC20 {
    fun isValid(s: String): Boolean {
        // Stack to keep track of opening brackets
        val lookup = ArrayDeque<Char>()

        // Iterate over each character in the input string
        for (myChar in s) {
            // If it's an opening bracket, push it onto the stack
            if (myChar == '(' || myChar == '[' || myChar == '{') {
                lookup.addFirst(myChar)
            }

            // If it's a closing bracket
            if (myChar == ')' || myChar == ']' || myChar == '}') {
                // If stack is empty, there is no matching opening bracket
                if (lookup.isEmpty()) return false

                // Pop the last opening bracket from the stack
                val poppedChar = lookup.removeFirst()

                // Use `when` to match closing bracket with correct opening
                when (myChar) {
                    ')' -> if (poppedChar != '(') return false
                    '}' -> if (poppedChar != '{') return false
                    ']' -> if (poppedChar != '[') return false
                }
            }
        }

        // If stack is empty, all brackets matched properly
        return lookup.isEmpty()
    }
}
