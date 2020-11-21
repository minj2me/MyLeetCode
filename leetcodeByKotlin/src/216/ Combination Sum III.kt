package LeetCode_216

/**
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:
All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
 * */
class Solution {
    /**
     * solution: dfs, Time complexity:O(n^target), Space complexity:O(n)
     * */
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        //dfs
        val candidates = intArrayOf(1,2,3,4,5,6,7,8,9)
        val result = ArrayList<ArrayList<Int>>()
        dfs(result, candidates, 0, ArrayList<Int>(), n,k)
        return result
    }

    private fun dfs(result: ArrayList<ArrayList<Int>>, candidates: IntArray, s: Int, cur: ArrayList<Int>, target: Int, k:Int) {
        if (target == 0 && cur.size==k) {
            result.add(ArrayList(cur))
            return
        }
        for (i in s until candidates.size) {
            //pruning
            if (candidates[i] > target) {
                return
            }
            cur.add(candidates[i])
            //use i+1, because each combination should be a unique set of numbers, so cannot use number used last level
            dfs(result, candidates, i+1, cur, target - candidates[i], k)
            cur.removeAt(cur.size - 1)
        }
    }
}