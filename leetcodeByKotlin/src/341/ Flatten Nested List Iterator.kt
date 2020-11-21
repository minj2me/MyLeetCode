package LeetCode_341

/**
 * 341. Flatten Nested List Iterator
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 *
 * Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,1,2,1,1].
 * */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */

class NestedInteger {
    fun getInteger(): Int {
        return 0
    }

    fun isInteger(): Boolean {
        return true
    }

    fun getList(): List<NestedInteger> {
        return ArrayList()
    }
}

class NestedIterator(nestedList: List<NestedInteger>) {

    val numList = ArrayList<Int>()
    var index = 0

    init {
        add(nestedList)
    }

    private fun add(nestedList: List<NestedInteger>){
        for (item in nestedList) {
            if (item.getInteger()!=null) {
                numList.add(item.getInteger())
            } else {
                //Return null if this NestedInteger holds a nested list
                add(item.getList())
            }
        }
    }

    fun next(): Int {
        return numList.get(index++)
    }

    fun hasNext(): Boolean {
        return index < numList.size
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */