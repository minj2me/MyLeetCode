package LeetCode_260

/**
 * 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:
Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * */
class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        /*
        * solution 1: HaspMap
        * Time complexity:O(n), Space complexity:O(n)
        * */
        /*val result = IntArray(2)
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        var index = 0
        for (m in map) {
            if (m.value == 1) {
                result.set(index, m.key)
                index++
            }
        }*/

        /*
        solution 2: xor
        Time complexity:O(n), Space complexity:O(1)
        * */
        val result = IntArray(2)
        var flag = nums[0]
        //1,2,1,3,2,5
        for (i in 1 until nums.size) {
            flag = flag xor nums[i]
        }
        var x = 0
        var y = 0
        val setBitNumber = flag and (flag - 1).inv()
        for (n in nums) {
            if ((n and setBitNumber) != 0) {
                x = x xor n
            } else {
                y = y xor n
            }
        }
        result[0] = x
        result[1] = y
        return result
    }
}