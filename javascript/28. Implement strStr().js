/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
 * https://www.cnblogs.com/grandyang/p/4606696.html
 * 

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, 
we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function (haystack, needle) {
    if (needle.length == 0)
        return 0;
    let m = haystack.length, n = needle.length;
    if (m < n)
        return -1;
    for (let i = 0; i <= m - n; i++) {
        let j = 0;//will break to here
        for (j = 0; j < n; j++) {
            if (haystack[i + j] != needle[j])//如果不相同的，进入下次match
                break;
        }
        if (j == n)
            return i;
    }
    return -1;
}