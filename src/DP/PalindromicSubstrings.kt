package DP

class PalindromicSubstrings {
    fun countPali(s:String,l:Int,r:Int):Int{
        var l = l
        var r = r
        var res = 0
        while(l >= 0 && r < s.length && s[l] == s[r]){
            res++
            l--
            r++
        }
        return res

    }

    fun countSubstrings(s: String): Int {
        var res = 0
        for(i in s.indices){
            res += countPali(s,i,i)
            res += countPali(s,i,i+1)
        }
        return res
    }
}