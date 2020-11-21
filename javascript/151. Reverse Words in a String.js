/**
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * 
 * Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
/**
 * @param {string} str
 * @returns {string}
 */
var reverseWords = function (str) {
    let arry = str.trim().split(" ");
    let result = "";
    for (let i = arry.length - 1; i >= 0; i--) {
        if (arry[i] == "")
            continue;
        result += arry[i] + " ";
    }
    return result.trim();
};