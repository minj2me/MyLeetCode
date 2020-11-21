package LeetCode_738

import java.lang.StringBuilder

/**
 * 738. Monotone Increasing Digits
 * https://leetcode.com/problems/monotone-increasing-digits/description/
 *
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
 * */
class Solution {
    fun monotoneIncreasingDigits(N: Int): Int {
        val nArray = N.toString().toCharArray()
        val size = nArray.size
        var j = size//用于记录要转换的位置
        for (i in size - 1 downTo 1) {
            if (nArray[i] >= nArray[i - 1]) {
                continue
            }
            //要找到从后往前遍历的最后一个值升高的位置，让前一位减1
            nArray[i - 1]--
            j = i
        }
        //并把当前位以及后面的所有位都变成9
        for (i in j until size) {
            nArray[i] = '9'
        }
        val sb = StringBuilder()
        for (item in nArray) {
            sb.append(item)
        }
        return sb.toString().toInt()
    }
}