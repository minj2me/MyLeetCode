package LeetCode_1318

/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
 *
 * Given 3 positives numbers a, b and c.
 * Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 * */
class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var count = 0
        var a_ = a
        var b_ = b
        var c_ = c
        while (a_ > 0 || b_ > 0 || c_ > 0) {
            //get the lowest bit
            val a0 = a_ and 1// a_ and 1 ==> a_ % 2
            val b0 = b_ and 1
            val c0 = c_ and 1
            //if current bit of c is 1 and a,b if 0, need flip one time
            if (c0 == 1) {
                if (a0 == 0 && b0 == 0) {
                    count++
                }
            } else {
                //if current bit of c is 0:
                //if current bit of a or b is 1, need flip one time,
                //if current bit of a and b is 1, need flip two times,
                count += a0 + b0
            }
            a_ = a_ shr 1
            b_ = b_ shr 1
            c_ = c_ shr 1
        }
        return count
    }
}