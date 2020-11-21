/**
 * 263. Ugly Number
 * https://leetcode.com/problems/ugly-number/description/
 */
/**
 * @param {number} num
 * @return {boolean}
 */
var isUgly = function (num) {
    //prime factor including 2,3,5
    if (num <= 0)
        return false;
    while (num % 2 == 0)
        num /= 2;
    while (num % 3 == 0)
        num /= 3;
    while (num % 5 == 0)
        num /= 5;
    return num == 1;
};