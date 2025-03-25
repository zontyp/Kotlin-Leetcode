package Backtracking
fun main() {
    val obj = Combinations_LC77()
    println(obj.combine(4, 2))
}
class Combinations_LC77 {
    fun combine(n: Int, k: Int): List<List<Int>> {
    val leafList = mutableListOf<Int>()
    val result = mutableListOf<List<Int>>()
    fun dfs(num:Int,k:Int){
        if(k == 0) {
            result.add(leafList.toList())
            return
        }
        if(num > n)
            return
        if(k > n - num + 1)
            return
        leafList.add(num)
        dfs(num + 1,k - 1)
        leafList.removeLast()
        dfs(num + 1,k)
    }
        dfs(1,k)
         return result
    }
}