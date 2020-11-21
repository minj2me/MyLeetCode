package _interview_question

/**
 * Given an array of integers nums and a positive sum k & it's possible to divide this array into non-empty subsets whose sums are equal to K.
Return the list of sub arrays.

Example 1:
Input: nums = [0,2,4,2,0,4], k = 4
Output: [0,2,2],[0,4],[4] or [0,0,2,2],[4],[4] or.... Return any list of sub arrays/ list of sub lists.
Explanation:
0+2+2 = 4 , 0+4 =4 , 4=4
or
0+0+2+2 = 4, 4=4
 * */
class Solution5 {
    /*
    * solution: bfs+backtracking
    * */
    private val result = ArrayList<ArrayList<Int>>()

    fun partitionArrayToKSum(nums: IntArray, k: Int): ArrayList<ArrayList<Int>> {
        dfs(0, nums, ArrayList(), k)
        println(result)
        return result
    }

    private fun dfs(n: Int, nums: IntArray, cur: ArrayList<Int>, target: Int) {
        val temp = ArrayList<Int>(cur)
        //val min = temp.min() ?: 0
        //val max = temp.max() ?: 0
        //val value = min + max
        if (temp.sum() == target) {
            result.add(temp)
        }
        for (i in n until nums.size) {
            cur.add(nums[i])
            dfs(i + 1, nums, cur, target)
            cur.removeAt(cur.size - 1)
        }
    }
}