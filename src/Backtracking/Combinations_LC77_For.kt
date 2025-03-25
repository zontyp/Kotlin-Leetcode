package Backtracking
fun main() {
    val obj = Combinations_LC77_For()
    println(obj.combine(4, 3))
}
class Combinations_LC77_For {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val leafList = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()
        fun dfs(start:Int,k:Int){
            if(k == 0) {
                result.add(leafList.toList())
                return
            }
            if(start > n)
                return
            if(k > n - start + 1)
                return
            for(i in start..n)
            {
                leafList.add(i)
                dfs(i + 1,k - 1)
                leafList.removeLast()

            }

        }
        dfs(1,k)
        return result
    }
}