package LeetCode_907

/**
 * 907. Sum of Subarray Minimums
 * https://leetcode.com/problems/sum-of-subarray-minimums/description/
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
Since the answer may be large, return the answer modulo 10^9 + 7.

Example 1:
Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * */

class Solution {
    var result = 0
    fun sumSubarrayMins(A: IntArray): Int {
        //1.Brute force, Time complexity:O(n^2), TLE
        //getAllSubArray(A, 0, 0)

    //https://www.youtube.com/watch?v=9-TXIVEXX2w

        //2.
        val kMod = 1000000007
        val n = A.size
        for (i in 0 until n) {
            var left = 0
            //run function: 执行block，返回block的返回
            //change form this: for (int j = i - 1; j >= 0 && A[j] > A[i]; --j, ++left);
            run {
                var j = i - 1
                while (j >= 0 && A.get(j) > A.get(i)) {
                    --j
                    ++left
                }
            }
            var right = 0
            var j = i + 1
            while (j < n && A.get(j) >= A.get(i)) {
                ++j
                ++right
            }
            result = (result + A.get(i) * (left + 1) * (right + 1)) % kMod
        }
        print(result)
        return result
    }

    private fun getAllSubArray(A: IntArray, start: Int, end: Int) {
        //stop if reach the end of the array
        if (end == A.size) {
            return
        }
        if (start > end) {
            //increment the end point and start from 0
            getAllSubArray(A, 0, end + 1)
        } else {
            val list = ArrayList<Int>()
            for (i in start until end) {
                list.add(A[i])
            }
            list.add(A[end])
            result += list.min() ?: 0
            getAllSubArray(A, start + 1, end)
        }
    }

    private fun helper(
        arrayList: ArrayList<ArrayList<Int>>,
        arr: ArrayList<Int>,
        A: IntArray,
        index: Int
    ) {
        val temp = ArrayList<Int>(arr)
        arrayList.add(temp)
        for (i in index..(A.size - 1)) {
            arr.add(A[i])
            helper(arrayList, arr, A, i + 1)
            arr.removeAt(arr.size - 1)
        }
    }
}