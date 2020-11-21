package LeetCode_941

/**
 * 941. Valid Mountain Array
 * https://leetcode.com/problems/valid-mountain-array/description/
 *
 * Given an array A of integers, return true if and only if it is a valid mountain array.
Recall that A is a mountain array if and only if:
A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
 * */
class Solution {
    fun validMountainArray(A: IntArray): Boolean {
        if (A.size < 3) {
            return false
        }
        /*
        * -has_down happened before has_up
          -not has_down or not has_up
        * */
        val n = A.size
        var hasDown = false
        var hasUp = false
        for (i in 0 until n - 1) {
            if (A[i] < A[i + 1]) {//is going up
                if (hasDown) {
                    return false
                }
                hasUp = true
            } else if (A[i] > A[i + 1]) {//is going down
                //if hasDown happened before hasUp
                if (!hasUp) {
                    return false
                }
                hasDown = true
            } else {
                //can not be equal
                return false
            }
        }
        return hasUp && hasDown
    }
}