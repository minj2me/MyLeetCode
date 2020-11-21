package LeetCode_246

/**
 * 246. Strobogrammatic Number
 * (locked by Leetcode)
 * https://www.lintcode.com/problem/strobogrammatic-number/description
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:
Input:  "69"
Output: true

Example 2:
Input:  "88"
Output: true

Example 3:
Input:  "962"
Output: false
 * */
class Solution {
    /*
    * 这道题定义了一种对称数，就是说一个数字旋转 180 度和原来一样，也就是倒过来看一样，比如 609，倒过来还是 609 等等，
    * 满足这种条件的数字其实没有几个，只有 0,1,8,6,9。
    * 这道题其实可以看做求回文数的一种特殊情况，还是用双指针来检测，
    * 首尾两个数字如果相等的话，只有它们是 0 or 1 or 8 才行，
    * 如果它们不相等的话，必须一个是6一个是9，或者一个是9一个是6，其他所有情况均返回 false
    * */
    fun isStrobogrammatic(num: String): Boolean {
        var i = 0
        var j: Int = num.length - 1
        val chars = num.toCharArray()
        while (i <= j) {
            if (chars[i] == chars[j]) {
                if (chars[i] != '0' && chars[i] != '1' && chars[i] != '8') {
                    return false
                }
            } else {
                if ((chars[i] != '6' || chars[j] != '9') && (chars[i] != '9' || chars[j] != '6')) {
                    return false
                }
            }
            i++
            j--
        }
        return true
    }
}