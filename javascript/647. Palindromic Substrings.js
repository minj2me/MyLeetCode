
/**
 * 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 * https://www.cnblogs.com/grandyang/p/7404777.html
 * 
 * Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:
The input string length won't exceed 1000.
 */
/**
 * @param {string} s
 * @return {number}
 * 以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，结果res自增1，然后再比较下一对。
 * 注意回文字符串有奇数和偶数两种形式，如果是奇数长度，那么i位置就是中间那个字符的位置，所以我们左右两遍都从i开始遍历；如果是偶数长度的，
 * 那么i是最中间两个字符的左边那个，右边那个就是i+1，这样就能cover所有的情况啦，而且都是不同的回文子字符串
 */
var countSubstrings = function (s) {
    let len = s.length;
    let result = new Array(1).fill(0);
    for (let i = 0; i < len; i++) {
        //回文字符串有奇数和偶数两种形式,i is the middle
        help(s, i, i, result);
        help(s, i, i + 1, result);
    }
    //console.log(result);
    return result[0];
};
var help = function (s, i, j, result) {
    while (i >= 0 && j < s.length && s[i] == s[j]) {
        //向两边扩散
        i--;
        j++;
        result[0]++;
    }
    return result;
};