package LeetCode_414

/**
 * 414. Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
Example 1:
Input: [3, 2, 1]
Output: 1
Explanation: The third maximum is 1.
 * */
class Solution {
    /*
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun thirdMax(nums: IntArray): Int {
        var max1: Int? = null
        var max2: Int? = null
        var max3: Int? = null
        for (num in nums) {
            //avoid some same continue number
            if (num == max1 || num == max2 || num == max3) {
                continue
            }
            if (max1 == null || num > max1) {
                max3 = max2
                max2 = max1
                max1 = num
            } else if (max2 == null || num > max2) {
                max3 = max2
                max2 = num
            } else if (max3 == null || num > max3) {
                max3 = num
            }
        }
        return if (max3 == null) max1!! else max3
    }
}