package LeetCode_47

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
Example:
Input: [1,1,2]
Output:
[
[1,1,2],
[1,2,1],
[2,1,1]
]
 * */
class Solution {
    val result = ArrayList<List<Int>>()
    var used: BooleanArray? = null
    val set = HashSet<ArrayList<Int>>()

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val cur = ArrayList<Int>()
        used = BooleanArray(nums.size)
        dfs(0, cur, nums)
        //println(result)
        return result
    }

    private fun dfs(start: Int, cur: ArrayList<Int>, nums: IntArray) {
        if (start == nums.size) {
            val temp = ArrayList<Int>()
            temp.addAll(cur)
            if (!set.contains(temp)) {
                result.add(temp)
            }
            set.add(temp)
            return
        }
        for (i in nums.indices) {
            if (used!![i]) {
                continue
            }
            used!![i] = true
            cur.add(nums[i])
            dfs(start + 1, cur, nums)
            cur.removeAt(cur.size - 1)
            used!![i] = false
        }
    }
}