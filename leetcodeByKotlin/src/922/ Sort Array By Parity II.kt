package LeetCode_922

/**
 * 922. Sort Array By Parity II
 *https://leetcode.com/problems/sort-array-by-parity-ii/description/
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
You may return any answer array that satisfies this condition.

Example 1:
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * */
class Solution {
    fun sortArrayByParityII(A: IntArray): IntArray {
        val size = A.size
        val array1 = ArrayList<Int>(size / 2)
        val array2 = ArrayList<Int>(size / 2)
        for (a in A) {
            if (a % 2 == 0) {
                array1.add(a)
            } else {
                array2.add(a)
            }
        }
        val result = ArrayList<Int>(size)
        var x = 0
        var y = 0
        for (i in 0 until size) {
            if (i % 2 == 0) {
                result.add(array1.get(x))
                x++
            } else {
                result.add(array2.get(y))
                y++
            }
        }
        return result.toIntArray()
    }
}