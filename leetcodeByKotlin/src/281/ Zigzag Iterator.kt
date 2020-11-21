package LeetCode_281

import java.util.*

/**
 * 281. Zigzag Iterator
 * (Prime)
 * Given two 1d vectors, implement an iterator to return their elements alternately.
Example:
Input:
v1 = [1,2]
v2 = [3,4,5,6]
Output: [1,3,2,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false,
the order of elements returned by next should be: [1,3,2,4,5,6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question:
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
For example:
Input:
[1,2,3]
[4,5,6,7]
[8,9]
Output: [1,4,8,2,5,9,3,6,7].
 * */
/*
* solution 1: merge two array, Time complexity:O(n1+n2), Space complexity:O(n1+n2)
* */
class ZigzagIterator(v1: List<Int>?, v2: List<Int>?) {

    val list = ArrayList<Int>()
    var index = 0

    init {
        val n1 = v1?.size ?: 0
        val n2 = v2?.size ?: 0
        val n = Math.max(n1, n2)
        for (i in 0 until n) {
            if (i < n1 && v1 != null) {
                list.add(v1[i])
            }
            if (i < n2 && v2 != null) {
                list.add(v2[i])
            }
        }
    }

    fun next(): Int {
        return list.get(index++)
    }

    fun hasNext(): Boolean {
        return index < list.size
    }
}