package LeetCode_413

/**
 * 413. Arithmetic Slices
 * https://leetcode.com/problems/arithmetic-slices/description/
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, these are arithmetic sequences:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given.
A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of the array A is called arithmetic if the sequence:
A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic.
In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.

Example:
A = [1, 2, 3, 4]
return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * */
class Solution {
    /*
    * solution 1: dfs, TLE;
    * solution 2: scan array and keep checking, Time complexity:O(n), Space complexity:O(1), Accept;
    * */
    var result = 0

    fun numberOfArithmeticSlices(A: IntArray): Int {
        if (A.size < 3) {
            return 0
        }
        //solution 1:
        /*val gap = A[1] - A[0]
        dfs(0, A, ArrayList(), gap)*/

        //solution 2:
        var cur = 0
        for (i in 1 until A.size-1) {
            //for example: 1,2,3
            if (A[i] - A[i - 1] == A[i + 1] - A[i]) {
                cur++
                result += cur
            } else {
                cur = 0
            }
        }
        return result
    }

    private fun dfs(index: Int, A: IntArray, cur: ArrayList<Int>, gap: Int) {
        val temp = ArrayList<Int>(cur)
        if (isArithmeticArray(temp, gap)) {
            result++
        }
        for (i in index until A.size) {
            cur.add(A[i])
            dfs(index + 1, A, cur, gap)
            cur.removeAt(cur.lastIndex)
        }
    }

    private fun isArithmeticArray(nums: ArrayList<Int>, gap: Int): Boolean {
        if (nums.size < 3) {
            return false
        }
        for (i in 0 until nums.size - 1) {
            if ((nums[i + 1] - nums[i]) != gap) {
                return false
            }
        }
        return true
    }
}