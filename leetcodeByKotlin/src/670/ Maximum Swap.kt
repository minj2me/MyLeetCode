package LeetCode_670


/**
 * 670. Maximum Swap
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
 * */
class Solution {
    /*
    * solution: Array，Time complexity:O(n), Space complexity:O(1)
    * */
    fun maximumSwap(num: Int): Int {
        val digits = num.toString().toCharArray()
        val map = IntArray(10)
        for (i in digits.indices) {
            map[digits[i] - '0'] = i
        }
        /*
        * array for saving last position of digit in this num, for example: 98368
        map is: 0,0,0,2,0,0,3,0,4,0, mean:
        last position of 9 is 0,
        last position of 8 is 4,
        last position of 3 is 2,
        last position of 6 is 3
        * */
        for (i in digits.indices) {
            //For each position,
            //we check whether there exists a larger digit in this num (start from 9 to current digit)
            for (d in 9 downTo digits[i] - '0' + 1) {
                /*
                * for example: 2736, the position of largest digit (7) is 1, 1 is behind 0, so swap they are,
                * */
                if (map[d] > i) {
                    swap(digits, map[d], i)
                    return String(digits).toInt()
                }
            }
        }
        //if no need swap, return original num
        return num
    }

    private fun swap(chars: CharArray, start: Int, end: Int) {
        val temp = chars[end]
        chars[end] = chars[start]
        chars[start] = temp
    }

    private fun arrayToNum(array: CharArray): Int {
        var result = 0
        for (item in array) {
            if (item.equals("")) {
                continue
            }
            result *= 10
            result += (item - '0')
        }
        return result
    }

}