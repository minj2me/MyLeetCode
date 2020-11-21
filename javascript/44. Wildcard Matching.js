/**
 * 44. Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/description/
 * https://segmentfault.com/a/1190000003786247
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false

 let s = "aab", p = "*ab";
 return true;

Explanation: "a" does not match the entire string "aa".
 */
/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
    let sIndex = 0, pIndex = 0, starIndex = -1, matchIndex = 0;
    while (sIndex < s.length) {
        console.log("sIndex:" + sIndex);
        console.log("pIndex:" + pIndex);
        if (pIndex < p.length && (s.charAt(sIndex) === p.charAt(pIndex)) || p.charAt(pIndex) === '?') {
            sIndex++;
            pIndex++;
            // 如果字符不同也没有?，但在p中遇到是*时，我们记录下*的位置，但不改变s的指针
        } else if (pIndex < p.length && p.charAt(pIndex) === '*') {
            starIndex = pIndex;
            pIndex++;
            //遇到*后，我们用matchIndex来记录*匹配到的s字符串的位置，和不用*匹配到的s字符串位置相区分
            matchIndex = sIndex;
        } else if (starIndex != -1) {
            console.log("starIndex:" + starIndex);
            //用上一个*来匹配，那我们p的指针也应该退回至上一个*的后面
            pIndex = starIndex + 1;
            //用* match到的位置++
            matchIndex++;
            //sIndex set back to the index of *
            sIndex = matchIndex;
            console.log("matchIndex:" + matchIndex);
        } else {
            return false;
        }
    }
    //因为1个*能匹配无限序列，如果p末尾有多个*，我们都要跳过
    while (pIndex < p.length && p.charAt(pIndex) === '*') {
        pIndex++;
    }
    return pIndex === p.length;
};