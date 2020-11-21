/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/description/
 * 
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has 
 * (also known as the Hamming weight).
 * 
 * Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011 

Example 2:
Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000

 */
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
    var count = 0;
    for (let i = 0; i < 32; i++) {
        //console.log(i+":"+(n&1));
        //参加运算的两个数制，按二进制进行 与运算，如果两个相应的二进位数为1，刚该位的结果为 1 否则为 0 即：
        //0 & 0 = 0；0 & 1 = 0；1 & 0 = 0；1& 1 = 1
        count += (n & 1);
        //console.log("result:"+result);
        //右移的规则只记住一点：符号位不变，左边补上符号位
        n = n >> 1;//==除以2
        //n/=2;
    }
    return count;
};