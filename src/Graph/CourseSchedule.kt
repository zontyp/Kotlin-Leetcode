package Graph

class CourseSchedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = hashMapOf<Int,MutableList<Int>>()
        for(i in 0 until numCourses){
            preMap[i] = mutableListOf()
        }
        for (preq in prerequisites){
            val (c,p) = preq
            preMap[c]!!.add(p)
        }
        val visited = hashSetOf<Int>()
        fun dfs(c:Int):Boolean{
            if(c in visited)
                return false
            if(preMap[c]!!.isEmpty())
                return true
            visited.add(c)
            for (preq in preMap[c]!!){
                if(!dfs(preq))
                    return false
            }
            //clean hashset for the next course call to dfs
            visited.remove(c)
            preMap[c] = mutableListOf()
            return true

        }
        for(i in 0 until numCourses){
            if(!dfs(i))
                return false
        }
        return true
    }
}