/**
 * 29. Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/description/
 * 
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
 */
/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function (dividend, divisor) {
    if (divisor === 0) {
        return Number.MAX_VALUE;
    }
    
    if (dividend === 0) {
        return 0;
    }
    
    let result = 0,isNeg = false,temp,i = 0;
        
    if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
        isNeg = true;
    }
    
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    
    if (divisor === 1 || divisor === -1) {
        return isNeg? -dividend : dividend;
    }
    
    temp = divisor;
        
    while (divisor << (i + 1) <= dividend) {
        i++;
    }
    
    while (dividend >= divisor) {
        temp = divisor << i;
        
        if (dividend >= temp) {
            result += (1 << i);
            dividend -= temp;
        }
        
        i--;
    }
    
    return isNeg? -result : result;
};