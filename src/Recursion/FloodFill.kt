fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val totalRows = image.size
    val totalColumns = image[0].size
    val oldColor = image[sr][sc]

    // ✅ Prevent infinite recursion when color is already the same
    //💀 if we dont check this - infinite recursion happens as same cells keep getting visited forever
    if (oldColor == color) return image

    fun dfs(sr: Int, sc: Int) {
        if (sr < 0 || sc < 0 || sr == totalRows || sc == totalColumns || image[sr][sc] != oldColor)
            return

        image[sr][sc] = color

        dfs(sr, sc - 1) // Left
        dfs(sr, sc + 1) // Right
        dfs(sr - 1, sc) // Up
        dfs(sr + 1, sc) // Down
    }

    dfs(sr, sc)
    return image
}

// 🔥 Main function to test floodFill
fun main() {
    val image = arrayOf(
        intArrayOf(0,0,0),
        intArrayOf(0,0,0)

    )

    val sr = 1  // Starting row
    val sc = 1  // Starting column
    val newColor = 0

    println("Before Flood Fill:")
    printImage(image)

    val result = floodFill(image, sr, sc, newColor)

    println("\nAfter Flood Fill:")
    printImage(result)
}

// 🔹 Helper function to print the image
fun printImage(image: Array<IntArray>) {
    for (row in image) {
        println(row.joinToString(" "))
    }
}
