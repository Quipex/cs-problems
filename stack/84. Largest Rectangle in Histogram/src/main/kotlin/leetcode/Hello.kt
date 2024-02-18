package leetcode

import java.util.*
import kotlin.math.max

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val validStarts = Stack<RectangleStart>()
        var maxArea = 0

        heights.forEachIndexed { currIndex, currHeight ->
            run {
                val currRectStart = RectangleStart(currIndex, currHeight)
                while (validStarts.isNotEmpty() && validStarts.peek().height > currHeight) {
                    val lastValidStart = validStarts.pop()
                    currRectStart.index = lastValidStart.index
                    maxArea = max(lastValidStart.calcArea(currIndex), maxArea)
                }
                validStarts.push(currRectStart)
            }
        }

        while (validStarts.isNotEmpty()) {
            val lastIndex = heights.size
            val validStart = validStarts.pop()
            maxArea = max(validStart.calcArea(lastIndex), maxArea)
        }

        return maxArea
    }

    data class RectangleStart(var index: Int, val height: Int) {
        fun calcArea(endIndex: Int): Int = (endIndex - index) * height
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
}

