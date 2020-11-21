/**
 * 190. Reverse Bits
https://leetcode.com/problems/reverse-bits/description/

 * Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.
 */
/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function (n) {
    let res = 0;
    for (let i = 0; i < 32; i++) {
        ////参加运算的两个数制，按二进制进行 与运算
        //如果两个相应的二进位数为1，刚该位的结果为 1 否则为 0 即：
        //0 & 0 = 0；0 & 1 = 0；1 & 0 = 0；1& 1 = 1
        if (n & 1 == 1) {
            //左移: 右补 0, 二进制数 00001111，左移1位得到 00011110
            res = (res << 1) + 1;
        } else {
            res = res << 1;
        }
        //右移: 移到右端的低位被舍弃，对无符号数，高位补 0
        //a = 00001111 >> 1
        //00000111
        n = n >> 1;
    }
    return res;
};