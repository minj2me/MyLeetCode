/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/description/
 * https://www.cnblogs.com/grandyang/p/5631814.html
 * 
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3

Example 2:

Input: a = -2, b = 3
Output: 1
 */
/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var getSum = function (a, b) {
    if (b == 0)
        return a;
    //http://www.cnblogs.com/this-543273659/archive/2011/08/30/2159819.html
    let sum = a ^ b;
    //console.log("a^b:" + sum);
    //https://www.cnblogs.com/net-safe/p/8488605.html
    //console.log("a&b:" + (a & b));
    let carry = (a & b) << 1;//左移1位，表示x2
    //console.log("carry:" + carry);
    return getSum(sum, carry);
};