package _interview_question

/**
 * Given a list/array of integers, return a boolean that states whether all numbers appear an even number of times.

Example 1:
Input: [3, 1, 2, 1, 2, 3]
Output: true

Example 2:
Input: [1, 2, 1]
Output: false

Example 3:
Input: [1, 2, 3]
Output: false
 * */
class Solution4 {
    fun findAllIfAppearEvenTime(nums: IntArray): Boolean {
        /*
        method 1: Time complexity: O(n), Space complexity: O(n)
        * */
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        for (item in map) {
            if (item.value % 2 != 0) {
                return false
            }
        }
        return true

        /*
        * method 2: Time complexity: O(nlogn), Space complexity: O(1)
        * */
        if (nums.size % 2 != 0) {
            return false
        }
        nums.sort()
        var sameNumAppearCount = 1
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                sameNumAppearCount++
            } else {
                if (sameNumAppearCount % 2 != 0) {
                    return false
                } else {
                    sameNumAppearCount = 1
                }
            }
        }
        return true
    }
}