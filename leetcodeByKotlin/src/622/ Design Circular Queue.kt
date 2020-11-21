package LeetCode_622

/**
 * 622. Design Circular Queue (设计环形队列)
 * https://leetcode.com/problems/design-circular-queue/description/
 *
 * Your implementation should support following operations:
MyCircularQueue(k): Constructor, set the size of the queue to be k.
Front: Get the front item from the queue. If the queue is empty, return -1.
Rear: Get the last item from the queue. If the queue is empty, return -1.
enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
isEmpty(): Checks whether the circular queue is empty or not.
isFull(): Checks whether the circular queue is full or not.
 * */
class MyCircularQueue(k: Int) {

    /*
    * solution: Array, maintain front and rear
    * */
    var array: IntArray? = null
    var size = 0
    var currentSize = 0
    var front = -1
    //rear always pointed to the available location where can insert new data
    var rear = -1

    /** Initialize your data structure here. Set the size of the queue to be k. */
    init {
        this.size = k
        array = IntArray(size)
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        rear = (rear + 1) % size//going round and round concept, for example, 2%5=2, -1%5=-1, 1%-5=1
        array!![rear] = value
        currentSize++
        if (front == -1) {
            front = rear
        }
        return true
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        //move the front to next
        //val deQeueuElement = array!![front]
        front = (front + 1) % size
        currentSize--
        return true
    }

    /** Get the front item from the queue. */
    fun Front(): Int {
        return if (isEmpty()) -1 else array!![front]
    }

    /** Get the last item from the queue. */
    fun Rear(): Int {
        return if (isEmpty()) -1 else array!![rear]
    }

    /** Checks whether the circular queue is empty or not. */
    fun isEmpty(): Boolean {
        return currentSize == 0
    }

    /** Checks whether the circular queue is full or not. */
    fun isFull(): Boolean {
        return currentSize == array?.size
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */