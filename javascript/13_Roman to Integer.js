/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 * 思路
 * 　1. 当当前数字比其右边数字小的时候，则减去当前数字。
　　2. 当当前数字比其右边数字大或等于右边数字时，则加上当前数字。
 */
/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
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