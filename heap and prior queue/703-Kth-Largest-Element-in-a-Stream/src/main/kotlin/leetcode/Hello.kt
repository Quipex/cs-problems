package leetcode

import java.util.*

class KthLargest(private val k: Int, nums: IntArray) {
    private val minHeap = PriorityQueue<Int>()

    init {
        for (num in nums) {
            minHeap.add(num)
        }
        shrinkHeap()
    }

    private fun shrinkHeap() {
        while (this.minHeap.size > this.k) {
            this.minHeap.poll()
        }
    }

    fun add(value: Int): Int {
        this.minHeap.add(value)
        this.shrinkHeap()
        return this.minHeap.peek()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */

fun main(args: Array<String>) {
    val a = KthLargest(1, intArrayOf())
    println(a.add(-3))
    println(a.add(-2))
    println(a.add(-4))
    println(a.add(0))
    println(a.add(4))
}

