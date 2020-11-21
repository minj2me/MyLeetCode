/**
 * 784. Letter Case Permutation
 * https://leetcode.com/problems/letter-case-permutation/description/
 * 
 * https://www.cnblogs.com/grandyang/p/9065702.html
 * 
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:

S will be a string with length at most 12.
S will consist only of letters or digits.
 */
/**
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function (S) {
    let result = [""];
    for (let c of S) {
        let len = result.length;
        //console.log(len);
        if (parseInt(c) >= 0 || parseInt(c) <= 9) {
            for (let i = 0; i < len; i++) {
                result[i] += c;
            }
        } else {
            for (let i = 0; i < len; i++) {
                result.push(result[i]);
                result[i] = result[i] + c.toLowerCase();
                result[len + i] = result[len + i] + c.toUpperCase();
            }
        }
    }
    //console.log(result);
    return result;
};