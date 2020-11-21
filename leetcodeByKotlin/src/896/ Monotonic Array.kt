package LeetCode_896

/**
 * 896. Monotonic Array
 * https://leetcode.com/problems/monotonic-array/description/
 * */
class Solution {
    fun isMonotonic(A: IntArray): Boolean {
        var increaing = true
        var decreaing = true
        for (i in 0 until A.size - 1) {
            if (A[i] > A[i + 1]) {
                increaing = false
            }
            if (A[i] < A[i + 1]) {
                decreaing = false
            }
        }
        return increaing || decreaing
    }
}