package LeetCode_251

/**
 * 251. Flatten 2D Vector
 * (Prime)
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.

Example:
Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
iterator.next(); // return 1
iterator.next(); // return 2
iterator.next(); // return 3
iterator.hasNext(); // return true
iterator.hasNext(); // return true
iterator.next(); // return 4
iterator.hasNext(); // return false

Notes:
1. Please remember to RESET your class variables declared in Vector2D,
as static/class variables are persisted across multiple test cases. Please see here for more details.
2. You may assume that next() call will always be valid, that is,
there will be at least a next element in the 2d vector when next() is called.
 * */

/*
* Solution: change 2d array into 1d array
* */
class Vector2D(twoDArray: Array<IntArray>) {

    var array: IntArray? = null
    var index = 0
    var size = 0

    init {
        //calculate the size of 1d array
        for (array in twoDArray) {
            size += array.size
        }
        array = IntArray(size)
        //fill array
        var i = 0
        for (array_ in twoDArray) {
            for (num in array_) {
                array!![i++] = num
            }
        }
    }

    fun next(): Int {
        return array!![index++]
    }

    fun hasNext(): Boolean {
        return index < size
    }
}