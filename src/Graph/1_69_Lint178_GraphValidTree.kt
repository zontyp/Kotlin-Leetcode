package Graph
/*
LintCode 178
https://www.lintcode.com/problem/178/
Description
Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 (each edge is a pair of nodes), write a function to check whether
  these edges make up a valid tree.

  big idea:

  if we traverse the nodes with dfs / bfs
  and
  a node appears twice
  then the tree has a cycle.

  if edges > n - 1 then also there is a cycle
 */
class `1_69_Lint178_GraphValidTree` {
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