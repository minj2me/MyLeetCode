/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
 */
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    //Runtime: 320 ms
    let length = s.length;
    let longest = 0;
    for (let i = 0; i < length; i++) {
      let substring = "";
      let subI = i;
      while (subI < length) {
        if (substring.indexOf(s[subI]) == -1) {
          substring += s[subI];
        } else {
          break;
        }
        subI++;
      }
      if (substring.length > longest)
        longest = substring.length;
    }
    console.log("longest:" + longest);
    return longest;
};