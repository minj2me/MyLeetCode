/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

 */
/**
 * @param {string} s
 * @return {string}
 * 以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，结果res自增1，然后再比较下一对。
 * 注意回文字符串有奇数和偶数两种形式，如果是奇数长度，那么i位置就是中间那个字符的位置，所以我们左右两遍都从i开始遍历；
 * 如果是偶数长度的，那么i是最中间两个字符的左边那个，右边那个就是i+1
 */
var longestPalindrome = function (s) {
    //回文字符串有奇数和偶数两种形式,i is the middle
    let len = s.length;
    if (len == 0) return "";
    if (len == 1) return s;
    let longest = "";
    for (let i = 0; i < len; i++) {
        let temp = help(s, i, i);//odd,奇数
        if (longest.length < temp.length)
            longest = temp;
        let temp2 = help(s, i, i + 1);//even
        if (longest.length < temp2.length)
            longest = temp2;
    }
    return longest;
};

var help = function (s, i, j) {
    while (i >= 0 && j < s.length && s.charAt(i) == s.charAt(j)) {
        //向两边扩散
        i--;
        j++;
    }
    return s.substring(i + 1, j);
};