package LeetCode_641

/**
 * 641. Design Circular Deque (设计环形双向队列)
 * https://leetcode.com/problems/design-circular-deque/description/
 *
 * Design your implementation of the circular double-ended queue (deque).
Your implementation should support following operations:
MyCircularDeque(k): Constructor, set the size of the deque to be k.
insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
getRear(): Gets the last item from Deque. If the deque is empty, return -1.
isEmpty(): Checks whether Deque is empty or not.
isFull(): Checks whether Deque is full or not.
 * */
class MyCircularDeque(k: Int) {

    var array: IntArray? = null
    var size = 0
    var currentSize = 0
    var head = 0
    //rear always pointed to the available location where can insert new data
    var tail = 0

    /** Initialize your data structure here. Set the size of the deque to be k. */
    init {
        this.size = k
        this.head = k-1
        array = IntArray(size)
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    fun insertFront(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        array!![head] = value
        head = (head-1+size) % size
        currentSize++
        return true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    fun insertLast(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        array!![tail] = value
        tail = (tail + 1) % size
        currentSize++
        return true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    fun deleteFront(): Boolean {
        if (isEmpty()){
            return false
        }
        head = (head+1)%size
        currentSize--
        return true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    fun deleteLast(): Boolean {
        if (isEmpty()){
            return false
        }
        tail = (tail-1+size)%size
        currentSize--
        return true
    }

    /** Get the front item from the deque. */
    fun getFront(): Int {
        //return if (isEmpty()) -1 else array!![head]
        return if (isEmpty()) -1 else array!![(head + 1) % size]//?
    }

    /** Get the last item from the deque. */
    fun getRear(): Int {
        //return if (isEmpty()) -1 else array!![tail]
        return if (isEmpty()) -1 else array!![(tail - 1 + size) % size]//?
    }

    /** Checks whether the circular deque is empty or not. */
    fun isEmpty(): Boolean {
        return currentSize == 0
    }

    /** Checks whether the circular deque is full or not. */
    fun isFull(): Boolean {
        return currentSize == array?.size
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */