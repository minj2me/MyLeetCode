/**
 * Divide Two Integers
 * https://leetcode.com/problems/divide-two-integers/description/
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function (dividend, divisor) {

};

/**
 * 273. Integer to English Words
 * https://leetcode.com/problems/integer-to-english-words/description/
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2的23次方 - 1.
 * 
Example 1:
Input: 123
Output: "One Hundred Twenty Three"

Example 2:
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
 * @param {number} num
 * @return {string}
 */
var numberToWords = function (num) {
    //1.setup the map

};

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/description/
 * 
 * Definition for isBadVersion()
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 * 
 * Example:
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version. 

如是坏版本，说明边界在左边，则把mid赋值给right，如果是好版本，则说明边界在右边，则把mid+1赋给left，最后返回left即可

 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function (isBadVersion) {
    /**
     * @param {integer} n Total versions
     * @return {integer} The first bad version
     */
    return function (n) {
        //n:18; version:14
        let left = 1, right = n;
        while (left < right) {
            let mid = Math.floor((left + right) / 2);
            if (isBadVersion(mid))//version is 14
                right = mid;
            else
                left = mid + 1;

            console.log("mid:" + mid);
            console.log("left:" + left);
            console.log("right:" + right);
            /**
             * mid:9
            left:10
            right:18
            =======
            mid:14
            left:10
            right:14
            =======
            mid:12
            left:13
            right:14
            =======
            mid:13
            left:14
            right:14
             * 
             */
        }
        return left;
    };
};

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 * @param {string} s
 * @return {number}
 * Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
解题思路：
不难看出：
　　1. 当当前数字比其右边数字小的时候，则减去当前数字。
　　2. 当当前数字比其右边数字大或等于右边数字时，则加上当前数字。
 */
var romanToInt = function (s) {
    //192 ms
    let map = new Map();
    map.set("I", 1);
    map.set("V", 5);
    map.set("X", 10);
    map.set("L", 50);
    map.set("C", 100);
    map.set("D", 500);
    map.set("M", 1000);
    let n = s.length;
    let result = 0;
    for (let i = 0; i < n; i++) {
        if (map.get(s[i + 1]) > map.get(s[i]))
            result -= map.get(s[i]);
        else
            result += map.get(s[i]);
    }
    console.log(result);
    return result;
};