package leetcode

import java.util.PriorityQueue

/*
Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 */

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(compareBy { -it })

        for (stone in stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size > 1) {
            val max = maxHeap.poll()
            val secondMax = maxHeap.poll()
            val diff = max - secondMax
            if (diff > 0) {
                maxHeap.add(diff)
            }
        }

        return maxHeap.peek() ?: 0
    }
}

fun main(args: Array<String>) {
    val s = Solution()
    println(s.lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}

