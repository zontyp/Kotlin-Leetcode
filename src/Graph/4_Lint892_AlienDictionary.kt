package Graph

//make adjacency list of dependencies
//make in degree
//do topological sort
//
//
/*
https://www.lintcode.com/problem/892/
There is a new alien language which uses the latin alphabet.
 However, the order among letters are unknown to you.
 You receive a list of non-empty words from the dictionary,
 where words are sorted lexicographically by the rules of this new language.
 Derive the order of letters in this language.


dependency[t] = f
f depends on t
first t will be added , then f will be added
dep[e] = r
dep[r] = t
w -> e

--------------- Big Idea --------------------------

there are two steps in this problem :
a) find the dependencies of the characters
b) add the character to the result when all its parents are added to the result already

a) to find dependencies :
the words are sorted in lexicographical order
the first differing character between adjacent words is the reason for the ordering of words

so the first differing character between adjacent words will give us a dependency

once we have the dependencies - we move to step 2

b) to add character to result :
add all chars with indegree 0 to queue
now add one character with indgree 0 to result - resulted char
now reduce indegree of all chars which depend on/ are child of  resulted char by 1
add chars with indegree 0 to queue

add next char from queue to result ... and so on


 */

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