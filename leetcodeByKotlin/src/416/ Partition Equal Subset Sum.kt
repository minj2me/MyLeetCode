package LeetCode_416

/**
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.

Example 1:
Input: [1, 5, 11, 5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: [1, 2, 3, 5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 * */
class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 != 0) {
            return false
        }
        return dfs(0, 0, nums, total, HashMap())
    }

    /*
   * solution:recursion + memorization (Top-Down);
   * if without memorization, Time complexity:O(2^n);
   * now with memorization, Time complexity:O(n*m),
   * where m is total of there different num we have, Space complexity:O(n);
   * */
    private fun dfs(index: Int, sum: Int, nums: IntArray, total: Int, map: HashMap<String, Boolean>): Boolean {
        //set a key for map
        val key = "$index-$sum"
        if (map.containsKey(key)) {
            return map.get(key)!!
        }
        if (sum * 2 == total) {
            //got the result
            return true
        }
        if (sum > total / 2 || index >= nums.size) {
            return false
        }
        //not choice and choice, 2 situation
        val result = dfs(index + 1, sum, nums, total, map)
                || dfs(index + 1, sum + nums[index], nums, total, map)
        map.put(key, result)
        return result
    }

    private fun dp(size: Int) {
        //try to use 0/1 knapsack to solve it
        /*
        n:N items, item i weight is w[i], item i value is v[i]
        dp[i][j] represent the large profile of first i items just can put in knapsack which maximum capacity is w
        * 0/1 knapsack formulate: dp[i][j] = max(dp[i-1][j], dp[i][j-w[i]]+v[i])
        * */

        val dp = Array(size + 1, { IntArray(size + 1) })
        //dp[i][j]: whether can sum sum up to j use first i num
        dp[-1][0] = 1

    }
}