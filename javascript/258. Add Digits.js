/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/description/
 * //https://www.cnblogs.com/Dylan-Java-NYC/p/4825035.html
 * 
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.

follow up:
could you do it without any loop/recursion in O(1) runtime?
 */
/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function (num) {
    // while (num.toString().length > 1) {
    //     let n = 0;
    //     while (num > 0) {
    //         n += num % 10;
    //         num = parseInt(num / 10);
    //     }
    //     num = n;
    // }
    // return num;

    //Follow up, O(1)
    if (num == 0)
        return 0;
    if (num % 9 == 0)
        return 9;
    return num % 9;

};