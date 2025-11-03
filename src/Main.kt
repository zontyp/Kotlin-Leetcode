fun demonstrateConcurrentModificationProblem() {
    // Problematic approach
    fun problematicIteration() {
        val numbers = mutableListOf(1, 2, 3, 4)

        println("Problematic Iteration:")
        val currentNumbers = numbers.toList()
        for (num in currentNumbers) {
            println("Current number: $num")

            // Trying to modify list while iterating
            numbers.add(num * 10)

            // This will cause a ConcurrentModificationException
            // or unexpected behavior
        }
        println(numbers)
    }
    problematicIteration()
}
fun main() {
//    demonstrateConcurrentModificationProblem()
//    val a = "karan"
//    println(setOf(a))
//    println(a.toSet())
    for(i in 1 until 10)
        println(i)
}