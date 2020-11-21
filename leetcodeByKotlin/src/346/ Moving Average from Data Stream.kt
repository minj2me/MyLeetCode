package LeetCode_346

import java.util.*

/**
 * 346. Moving Average from Data Stream
 * (Prime)
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
Example:
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 * */
class MovingAverage constructor(size: Int) {
    /*
    solution: Stack, keep checking the size
    * */
    var size = 0
    val queue = LinkedList<Int>()
    var sum = 0.0

    init {
        this.size = size
    }

    fun next(value: Int): Double {
        sum += value
        queue.offer(value)
        if (queue.size <= size) {
            return sum / queue.size
        }
        sum -= queue.pop()
        return sum / size
    }
}