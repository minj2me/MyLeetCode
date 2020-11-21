package LeetCode_446

/**
 * 446. Arithmetic Slices II - Subsequence
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, these are arithmetic sequences:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given.
A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic.
In particular, this means that k ≥ 2.
The function should return the number of arithmetic subsequence slices in the array A.
The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000.
The output is guaranteed to be less than 231-1.

Example:
Input: [2, 4, 6, 8, 10]
Output: 7
Explanation:
All arithmetic subsequence slices are:
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
 * */
class Solution {
    /*
    * solution: Array + HashMap
    *
    * */
    fun numberOfArithmeticSlices(A: IntArray): Int {
        var result = 0
        val n = A.size
        /*
        * map's key is : the different of two number
        * map's value is : the count of element in Arithmetic Subsequence that has same different
        * */
        val maps = Array<HashMap<Int, Int>>(n, { HashMap() })
        for (i in 0 until n) {
            maps[i] = HashMap()
            val num = A[i]
            for (j in 0 until i) {
                if (A[j].toLong()-num > Int.MAX_VALUE){
                    continue
                }
                if (A[j].toLong()-num < Int.MIN_VALUE){
                    continue
                }
                var diff = A[j] - A[i]
                val mapi = maps[i]
                val mapj = maps[j]
                val count = mapj.getOrDefault(diff, 0)
                mapi.put(diff, mapi.getOrDefault(diff, 0) + count + 1)
                result += count
            }
        }
        println("result:$result")
        return result
    }
}