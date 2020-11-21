/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * https://www.cnblogs.com/Dylan-Java-NYC/p/6208421.html
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
  let array = [], result = [];
  for (let i = 0; i < p.length; i++) {
    if (array[p.charAt(i)] == undefined)
      array[p.charAt(i)] = 1;
    else
      array[p.charAt(i)]++;
  }
  //console.log(array);
  let walker = 0, runner = 0, sum = p.length;
  while (runner < s.length) {
    if (array[s.charAt(runner++)]-- > 0) {
      //Move runner everytime. Decrease corresponding char count by 1
      //If current char count is larger than 0, then this char is in pF
      sum--;
    }
    if (sum == 0)
      result.push(walker);
    if (runner - walker == p.length && array[s.charAt(walker++)]++ >= 0) {
      //If windows's size is already p.length(), move walker and increase corresponding char count by 1 
      //If count before increasing is not smaller than 0, this char is in p
      sum++;
    }
  }
  //console.log(result);
  return result;
};