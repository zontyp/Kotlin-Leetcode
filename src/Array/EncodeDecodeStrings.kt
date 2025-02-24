package Array

fun main() {
    val a = EncodeDecodeStrings()
    println(a.encode(listOf("hello", "world")))
    println(a.decode("5#hello5#world"))
}
class EncodeDecodeStrings {
    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for (s in strs) {
            sb.append(s.length).append('#').append(s)
        }
        return sb.toString()
    }
    fun decode(s: String): List<String> {
        val res = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val j = s.indexOf('#', i)
            val size = s.substring(i, j).toInt()
            res.add(s.substring(j + 1, j + 1 + size))
            i = j + 1 + size
        }
        return res
    }
}