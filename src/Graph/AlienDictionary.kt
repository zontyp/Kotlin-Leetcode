package Graph
//make adjacency list of dependencies
//make in degree
//do topological sort
fun main() {
    val words = arrayOf("wrt","wrf","er","ett","rftt")
    println(AlienDictionary().alienOrder(words))
}
class AlienDictionary {
    fun alienOrder(words: Array<String>): String {
        val dependencies = mutableMapOf<Char, MutableSet<Char>>()
        val inDegree = mutableMapOf<Char, Int>()
        for (word in words) {
            for (char in word) {
                inDegree[char] = 0
                dependencies[char] = mutableSetOf()
            }
        }
        for (i in 0 until words.lastIndex) {
            val word1 = words[i]
            val word2 = words[i + 1]
            val minLength = minOf(word1.length, word2.length)
            for (j in 0 until minLength) {
                if (word1[j] != word2[j]) {
                    if(!dependencies[word1[j]]!!.contains(word2[j])) {
                        dependencies[word1[j]]?.add(word2[j])
                        inDegree[word2[j]] = inDegree[word2[j]]!! + 1
                    }
                    break
                }
            }
        }

        val queue = ArrayDeque<Char>()
        for (char in inDegree.keys) {
            if (inDegree[char] == 0) {
                queue.add(char)
            }
        }
        val result = StringBuilder()
        while (queue.isNotEmpty()) {
            val char = queue.removeFirst()
            result.append(char)
            for (dependency in dependencies[char]!!) {
                inDegree[dependency] = inDegree[dependency]!! - 1
                if (inDegree[dependency] == 0) {
                    queue.add(dependency)
               
                }
            }
        }

        return if (result.length == inDegree.size) result.toString() else ""
    }
}