package leetcode

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        val permutation = mutableListOf<Int>()

        fun backtrack() {
            if (permutation.size == nums.size) {
                answer.add(permutation.toList())
                return
            }

            for (n in nums) {
                if (permutation.contains(n)) {
                    continue
                }
                permutation.add(n)
                backtrack()
                permutation.removeLast()
            }
        }

        backtrack()

        return answer
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.permute(intArrayOf(1,2,3)))
}

