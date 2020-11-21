package LeetCode_238

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array(including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity?
(The output array does not count as extra space for the purpose of space complexity analysis.)
 * */
class Solution {
    /*
    * solution 1: prefix_array and suffix_array, Time complexity:O(n), Space complexity:O(n);
    * solution 2: Time complexity:O(n), Space complexity:O(1);
    * */
    fun productExceptSelf(nums: IntArray): IntArray {
        //solution 1
        val n = nums.size

        val prefixArray = IntArray(n,{1})
        val suffixArray = IntArray(n,{1})

        var prefixProduct = 1
        for (i in 1 until n) {
            prefixProduct *= nums[i-1]
            prefixArray[i] = prefixProduct
        }

        //for example:1,2,3,4, now is=>1,1,2,6
        prefixArray.forEach { print("$it,") }

        for (i in n - 1 downTo 1) {
            //println("suffixArray[$i] * nums[$i]:${suffixArray[i] * nums[i]}")
            suffixArray[i-1] = suffixArray[i] * nums[i]
        }

        //for example:1,2,3,4, now is=>24,12,4,1
        suffixArray.forEach { print("$it,") }

        val result = IntArray(n)
        for (i in 0 until n){
            result[i] = prefixArray[i] * suffixArray[i]
        }

        return result

        //solution 2:
        /*val n = nums.size
        val result = IntArray(n)

        var leftProduct = 1
        for (i in nums.indices) {
            result[i] = leftProduct
            leftProduct *= nums[i]
        }

        var rightProduct = 1
        for (i in n-1 downTo 0){
            result[i] *= rightProduct
            rightProduct *= nums[i]
        }

        return result*/

    }
}