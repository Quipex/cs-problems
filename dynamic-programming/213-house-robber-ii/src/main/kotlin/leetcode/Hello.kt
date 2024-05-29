package leetcode

import java.lang.Integer.max

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }

        val robFromFirst = robSubset(nums, 0, nums.size - 1)
        val robFromSecond = robSubset(nums, 1, nums.size)

        return max(robFromFirst, robFromSecond)
    }

    private fun robSubset(nums: IntArray, from: Int, to: Int): Int {
        var lRob = 0
        var rRob = 0

        for (i in from..<to) {
            val num = nums[i]
            val tmp = max(num + lRob, rRob)
            lRob = rRob
            rRob = tmp
        }

        return rRob
    }
}
