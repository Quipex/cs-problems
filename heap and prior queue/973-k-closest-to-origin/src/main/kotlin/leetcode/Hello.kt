package leetcode

import java.util.*
import kotlin.math.sqrt


/*
Example 1:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]

Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].


Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]

Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val minHeap = PriorityQueue<IntArray>(compareBy { -calculateValue(it) })

        for (point in points) {
            minHeap.add(point)
        }

        shrinkHeap(minHeap, k)

        return minHeap.toTypedArray()
    }

    companion object {
        fun shrinkHeap(heap: PriorityQueue<IntArray>, k: Int) {
            while (heap.size > k) {
                heap.poll()
            }
        }

        fun calculateValue(point: IntArray): Double {
            val (x, y) = point
            return sqrt((x * x) + (y * y).toDouble())
        }
    }
}

fun main(args: Array<String>) {
    val s = Solution()
    println(pretty(s.kClosest(arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)), 1)))
}

fun pretty(arr: Array<IntArray>): String {
    return arr.joinToString(prefix = "[", postfix = "]", transform = { it.joinToString(prefix = "[", postfix = "]") })
}

