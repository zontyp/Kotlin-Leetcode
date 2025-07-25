package Graph
/*
LC 207
https://leetcode.com/problems/course-schedule/description/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have
to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

--- big idea ---
[[1,0],[0,1]]
c,p
c is course
p is prerequisite
we just need to check is any prerequisite has any course as a prerequisite
we need to detect if there is a cycle

so we make a map for course -> prerequisite called premap
c->p for all courses
and do dfs on this map
to see if there is a cycle

we need to check for cycle for each course

after checking for one course - we clear the visited , premap for that course
we clear visited as course 2 can have prereqs same as course 1 and stoll not have a cycle

we clear premap as once a course is clean / free of cycles  - no need to check it again and again
 */
class `3_LC207_CourseSchedule` {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val preMap = hashMapOf<Int,MutableList<Int>>()
        for(i in 0 until numCourses){
            preMap[i] = mutableListOf()
        }
        //[[1,0],[0,1]]
        for (preq in prerequisites){
            val (c,p) = preq
            preMap[c]!!.add(p)
            //1 -> 0
            //0 -> 1
        }
        val visited = hashSetOf<Int>()
        fun dfs(c:Int):Boolean{
            if(c in visited)
                return false
            if(preMap[c]!!.isEmpty())
                return true
            visited.add(c)//0,1
            for (preq in preMap[c]!!){
                if(!dfs(preq))
                    return false
            }
            //clean hashset for the next course call to dfs
            visited.remove(c)
            //no need to check again for this course in future  as this course is ok :
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