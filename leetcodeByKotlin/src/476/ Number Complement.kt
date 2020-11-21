package LeetCode_476

/**
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/description/
 *
Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

Constraints:
The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
num >= 1
You could assume no leading zero bit in the integer’s binary representation.
 * */
class Solution {
    /*
    * Solution: Bit operation, Time complexity:O(32), Space complexity:O(1);
    * 5 is '00000101', because it complement number is '00000010':
    * so we need a mask like this:'11111000', then: ~num ^ mask => ~num is:'11111010' ^ mask=> the result: '00000010'
    * How i can make the mask '11111000'
    * 1.set mask: ...11111111 via ~0
    * 2.loop to left shift the mask till num & mask is '00000000'
    *
    以下是完整的位运算符（只用于Int和Long）
        shl(bits) – 有符号左移（signed shift left，相当于Java的<<）
        shr(bits) – 有符号右移（signed shift right，相当于Java的>>）
        ushr(bits) – 无符号右移（unsigned shift right，相当于Java的>>>）
        and(bits) – 按位与（bitwise and，相当于Java的&）//一一为一，其它为0
        or(bits) – 按位或（bitwise or，相当于Java的|） //有一为一，零零为0
        xor(bits) – 按位异或（bitwise xor，相当于Java的^）//相同为0，不相同为1
        inv() – 按位取反（bitwise inversion，相当于Java的~）var z = y.inv() //z是y取反获得的
    * */
    fun bitwiseComplement(N: Int): Int {
        val zero = 0
        var mask = zero.inv()//mask is ...11111111
        while ((N and mask) != 0) {
            mask = mask shl 1
        }
        return N.inv() xor mask
    }
}