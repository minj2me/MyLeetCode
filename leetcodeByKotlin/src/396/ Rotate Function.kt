package LeetCode_396

/**
 * 396. Rotate Function
 * https://leetcode.com/problems/rotate-function/description/
 *
 * Given an array of integers A and let n to be its length.
Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:
A = [4, 3, 2, 6]
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * */
class Solution {
    fun maxRotateFunction(A: IntArray): Int {
        if (A.size == 0) {
            return 0
        }
        var max = Int.MIN_VALUE
        val size = A.size
        //calculate each num times index for every left rotate
        //Time complexity: O(n*n)
        for (i in size downTo 1) {
            max = Math.max(getSum(A, i), max)
        }
        return max
    }

    private fun getSum(array: IntArray, d: Int): Int {
        var sum = 0
        val size = array.size
        for (i in 0 until size) {
            var newIndex = i - d
            if (newIndex < 0) {
                newIndex += size
            }
            sum += newIndex * array[i]
        }
        return sum
    }
}