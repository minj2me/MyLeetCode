package LeetCode_693

/**
 * 693. Binary Number with Alternating Bits
 * https://leetcode.com/problems/binary-number-with-alternating-bits/description/
 *
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101

Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
 * */
class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        var n_ = n
        var lastBitIs1 = (n_ % 2) == 1//if odd number last bit must be 1
        while (n_ > 0) {
            n_ = n_ shr 1//because the last bit had check in below, so here need shift first
            val curBit = n_ and 1
            if (curBit == 1 && lastBitIs1) {
                //represent last one and current one both is 1
                return false
            } else if (curBit == 0 && !lastBitIs1) {
                //represent last one and current one both is 0
                return false
            }
            //check again
            lastBitIs1 = (n_ % 2) == 1
        }
        return true
    }
}