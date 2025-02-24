package Array

class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var s1:String = s.toLowerCase()
        s1 = s1.filter{it.isLetterOrDigit()}
        var i = 0
        var j = s1.length - 1
        while(i < j){
            when{
                s1[i] == s1[j] -> {
                    i++
                    j--
                }
                s1[i] != s1[j] -> {
                    return false
                }
            }
        }
        return true
    }
}