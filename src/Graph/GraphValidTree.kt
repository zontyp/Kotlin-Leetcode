package Graph

class GraphValidTree {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
       if (edges.size > n - 1)
        return false
        val adj = Array(n){ mutableListOf<Int>() }
        for((u,v) in edges){
            adj[u].add(v)
            adj[v].add(u)

        }
        val visited = hashSetOf<Int>()
        fun dfs(curr:Int,prev:Int):Boolean{
            if(curr in visited)
                return false
            visited.add(curr)
            for(neighbour in adj[curr]){
                if(neighbour == prev)
                    continue
                if(!dfs(neighbour,curr))
                    return false
            }
            return true
        }
        return dfs(0,-1) && visited.size == n
    }
}