package LeetCode_989

/**
 * 989. Add to Array-Form of Integer
 * https://leetcode.com/problems/add-to-array-form-of-integer/description/
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

Example 1:
Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:
Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:
Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 * */
class Solution {
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {
        val result = ArrayList<Int>()
        val kStr = K.toString()
        var i = A.size - 1
        var j = kStr.length - 1
        var carry = 0
        while (i >= 0 || j >= 0) {
            var temp = 0
            if (i >= 0) {
                temp += A[i]
            }
            if (j >= 0) {
                temp += (kStr[j].toInt() - '0'.toInt())
            }
            temp += carry
            if (temp >= 10) {
                /*
                也学习下英文：
                * 个位 ones place
                * 个位数 ones digit
                * 十位 tens place
                * 十位数 tens digit
                * 百位 hundreds place
                * 百位数 hundreds digit
                * 千位 thousands place
                * 千位数 thousands digit
                * */
                carry = temp / 10//get carry, if temp is 15 then carry is 1
                temp %= 10//get ones digit, if temp is 15 then ones digit is 5
            } else {
                carry = 0
            }
            result.add(0, temp)
            i--
            j--
        }
        if (carry != 0) {
            result.add(0, carry)
        }
        return result
    }
}