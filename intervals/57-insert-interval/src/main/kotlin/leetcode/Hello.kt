package leetcode

import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    private val intervalUtils = IntervalUtils()

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var pendingInterval = newInterval.copyOf(newInterval.size)

        for (i in 0..<intervals.size) {
            val current = intervals[i]
            if (intervalUtils.aIsAfterB(current, pendingInterval)) {
                result.add(pendingInterval)
                result.addAll(intervals.slice(i..<intervals.size))
                return result.toTypedArray()
            }
            if (intervalUtils.aIsAfterB(pendingInterval, current)) {
                result.add(current)
            } else {
                pendingInterval = intervalUtils.merge(current, pendingInterval)
            }
        }

        result.add(pendingInterval)

        return result.toTypedArray()
    }
}

class IntervalUtils {
    fun aIsAfterB(intervalA: IntArray, intervalB: IntArray): Boolean {
        return intervalA[0] > intervalB[1]
    }

    fun merge(intervalA: IntArray, intervalB: IntArray): IntArray {
        val start = min(intervalA[0], intervalB[0])
        val end = max(intervalA[1], intervalB[1])
        return intArrayOf(start, end)
    }
}
