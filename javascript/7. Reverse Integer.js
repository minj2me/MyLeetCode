/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 * 
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
 */
/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    let isNegative = false;
    if (x < 0) {
        isNegative = true;
        x = -1 * x;//let it to positive
    }
    let res = 0;
    while (x > 0) {
        res = res * 10 + x % 10;//取个位的数
        x = Math.floor(x / 10);
    }
    //because it was 32-bit
    if (res > Math.pow(2, 31))
        return 0;

    return isNegative ? -res : res;
}