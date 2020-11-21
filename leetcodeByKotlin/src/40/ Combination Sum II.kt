package LeetCode_40

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
Each number in candidates may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
[1, 7],
[1, 2, 5],
[2, 6],
[1, 1, 6]
]
 * */
class Solution {
    private val result = ArrayList<ArrayList<Int>>()
    /**
     * solution: dfs;
     * Time complexity:O(2^n): every step there is a choice to add the number to combination or not;
     * Space complexity:O(n)
     * */
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        dfs(0, candidates, target, ArrayList())
        return result
    }

    private fun dfs(start: Int, candidates: IntArray, target: Int, cur: ArrayList<Int>) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            val temp = ArrayList(cur)
            result.add(temp)
            return
        }
        for (i in start until candidates.size) {
            //since each number in candidates may only be used once in the combination.
            if (i != start && candidates[i] == candidates[i - 1]) {
                continue
            }
            cur.add(candidates[i])
            dfs(i + 1, candidates, target - candidates[i], cur)
            cur.removeAt(cur.size - 1)
        }
    }
}