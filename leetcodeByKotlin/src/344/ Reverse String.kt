package LeetCode_344

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 * Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.
 * */
class Solution {
    /*
    * Time:O(n), Space:O(1)
    * */
    fun reverseString(s: CharArray): Unit {
        //s.reverse()
        var i = 0
        var j = s.size - 1
        while (i < j) {
            val temp = s[i]
            s[i] = s[j]
            s[j] = temp
            i++
            j--
        }
    }
}