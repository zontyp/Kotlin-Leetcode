package Array
/*
https://leetcode.com/problems/3sum/description/
keep one pointer at first position .
for remaining elements - do 2 pointer.
to avoid duplicate triplet in a,b,c
just check if a , b are not duplicate of previous element.
if a, b are both fresh / unique then triplet will be unique.

1,1,2,-3

a needs to be checked for duplicate

1,2,2,-3
b needs to be checked for duplicate
1,1,2,2,-3,-3

if a,b are unique means the pair a,b is unique and even if c is dupe
since pair a,b is unique then dupe triplet will not come
1,2,-3
2,1,-3
c is dupe but triplets are unique
 */
class ThreeSumLC15 {
    companion object {
        fun threeSum(nums: IntArray): List<List<Int>> {
            // 🔢 Step 1: Sort the array to enable two-pointer technique
            nums.sort()
            val result = mutableListOf<List<Int>>()

            // 🚶‍♂️ Step 2: Iterate through the array, treating each number as a potential first element of a triplet
            for (i in 0 until nums.size) {

                // ⚠️ Skip duplicate first elements to avoid duplicate triplets
                if (i > 0 && nums[i] == nums[i - 1])
                    continue

                var l = i + 1  // 👈 Left pointer
                var r = nums.size - 1  // 👉 Right pointer

                // 🔁 Two-pointer search between l and r
                while (l < r) {
                    val currentSum = nums[i] + nums[l] + nums[r]

                    when {
                        // 🎯 Found a valid triplet
                        currentSum == 0 -> {
                            result.add(listOf(nums[i], nums[l], nums[r]))  // ✅ Add triplet to result
                            println(result)
                            l++
                            r--

                            // 🔁 Skip duplicate second elements (left side) to prevent repeated triplets
                            while (l < r && nums[l] == nums[l - 1])
                                l++
                            // ✅ No need to skip duplicates for r — duplicates are naturally avoided
                            // because `i` and `l` are already handled 🧠
                        }

                        // ➕ Sum is too small, move left pointer to the right to increase sum
                        currentSum < 0 -> {
                            l++
                        }

                        // ➖ Sum is too big, move right pointer to the left to decrease sum
                        else -> {
                            r--
                        }
                    }
                }
            }
            return result  // 📦 Return all unique triplets
        }
    }
}