package leetcode

/*
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */

class Solution {
    // assuming that candidates are sorted already
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        val combination = mutableListOf<Int>()

        fun backtracking(candidateIndex: Int, sum: Int) {
            if (sum > target) {
                return
            }
            if (sum == target) {
                answer.add(combination.toList())
                return
            }

            for (i in candidateIndex until candidates.size) {
                combination.add(candidates[i])
                backtracking(i, sum + candidates[i])
                combination.removeLast()
            }
        }

        backtracking(0, 0)

        return answer
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.combinationSum(intArrayOf(2,3,5), 8))
    println(sol.combinationSum(intArrayOf(2,3,6,7), 7))
}

