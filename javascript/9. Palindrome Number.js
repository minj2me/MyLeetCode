/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 * 
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
 */
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
    if (x < 0)
        return false;
    let xStr = x.toString();
    let left = 0, right = xStr.length - 1;
    while (left < right) {
        if (xStr[left] != xStr[right])
            return false;
        else {
            left++;
            right--;
        }
    }
    return true;
};