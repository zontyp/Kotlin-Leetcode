package BinarySearch
/*
LC 4
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

idea:

we cannot merge the two arrays
as merging takes linear time and we need to complete in log time
so we need to simulate the merging

we will create two partitions of equal length :
left and right
if total is even , left and right are of equal length
if total is odd
left partition is one more than right

all elements in left partition must be less than all elements of right partitions
we put elements in left partition from both arrays A,B
after forming the left partition - how to check if all elements are less than all elements in right
partition ?
ALeft is end of left partition from A array
BLeft is end of left from B
ARight is start of right from A
BRight is start of right from B

so we just check ALeft < BRight
BLeft < ARight

if above check is done and we need to check out of bounds of A ?
so we pad A with infinity
on left of A - we have -infinity
on right of A - we have +infinity
so we do binary search on number of elements to select from A
l = 0
r = A.size

for m - we form the partitions and check if left partition is valid
 */
class LC4_MedianTwoSortedArr {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val totalSize = nums1.size+nums2.size
        var A = nums1
        var B = nums2
        val leftPartitionSize = (totalSize + 1) / 2
        if(nums1.size > nums2.size){
            A = nums2
            B = nums1
        }
        var l = 0
        var r = A.size
        while(l <= r){
            val m = l + (r - l) / 2
            val i = m
            val j = leftPartitionSize - m
            //m or i is number of elements we take from A in the left partition
            //if we take 0 elements then A left will be - Infinity
            val ALeft = if(i > 0) A[i-1] else Int.MIN_VALUE
            val ARight = if(i < A.size) A[i] else Int.MAX_VALUE
            val BLeft = if(j > 0) B[j-1] else Int.MIN_VALUE
            val BRight = if(j < B.size) B[j] else Int.MAX_VALUE
            //less than equal as dupe elements can arise
            if(ALeft <= BRight && BLeft <= ARight){
                return if(totalSize % 2 == 0){
                    (maxOf(ALeft,BLeft) + minOf(ARight,BRight))/2.0

                }
                else
                {
                    maxOf(ALeft,BLeft).toDouble()

                }
            }
            if(ALeft > BRight){
                r = m - 1
            }
            else
            {
                l = m + 1
            }
        }
        return -1.0
    }
}