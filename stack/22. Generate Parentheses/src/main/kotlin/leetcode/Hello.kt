package leetcode

import java.util.*

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val stack = Stack<String>()
        val solution = ArrayList<String>()

        fun backtrack(openN: Int, closedN: Int) {
            if (openN == closedN && openN == n) {
                val completeStatement = stack.joinToString("")
                solution.add(completeStatement)
                return
            }

            if (openN < n) {
                stack.push("(")
                backtrack(openN + 1, closedN)
                stack.pop()
            }

            if (openN > closedN) {
                stack.push(")")
                backtrack(openN, closedN + 1)
                stack.pop()
            }
        }

        backtrack(0, 0)

        return solution
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.generateParenthesis(3))
}

