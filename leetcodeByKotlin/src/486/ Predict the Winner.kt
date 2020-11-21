package LeetCode_486

/**
 * 486. Predict the Winner
 * https://leetcode.com/problems/predict-the-winner/description/
 * https://www.youtube.com/watch?v=g5wLHFTodm0
 *
 * Min-Max策略:大家都是拿最大的分数，直到拿完;
 * 1.先把递归树画出来，到游戏结束时，我们有最终分数，然后backtracking to parent;
 * 2.parent会在所有的children选择最有利的;
 * */
class Solution {

    private var array: Array<IntArray>? = null

    fun PredictTheWinner(nums: IntArray): Boolean {
        /*
        solution 1: Min-Max
        * Time complexity: O(2^n)
        * Space complexity: O(n), recursion stack
        * */
        //return getScore(nums, 0, nums.size - 1) >= 0

        /*
        * solution 2: Min-Max with recursion + memorization
        * Time complexity: O(n*n)
        * Space complexity: O(n*n)
        * */
        array = Array(nums.size) { IntArray(nums.size) }
        return getScore(nums, 0, nums.size - 1) >= 0
    }

    private fun getScore(nums: IntArray, left: Int, right: Int): Int {
        if (left == right) {
            return nums[left]
        }
        if (array!![left][right] > 0) {
            return array!![left][right]
        }
        //compare each player can get
        array!![left][right] = Math.max(
            nums[left] - getScore(nums, left + 1, right),
            nums[right] - getScore(nums, left, right - 1)
        )
        return array!![left][right]
    }
}