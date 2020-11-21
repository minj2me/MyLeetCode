package LeetCode_410

/**
 * 410. Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/description/
 *
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.

Example 1:
Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Example 2:
Input: nums = [1,2,3,4,5], m = 2
Output: 9

Example 3:
Input: nums = [1,4,4], m = 3
Output: 4

Constraints:
1. 1 <= nums.length <= 1000
2. 0 <= nums[i] <= 106
3. 1 <= m <= min(50, nums.length)
 * */
class Solution {
    /*
    * solution: DP, Top-Down, (Recursion + Memorization),
    * Time complexity:O(m*n), Space complexity:O(n)
    * */
    fun splitArray(nums: IntArray, m: Int): Int {
        val n = nums.size
        val prefixSumArray = IntArray(n + 1)
        val visited = HashMap<String, Int>()
        prefixSumArray[0] = 0
        for (i in 1..n) {
            prefixSumArray[i] = prefixSumArray[i - 1] + nums[i - 1]
        }
        return dfs(0, m, nums, prefixSumArray, visited)
    }

    private fun dfs(index: Int, m: Int, nums: IntArray, prefixSumArray: IntArray, visited:HashMap<String, Int>): Int {
        if (m == 1) {
            return prefixSumArray[nums.size] - prefixSumArray[index]
        }
        val key = "$index-$m"
        if (visited.contains(key)){
            return visited.get(key)!!
        }
        var res = Int.MAX_VALUE
        for (i in index until nums.size - 1) {
            //sum of index to i
            val l = prefixSumArray[i + 1] - prefixSumArray[index]
            //sum of i+1 to nums.size
            val r = dfs(i + 1, m - 1, nums, prefixSumArray, visited)
            res = Math.min(res, Math.max(l, r))
        }
        visited.put(key, res)
        return res
    }
}