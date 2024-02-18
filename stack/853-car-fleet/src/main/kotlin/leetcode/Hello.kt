package leetcode

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val carInfos = position.mapIndexed { index, i ->
            val iSpeed = speed[index]
            CarInfo(i, iSpeed)
        }
        val sortedCars = carInfos.sortedDescending()
        var fleets = 0

        var fleetTime = 0.0
        for (sortedCar in sortedCars) {
            val timeItTakesForCurrentCar = sortedCar.timeItTakes(target)
            if (timeItTakesForCurrentCar > fleetTime) {
                fleets++
                fleetTime = timeItTakesForCurrentCar
            }
        }

        return fleets
    }

    data class CarInfo(val pos: Int, val speed: Int) : Comparable<CarInfo> {
        override fun compareTo(other: CarInfo): Int {
            return this.pos - other.pos
        }

        fun timeItTakes(target: Int): Double = (target - this.pos).toDouble() / this.speed
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    println(sol.carFleet(10, intArrayOf(0,4,2), intArrayOf(2, 1, 3)))
}

