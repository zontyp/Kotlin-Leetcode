package Array

fun main() {
    ValidParenthesis_LC20().isValid("([])").let { println(it) }
}
class ValidParenthesis_LC20 {
    fun isValid(s: String): Boolean {
        val lookup = ArrayDeque<Char>()
        for(myChar in s){
            if(myChar == '(' || myChar == '[' || myChar == '{'){
                lookup.addFirst(myChar)
            }
            if(myChar == ')' || myChar == ']' || myChar == '}'){
                if(lookup.isEmpty()) return false
                val poppedChar = lookup.removeFirst()

                if(myChar == ')' && poppedChar != '(')
                    return false
                if(myChar == '}' && poppedChar != '{')
                    return false
                if(myChar == ']' && poppedChar != '[')
                    return false

            }
        }
        return lookup.isEmpty()
        }
}