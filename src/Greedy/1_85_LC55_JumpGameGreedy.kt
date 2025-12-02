package Greedy
/*
LC 55
https://leetcode.com/problems/jump-game/description
if all elements are 1 - then we will always reach the end by making a jump of 1

so we just need to lookout for zeroes and if we get stuck at them
so we start from the end and just see if we get stuck or no from the previous element.
we assume we make it to the previous element and check if we get stuck because of a zero

at any element we reach with i jumps and then check if we reach the next element

if last element is the goal - can you reach it from any previous element ???
check it
if yes then make that element as goal and check if you can now reach this new goal
from any previous element

alternate idea :

if we track the maxreach from each element -
at any i
if i > maxReach then that i is unreachable
 */
fun main() {
    JumpGame().canJump(intArrayOf(2,0)).let{ println(it) }
}
class JumpGameGreedy {
    fun canJump(nums: IntArray): Boolean {
        var goal = nums.size - 1
        for(i in nums.size - 2 downTo 0){
            if(i+nums[i] >= goal)
                goal = i
        }
        return goal == 0
    }
}