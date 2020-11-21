package LeetCode_46

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 * Given a collection of distinct integers, return all possible permutations.
Example:
Input: [1,2,3]
Output:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]
 * */
class Solution {
    val result = ArrayList<List<Int>>()
    var userd: BooleanArray? = null

    fun permute(nums: IntArray): List<List<Int>> {
        val cur = ArrayList<Int>()
        userd = BooleanArray(nums.size)
        dfs(0, cur, nums)
        return result
    }

    /**
     * dfs + backtracking, Time complexity: O(n!), Space complexity:O(n!)
     * */
    fun dfs(n: Int, cur: ArrayList<Int>, nums: IntArray) {
        if (n == nums.size) {
            val temp = ArrayList<Int>()
            temp.addAll(cur)//这里是cur的引用,如果不new一个保存，到最后会为空，因为有cur.removeAt的操作
            result.add(temp)
            return
        }
        for (i in nums.indices) {
            if (userd!![i]) {
                continue
            }
            userd!![i] = true
            cur.add(nums[i])
            dfs(n + 1, cur, nums)
            cur.removeAt(cur.size - 1)// as cur pop()
            userd!![i] = false
        }
    }
}