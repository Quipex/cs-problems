package leetcode

import java.util.*

class Solution {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val unmatchedTemps = Stack<TempInfo>()
        val result = IntArray(temperatures.size)

        temperatures.forEachIndexed { currIndex, currTemp ->
            run {
                while (unmatchedTemps.isNotEmpty() && (unmatchedTemps.peek().temp < currTemp)) {
                    val lowerTemp = unmatchedTemps.pop()
                    result[lowerTemp.index] = currIndex - lowerTemp.index
                }
                unmatchedTemps.push(TempInfo(currTemp, currIndex))
            }
        }

        while (unmatchedTemps.isNotEmpty()) {
            val unmatchedTemp = unmatchedTemps.pop()
            result[unmatchedTemp.index] = 0;
        }

        return result
    }

    data class TempInfo(val temp: Int, val index: Int)
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).joinToString())
}

