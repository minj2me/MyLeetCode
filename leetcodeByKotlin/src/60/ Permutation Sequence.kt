package LeetCode_60

import java.lang.StringBuilder

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:
Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:
Input: n = 3, k = 3
Output: "213"

Example 2:
Input: n = 4, k = 9
Output: "2314"
 * */
class Solution {
    /**
     * solution 1: dfs+backtracking will, TLE
     * solution 2: do Next Permutation k-1 time, Time complexity:O(k*n^2)
     * */
    fun getPermutation(n: Int, k: Int): String {
        val nums = IntArray(n)
        for (i in 0 until n) {
            nums[i] = i + 1
        }
        var k_ = k
        while (k_>1){
            nextPermutation(nums)
            k_--
        }
        val sb = StringBuilder()
        for (i in 0 until n) {
            sb.append(nums[i])
        }
        return sb.toString()
    }

    private fun nextPermutation(nums: IntArray) {
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                val large = nextLargeIndex(nums, i)
                swap(nums, i, large)
                reverse(i+1,nums)
                return
            }
        }
        nums.sort()
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun nextLargeIndex(nums: IntArray, index: Int): Int {
        for (i in nums.size - 1 downTo index) {
            if (nums[i] > nums[index]) {
                return i
            }
        }
        return 0
    }

    private fun reverse(index: Int, nums: IntArray) {
        var i = index
        var j = nums.size - 1
        while (i <= j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
}