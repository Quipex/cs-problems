package leetcode

import java.lang.Integer.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Integer.MIN_VALUE
        var current = 0
        for (num in nums) {
            val currentWithNew = current + num
            maxSum = max(maxSum, currentWithNew)
            if (currentWithNew < 0) {
                current = 0
            } else {
                current = currentWithNew
            }
        }

        return maxSum
    }
}
