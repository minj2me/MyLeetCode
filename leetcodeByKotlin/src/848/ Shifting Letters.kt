package LeetCode_848

/**
 * 848. Shifting Letters
 * https://leetcode.com/problems/shifting-letters/description/
 *
We have a string S of lowercase letters, and an integer array shifts.
Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
Return the final string after all such shifts to S are applied.

Example 1:
Input: S = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation:
We start with "abc".
After shifting the first 1 letters of S by 3, we have "dbc".
After shifting the first 2 letters of S by 5, we have "igc".
After shifting the first 3 letters of S by 9, we have "rpl", the answer.

Note:
1 <= S.length = shifts.length <= 20000
0 <= shifts[i] <= 10 ^ 9
 * */
class Solution {
    /*
    * Solution: SuffixSum, Time complexity:O(n), Space complexity:O(n)
    * */
    fun shiftingLetters(S: String, shifts: IntArray): String {
        //avoid calculation overflow, use Long
        val suffixSumArray = LongArray(shifts.size)
        var suffixSum = 0L
        for (i in shifts.size - 1 downTo 0) {
            suffixSum += shifts[i]
            suffixSumArray[i] = suffixSum
        }
        val sb = StringBuilder()
        for (i in suffixSumArray.indices) {
            sb.append((((S[i] - 'a' + suffixSumArray[i]) % 26) + 'a'.toInt()).toChar())
        }
        return sb.toString()
    }
}