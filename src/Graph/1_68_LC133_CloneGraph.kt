package Graph
/*
LC 133
https://leetcode.com/problems/clone-graph/description/
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Big idea :
we are given an input node
so we can make a cloned node with the input node value
we can also add the neighbours same as node
we just need to store the cloned newnode in a visited map
so that we do not clone the same node again as we traverse the orignal graph
the visited map is just a map from existing node to new node

so basically to summarize -
create the node
add its neighbours
while adding neighbours - we either clone the node or read/take it from the visited mao

example:
1 -- 2
| \/ |
4 -- 3

clone 1
add 2 , 4

after adding 2
add 3 (by cloning), add 4 (not by cloning but by reading from map)
 */

  class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 }


class Solution {
    private val visited = HashMap<Node, Node>()   // maps original → cloned
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        return dfs(node)
    }

    private fun dfs(original: Node): Node {
        // If this node is already cloned → return the clone
        if (visited.containsKey(original)) {
            return visited[original]!!
        }

        // Step 1: Create a clone with the same value
        val clone = Node(original.`val`)

        // Step 2: Add to visited BEFORE processing neighbors (important)
        visited[original] = clone

        // Step 3: DFS clone all neighbors
        for (nei in original.neighbors) {
            if (nei != null) {
                clone.neighbors.add(dfs(nei))
            }
        }

        return clone
    }
}
