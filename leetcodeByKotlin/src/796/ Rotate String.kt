package LeetCode_796

/**
 * 796. Rotate String
 * https://leetcode.com/problems/rotate-string/description/
 *
We are given two strings, A and B.
A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
For example, if A = 'abcde', then it will be 'bcdea' after one shift on A.Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false

Note:
A and B will have length at most 100.
 * */
class Solution {
    fun rotateString(A: String, B: String): Boolean {
        //solution 1:
        if (A == B) {
            return true
        }
        var shiftA = A
        for (i in shiftA.indices) {
            /*
            match each string after shift and update shiftA every time
            for example:abcde, changing below:
            bcdea
            cdeab
            */
            shiftA = shiftA.substring(1, A.length) + A[i]
            if (shiftA == B) {
                return true
            }
        }
        return false

        //solution 2:
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        //return (A.length==B.length) && ((A+A).indexOf(B)!=-1)
    }
}