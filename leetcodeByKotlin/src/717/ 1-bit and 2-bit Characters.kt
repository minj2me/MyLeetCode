package LeetCode_717

/**
 * 717. 1-bit and 2-bit Characters
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 *
 * We have two special characters.
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
Now given a string represented by several bits. Return whether the last character must be a one-bit character or not.
The given string will always end with a zero.

Example 1:
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.

Example 2:
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.

Note:
1. 1 <= len(bits) <= 1000.
2. bits[i] is always 0 or 1.
 * */
class Solution {
    /*
    * solution: scan array from left to right, check the pointer if can go to the end;
    * if current number is 0, pointer++;
    * if current is 1, pointer+=2, because (1,0) or (1,0) is valid;
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var i = 0
        val n = bits.size
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2
            } else {
                i++
            }
        }
        return i == n - 1
    }
}