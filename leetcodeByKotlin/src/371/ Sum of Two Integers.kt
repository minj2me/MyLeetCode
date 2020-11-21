package LeetCode_371

/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/description/
 * https://www.polarxiong.com/archives/LeetCode-371-sum-of-two-integers.html
 * */
class Solution {
    fun getSum(a: Int, b: Int): Int {
        var carry = a and b
        var result = a xor b
        while (carry != 0) {
            val shiftCarry = carry shl 1
            carry = result and shiftCarry
            result = result xor shiftCarry
        }
        return result
    }
}