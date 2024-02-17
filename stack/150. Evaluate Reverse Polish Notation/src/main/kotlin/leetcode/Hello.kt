package leetcode

val operators = setOf("+", "-", "*", "/")

class Solution {
    private val stack = arrayListOf<Int>()

    fun evalRPN(tokens: Array<String>): Int {
        for (token in tokens) {
            if (!operators.contains(token)) {
                stack.add(token.toInt())
            } else {
                val b = stack.removeLast()
                val a = stack.removeLast()
                val result = when (token) {
                    "+" -> a + b
                    "-" -> a - b
                    "*" -> a * b
                    "/" -> a / b
                    else -> throw Error("unexpected")
                }
                stack.add(result)
            }
        }
        return stack.last()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()

//    println(solution.evalRPN(arrayOf("2","1","+","3","*")))
//    println(solution.evalRPN(arrayOf("4","13","5","/","+")))
    println(solution.evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))
}

