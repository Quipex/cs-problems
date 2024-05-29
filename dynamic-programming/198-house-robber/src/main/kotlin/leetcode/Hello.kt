package leetcode

import java.lang.Integer.max

class Solution {
    fun rob(nums: IntArray): Int {
        var lRobbed = 0
        var rRobbed = 0

        for (num in nums) {
            val tmp = max(num + lRobbed, rRobbed)
            lRobbed = rRobbed
            rRobbed = tmp
        }

        return rRobbed
    }
}
