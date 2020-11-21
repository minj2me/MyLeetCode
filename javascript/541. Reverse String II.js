/**
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/description/
 * 
 * Given a string and an integer k, 
 * you need to reverse the first k characters for every 2k characters counting from the start of the string. 
 * If there are less than k characters left, reverse all of them. 
 * If there are less than 2k but greater than or equal to k characters, 
 * then reverse the first k characters and left the other as original.
 * 
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 */
/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reverseStr = function (s, k) {
    let len = s.length;
    if (len < k)
        return s.split("").reverse().join("");
    let result = "";
    for (let i = 0; i < len; i += k) {
        let str = s.substring(i, (i + k));
        if (i % (2 * k) == 0)
            result += str.split("").reverse().join("");
        else
            result += str;
    }
    return result;
};