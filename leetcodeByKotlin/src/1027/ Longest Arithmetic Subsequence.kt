package LeetCode_1027

import kotlin.collections.HashMap

/**
 * 1027. Longest Arithmetic Subsequence
 * https://leetcode.com/problems/longest-arithmetic-subsequence/description/
 *
 * Given an array A of integers, return the length of the longest arithmetic subsequence in A.
Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1,
and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).

Example 1:
Input: A = [3,6,9,12]
Output: 4
Explanation:
The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
Input: A = [9,4,7,2,10]
Output: 3
Explanation:
The longest arithmetic subsequence is [4,7,10].

Example 3:
Input: A = [20,1,15,3,10,5,8]
Output: 4
Explanation:
The longest arithmetic subsequence is [20,15,10,5].

Constraints:
1. 2 <= A.length <= 1000
2. 0 <= A[i] <= 500
 * */
class Solution {
    /*
    * solution 1: bruce force, 3 loop, Time complexity:O(n^3), Space complexity:O(1)
    * solution 2: Array + HashMap, Time complexity:O(n^2), Space complexity:O(n)
    * */
    fun longestArithSeqLength(A: IntArray): Int {
        if (A.isEmpty()) {
            return 0
        }
        var max = 0
        val n = A.size
        //solution 1:
        /*for (i in 0 until n) {
            for (j in i + 1 until n) {
                val diff = A[j] - A[i]
                //for example: 1,2,3,4, A[j]=2, diff=1, so next should be 2+1
                var next = A[j] + diff
                //because has number 1,2, so current length is 2
                var currentMax = 2
                for (k in j + 1 until n) {
                    if (A[k] == next) {
                        currentMax++
                        next = A[k] + diff
                    }
                    max = Math.max(max, currentMax)
                }
            }
        }*/
        //solution 2:
        /*
        * map's key is : the different of two number
        * map's value is : the count of element in Arithmetic Subsequence that has same different
        * */
        val maps = Array<HashMap<Int, Int>>(n,{ HashMap() })
        for (i in 0 until n) {
            maps[i] = HashMap()
            for (j in 0 until i) {
                val diff = A[j] - A[i]
                val mapi = maps[i]
                val mapj = maps[j]
                //find out the count of element with diff in mapj
                val currentMax = mapj.getOrDefault(diff, 1) + 1
                //save the different in mapi
                mapi.put(diff, currentMax)
                max = Math.max(max, currentMax)
            }
        }
        return max
    }
}