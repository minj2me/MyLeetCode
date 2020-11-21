package LeetCode_1646

/**
 * 1646. Get Maximum in Generated Array
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 *
 * You are given an integer n. An array nums of length n + 1 is generated in the following way:
nums[0] = 0
nums[1] = 1
nums[2 * i] = nums[i] when 2 <= 2 * i <= n
nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
Return the maximum integer in the array nums​​​.
 * */
class Solution {
    fun getMaximumGenerated(n: Int): Int {
        if (n == 0) {
            return 0
        }
        val array = IntArray(n + 1)
        array[0] = 0
        array[1] = 1
        for (i in array.indices) {
            //follow by topic
            if ((2 * i) <= n) {
                array[2 * i] = array[i]
            }
            if ((2 * i + 1) <= n) {
                array[2 * i + 1] = array[i] + array[i + 1]
            }
        }
        return array.max()!!
    }
}