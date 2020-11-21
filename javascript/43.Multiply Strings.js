/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/description/
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
 */
/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function (num1, num2) {
    let num1Len = num1.length;
    let num2Len = num2.length;
    let result = new Array(num1Len + num2Len).fill(0);
    for (let i = num1Len - 1; i >= 0; i--) {
        for (let j = num2Len - 1; j >= 0; j--) {
            let value = num1.charAt(i) * num2.charAt(j);
            result[i + j + 1] += value;
            if (result[i + j + 1] >= 10) {
                //如果个位数据>=10
                //进位
                result[i + j] += parseInt(result[i + j + 1] / 10);//10位
                result[i + j + 1] = result[i + j + 1] % 10;//个位
            }
        }
    }
    let string = "";
    for (let i = 0; i < result.length; i++) {
        if (result.charAt(i) == "" || result.charAt(i) == "0")
            continue;
        string += result.charAt(i);
    }
    console.log(string);
    return string;
};