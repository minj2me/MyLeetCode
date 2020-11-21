/**
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701

 */
/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function (s) {
    let len = s.length;
    let temp = 1, result = 0;
    for (let i = len; i >= 1; i--) {
        //result += (s[i-1].toUpperCase().charCodeAt(0) - "A".charCodeAt(0) + 1) * temp;
        //!! s.charAt(i - 1) fast than s[i-1] almost 40%.
        result += (s.charAt(i - 1).toUpperCase().charCodeAt(0) - "A".charCodeAt(0) + 1) * temp;
        temp *= 26;
    }
    console.log("result:" + result);
    return result;
};