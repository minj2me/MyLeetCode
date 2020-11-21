package LeetCode_1009

/**
 * 1009. Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/description/
 *
 * Every non-negative integer N has a binary representation.
 * For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.
 * Note that except for N = 0, there are no leading zeroes in any binary representation.
The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.
For example, the complement of "101" in binary is "010" in binary.
For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.

Example 1:
Input: 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.

Example 2:
Input: 7
Output: 0
Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.

Example 3:
Input: 10
Output: 5
Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 * */
class Solution {
    /*
    * Solution: Bit operation, Time complexity:O(32), Space complexity:O(1);
    * 5 is '00000101', because it complement number is '00000010':
    * so we need a mask like this:'11111000', then: ~num ^ mask => ~num is:'11111010' ^ mask=> the result: '00000010'
    * How can i make the mask '11111000':
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
        if (N == 0) {
            return 1
        }
        val zero = 0
        //mask is ...11111111
        var mask = zero.inv()
        /*
        * binary of 5 is: 00000101, mask is 11111111, so
        * 00000101
        * 11111111
        * -------- and is
        * 00000101
        * */
        while ((N and mask) != 0) {
            mask = mask shl 1
        }
        /*
        * bitwise inversion of 5 is: 11111010, and now mask is: 11111000, so
        * 11111010
        * 11111000
        * -------- xor is
        * 00000010
        * */
        return N.inv() xor mask
    }
}