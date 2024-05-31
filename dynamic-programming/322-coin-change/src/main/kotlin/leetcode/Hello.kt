package leetcode

import kotlin.math.min

class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val cache = HashMap<Int, Int>()
        cache[0] = 0

        for (subAmount in 1..amount) {
            for (coin in coins) {
                val restToCount = subAmount - coin
                if (restToCount < 0) {
                    continue
                }
                if (!cache.containsKey(restToCount)) {
                    continue
                }

                cache[subAmount] = min(cache[subAmount] ?: Int.MAX_VALUE, 1 + cache[restToCount]!!)
            }
        }

        return cache[amount] ?: -1
    }
}
