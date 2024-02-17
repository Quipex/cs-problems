package leetcode

class MinStack() {
    private val numbersStack = arrayListOf<Int>()
    private val minsStack = arrayListOf<Int>()

    fun push(num: Int) {
        numbersStack.add(num)
        if (minsStack.isEmpty() || num < minsStack.last()) {
            minsStack.add(num)
        } else {
            minsStack.add(minsStack.last())
        }
    }

    fun pop() {
        if (numbersStack.isEmpty()) {
            return
        }
        numbersStack.removeAt(numbersStack.lastIndex)
        minsStack.removeAt(minsStack.lastIndex)
    }

    fun top(): Int = numbersStack.last()

    fun getMin(): Int = minsStack.last()
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

fun main(args: Array<String>) {
    var obj = MinStack()
    obj.push(-2)
    obj.push(0)
    obj.push(-3)
    println(obj.getMin())
    obj.pop()
    println(obj.top())
    println(obj.getMin())
}

