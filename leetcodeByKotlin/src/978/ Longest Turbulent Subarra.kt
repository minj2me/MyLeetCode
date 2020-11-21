package LeetCode_978

/**
 * 978. Longest Turbulent Subarray
 * https://leetcode.com/problems/longest-turbulent-subarray/description/
 *
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 *OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
Return the length of a maximum size turbulent subarray of A.

Example 1:
Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * */
class Solution {
    /*
    * solution: Sliding Window, Time complexity:O(n), Space complexity:O(1)
    * */
    fun maxTurbulenceSize(A: IntArray): Int {
        if (A == null || A.isEmpty()) {
            return 0
        }
        if (A.size == 1) {
            return 1
        }
        val len = A.size
        var max = 0
        var left = 0
        var right = 1
        while (right < len) {
            if (isZigZag(A, left, right)) {
                max = Math.max(max, right - left + 1)
                right++
                continue
            }
            //if the two number in left and right are equal
            //for example:[9,9]
            if (A[right] == A[right - 1]) {
                left = right
                max = Math.max(max, right - left + 1)
                right++
                continue
            }
            left = right - 1
            right++
        }
        return max
    }

    //4,2,10,7,8 is zigzag
    private fun isZigZag(array: IntArray, start: Int, end: Int): Boolean {
        if (array[start] == array[start + 1]) {
            return false
        }
        var increasing = array[start] < array[start + 1]
        for (i in start + 1 until end) {
            //turn it each time
            increasing = !increasing
            if (increasing && array[i] >= array[i + 1] || !increasing && array[i] <= array[i + 1]) {
                return false
            }
        }
        return true
    }
}