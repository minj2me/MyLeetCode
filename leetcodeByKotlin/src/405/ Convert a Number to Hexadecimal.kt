package LeetCode_405

import java.lang.StringBuilder

/**
 * 405. Convert a Number to Hexadecimal
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 * https://www.youtube.com/watch?v=QJW6qnfhC70
 * */
class Solution {
    fun toHex(num_: Int): String {
        if (num_ == 0) {
            return "0"
        }
        val map = mapOf(
            0 to "0",
            1 to "1",
            2 to "2",
            3 to "3",
            4 to "4",
            5 to "5",
            6 to "6",
            7 to "7",
            8 to "8",
            9 to "9",
            10 to "a",
            11 to "b",
            12 to "c",
            13 to "d",
            14 to "e",
            15 to "f"
        )
        var num = num_
        val sb = StringBuilder()
        var remainder = 0
        while (num != 0) {
            //let positive and negative both can calculated in hexadecimal
            remainder = (16 + num % 16) % 16
            sb.insert(0,map.get(remainder))
            //ushr: 无符号右移，高位补0（都在高位插入0）
            //because num can be a negative. so use unsigned right shift
            num = num ushr  4
        }
        return sb.toString()
    }
}