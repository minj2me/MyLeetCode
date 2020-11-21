/**
 * 168. Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:
Input: 1
Output: "A"

Example 2:
Input: 28
Output: "AB"

Example 3:
Input: 701
Output: "ZY"
 */

/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function (n) {
    let result = "";
    //https://www.cnblogs.com/grandyang/p/4227618.html
    //就是一位一位的求，此题从低位往高位求，每进一位，则把原数缩小26倍，再对26取余，之后减去余数，再缩小26倍，以此类推，可以求出各个位置上的字母
    while (n > 0) {
        if (n % 26 == 0) {
            result += "Z";
            n -= 26;
        } else {
            result += String.fromCharCode(n % 26 - 1 + "A".charCodeAt(0));
            n -= n % 26;
        }
        n /= 26;
    }
    //console.log(result.split("").reverse().join(""));
    return result.split("").reverse().join("");
};