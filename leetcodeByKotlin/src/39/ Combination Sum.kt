package LeetCode_39

/**
 * 39. Combination Sum
 * https://leetcode.com/problems/combination-sum/description/
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
[7],
[2,2,3]
]
 * */
class Solution {
    /**
     * solution: dfs, Time complexity:O(n^target), Space complexity:O(n)
     * */
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        //candidates.sort()
        dfs(result, candidates, 0, ArrayList<Int>(), target)
        println(result)
        return result
    }

    private fun dfs(result: ArrayList<ArrayList<Int>>, candidates: IntArray, s: Int, cur: ArrayList<Int>, target: Int) {
        if (target == 0) {
            result.add(ArrayList(cur))
            return
        }
        for (i in s until candidates.size) {
            //pruning
            if (candidates[i] > target) {
                return
            }
            cur.add(candidates[i])
            dfs(result, candidates, i, cur, target - candidates[i])
            cur.removeAt(cur.size - 1)
        }
    }
}