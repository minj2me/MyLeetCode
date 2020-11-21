package _interview_question

/**
 * Facebook | Phone screen | Count subsets
 * https://leetcode.com/discuss/interview-question/275785/facebook-phone-screen-count-subsets
 *
 * Input:
Given an array A of
-positive
-sorted
-no duplicate
-integer
A positive integer k

Output:
Count of all such subsets of A,
Such that for any such subset S,
Min(S) + Max(S) = k
subset should contain atleast two elements

input: {1,2,3,4,5}
 * */
class Solution {

    private val map = HashMap<Int, Int>()
    private var result = 0.0

    fun subSetMinMaxEqualK(nums: IntArray, k: Int): Int {
        //1.backtracking, Time complexity: O(2^n), Space complexity:O(n)
        //dfs(0, nums, ArrayList<Int>(), k)

        //2.use map, just like 2 sum
        //Time complexity: O(nlogn), Space complexity:O(n)
        nums.sort()
        for (i in nums.indices) {
            val needFind = k - nums[i]
            if (map.containsKey(needFind)) {
                //Number of subsequences of n is (2**n -1)
                val value = i - map.get(needFind)!! - 1
                //1,2,3,4,5; k = 5, {1 4} there are 4 cases 2^2
                result += Math.pow(2.0, value.toDouble())
            }
            map.put(nums[i], i)
        }
        return result.toInt()
    }

    private fun dfs(n: Int, nums: IntArray, cur: ArrayList<Int>, target: Int) {
        val temp = ArrayList<Int>(cur)
        val min = temp.min() ?: 0
        val max = temp.max() ?: 0
        val value = min + max
        if (value == target) {
            result++
        }
        for (i in n until nums.size) {
            cur.add(nums[i])
            dfs(i + 1, nums, cur, target)
            cur.removeAt(cur.size - 1)
        }
    }

}