package leetcode

/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(index: Int, subset: List<Int>) {
            if (index >= nums.size) {
                result.add(subset)
                return
            }

            // left: not appending
            dfs(index + 1, subset)

            // right: appending
            dfs(index + 1, subset + nums[index])
        }

        dfs(0, listOf())

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    print(sol.subsets(intArrayOf(1, 2, 3)))
}

