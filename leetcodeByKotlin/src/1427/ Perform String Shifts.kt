package LeetCode_1427

/**
 * 1427. Perform String Shifts
 *
 * You are given a string s containing lowercase English letters,
 * and a matrix shift, where shift[i] = [direction, amount]:
 * direction can be 0 (for left shift) or 1 (for right shift).
amount is the amount by which string s is to be shifted.
A left shift by 1 means remove the first character of s and append it to the end.
Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
Return the final string after all operations.

Example 1:
Input: s = "abc", shift = [[0,1],[1,2]]
Output: "cab"
Explanation:
[0,1] means shift to left by 1. "abc" -> "bca"
[1,2] means shift to right by 2. "bca" -> "cab"

Example 2:
Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
Output: "efgabcd"
Explanation:
[1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
[1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
[0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
[1,3] means shift to right by 3. "abcdefg" -> "efgabcd"

Constraints:
1 <= s.length <= 100
s only contains lower case English letters.
1 <= shift.length <= 100
shift[i].length == 2
0 <= shift[i][0] <= 1
0 <= shift[i][1] <= 100
 * */
class Solution {
    fun shiftString(s: String, shift: Array<IntArray>): String {
        val size = s.length
        var totalShift = 0
        for (item in shift) {
            val direction = item[0]
            val amount = item[1]
            when (direction) {
                0 -> {//left shift
                    totalShift -= amount
                }
                1 -> {//right shift
                    totalShift += amount
                }
            }
        }
        println("totalShift:$totalShift")
        var newFront = ""
        var newBack = ""
        val sb = StringBuilder()

        //totalShift could be grated than size of s
        if (totalShift < 0) {
            //so if totalShift negative,we mod size
            totalShift = Math.abs(totalShift) % size
            println("totalShift2:$totalShift")
            //abcde, [0,2]//move left, 2 shift =>cdeab
            newFront = s.substring(totalShift)//subtring from totalShift to end
            newBack = s.substring(0, totalShift)
        } else if (totalShift > 0) {
            totalShift %= size
            println("totalShift3:$totalShift")
            //abcde, [1,2]//move right, 2 shift =>deabc
            newFront = s.substring(totalShift+1, size)
            newBack = s.substring(0, size - totalShift)

            //println("newFront:$newFront")
            //println("newBack:$newBack")
        } else {
            return s
        }
        sb.append(newFront).append(newBack)
        println(sb.toString())
        return sb.toString()
    }
}