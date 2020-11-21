/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/description/
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function (num1, num2) {
    let len1 = num1.length - 1, len2 = num2.length - 1;
    let carry = 0;
    let result = [];
    while (len1 >= 0 || len2 >= 0) {
        let a = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
        let b = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
        let temp = a + b + carry;
        if (temp >= 10) {
            carry = Math.floor(temp / 10);//进位
            temp = Math.floor(temp % 10);//个位数
        } else
            carry = 0;
        //console.log(carry);
        //console.log(temp);
        result.unshift(temp);
    }
    if (carry)
        result.unshift(1);
    //console.log(result.join(""));
    return result.join("");
};