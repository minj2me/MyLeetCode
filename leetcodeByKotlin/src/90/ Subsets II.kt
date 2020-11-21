package LeetCode_90

/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/description/
 *Given a collection of integers that might contain duplicates, nums, return all possible subsets
 * (the power set,幂集(包括全集和空集)).
Note: The solution set must not contain duplicate subsets.
Example:
Input: [1,2,2]
Output:
[
[2],
[1],
[1,2,2],
[2,2],
[1,2],
[]
]
 * */
class Solution {
    /*
    * Time complexity is O(2^n), Space complexity is O(2^n),
    * */

    val result = ArrayList<List<Int>>()
    val set = HashSet<List<Int>>()

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val cur = ArrayList<Int>()
        dfs(0, cur, nums)
        println(result)
        return result
    }

    private fun dfs(start: Int, cur: ArrayList<Int>, nums: IntArray) {
        val temp = ArrayList<Int>()
        temp.addAll(cur)
        if (!set.contains(temp)) {
            result.add(temp)
        }
        set.add(temp)
        for (i in start until nums.size) {
            cur.add(nums[i])
            dfs(i + 1, cur, nums)
            //回溯前的清理工作
            cur.removeAt(cur.size - 1)
        }
    }
}