package LeetCode_78

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/description/
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
Example:
Input: nums = [1,2,3]
Output:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
 * */
class Solution {
    /*
    * Time complexity is O(2^n), Space complexity is O(2^n),
    * */
    fun subsets(A: IntArray): List<List<Int>> {
        A.sort()
        val result = ArrayList<ArrayList<Int>>()
        helper(result, ArrayList<Int>(), A, 0)
        return result
    }

    fun helper(result: ArrayList<ArrayList<Int>>, arr: ArrayList<Int>, A: IntArray, index: Int) {
        println("index:$index")
        result.add(ArrayList(arr))//new reference for arr
        for (i in index until A.size) {
            println("i:$i")
            arr.add(A[i])
            helper(result, arr, A, i + 1)
            //回溯前的清理工作
            println("begin to backtracking")
            arr.removeAt(arr.size - 1)
            println("removed")
        }
        println("=========")
    }
}