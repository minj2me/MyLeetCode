package LeetCode_698

/**
 * 698. Partition to K Equal Sum Subsets
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Note:
1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 * */
class Solution {
    /*
    * solution: dfs , Time complexity:O(n!), Space complexity:O(n)
    * */
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        //because we have to find k subset, so sum of each subset is nums.sum/k
        val sum = nums.sum()
        if (sum % k != 0) {
            //can not find k subset
            return false
        }
        val target = sum / k
        val visited = BooleanArray(nums.size)
        nums.sort()
        return dfs(nums, k, 0, target, visited, 0)
    }

    private fun dfs(nums: IntArray, k: Int, curSum: Int, target: Int, visited: BooleanArray, start: Int): Boolean {
        //println("target:$target")
        //println("curSum:$curSum")
        if (k == 0) {
            //found the result
            return true
        }
        if (curSum > target) {
            return false
        }
        if (curSum == target) {
            //find out 1 result, set k-1 and curSum=0 to find the next one in next level
            return dfs(nums, k - 1, 0, target, visited, 0)
        }
        for (i in start until nums.size) {
            if (visited[i]) {
                continue
            }
            visited[i] = true
            if (dfs(nums, k, curSum + nums[i], target, visited, i + 1)) {
                return true
            }
            visited[i] = false
        }
        return false
    }
}