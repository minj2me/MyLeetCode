/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 * https://www.cnblogs.com/grandyang/p/7618468.html
 * 
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
/**
 * @param {string} s
 * @return {boolean}
 * 
 * 这道题允许删除一个字符，那么当遇到不匹配的时候，我们到底是删除左边的字符，还是右边的字符呢，
 * 我们的做法是两种情况都要算一遍，只要有一种能返回true，那么结果就返回true。
 * 我们可以写一个子函数来判断字符串中的某一个范围内的子字符串是否为回文串
 */
var validPalindrome = function (s) {
    let left = 0, right = s.length - 1;
    while (left < right) {
        if (s[left] != s[right]) {
            return isValid(s, left + 1, right) || isValid(s, left, right - 1);
        }
        left++;
        right--;
    }
    return true;
};

var isValid = function (s, left, right) {
    while (left < right) {
        if (s[left] != s[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
};