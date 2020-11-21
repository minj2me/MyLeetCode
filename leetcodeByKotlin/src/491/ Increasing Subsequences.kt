package LeetCode_491

/**
 * 491. Increasing Subsequences
 * https://leetcode.com/problems/increasing-subsequences/description/
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 * */
class Solution {
    /*
    * solution: backtracking, Time complexity:O(2^n), Space complexity:O(n)
    * */

    private val result = ArrayList<ArrayList<Int>>()

    fun findSubsequences(nums: IntArray): List<List<Int>>? {
        val set = HashSet<ArrayList<Int>>()
        dfs(0, ArrayList(), nums, set)
        println(result)
        return result
    }

    private fun dfs(index: Int, cur: ArrayList<Int>, nums: IntArray, set:HashSet<ArrayList<Int>>) {
        val temp = ArrayList<Int>(cur)
        if (set.contains(temp)){
            return
        }
        if (temp.size >=2) {
            result.add(temp)
        }
        set.add(temp)
        for (i in index until nums.size) {
            //because need increasing, so if last num larger than current one, skip it
            if (cur.isNotEmpty() && cur.last() > nums[i]){
                continue
            }
            cur.add(nums[i])
            dfs(i + 1, cur, nums,set)
            cur.removeAt(cur.size - 1)
        }
    }
}