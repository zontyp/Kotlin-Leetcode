package Backtracking
/*
At each current element at index of pos
we either take the element or not take the element
then we move to the next pos
and do the same thing - take the element or not take the element .
to take the element we add it to the leaflist .
to not take - we remove from the leafList
 */
fun main() {
    val obj = Combinations_LC77_For()
    println(obj.combine(4, 3))
}
class Combinations_LC77_For {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val leafList = mutableListOf<Int>()
        val result = mutableListOf<List<Int>>()
        fun dfs(pos:Int,k:Int){
            if(k == 0) {
                result.add(leafList.toList())
                return
            }
            if(pos > n)
                return
            if(k > n - pos + 1)
                return
            for(i in pos..n)
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