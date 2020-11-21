/**
 * 459. Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 * https://www.jianshu.com/p/b267d9062acf
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring
 * together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */

/**
 * @param {string} s
 * @return {boolean}
 * 如果当前长度能被总长度整除，说明可以分成若干个子字符串，
 * 找到和第一个字符相同的字符，开始比对是否重复，如果重复，那么把字符串中相同的全部替换为空，如果结果为空，那么的确是符合要求的
 */
var repeatedSubstringPattern = function (s) {
    let n = s.length;
    if (n <= 1)
        return false;
    for (let i = 1; i < n; i++) {
        if (n % i == 0) {
            //console.log(i + ":" + s[i]);
            if (s[0] == s[i]) {
                //console.log(i + ":" + s[i]);
                let j = 0;
                //while (j < i && (j + i) < n) {
                while (j < i) {
                    // console.log("s.charAt(" + j + "):" + s.charAt(j));
                    // console.log("s.charAt(" + j + " + " + i + ")):" + s.charAt(j + i));
                    if (s.charAt(j) == s.charAt(j + i))
                        j++;
                    else
                        break;
                }
                if (j == i) {//found out the substring of duplicate
                    //console.log(s.substring(0, i));
                    let duplicateStr = s.substring(0, i);
                    let regExp = new RegExp(duplicateStr, "gm", "");
                    let newStr = s.replace(regExp, "");
                    //console.log(newStr);
                    if (newStr == "")
                        return true;
                }
            }
        }
    }
    return false;
};