/**
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/description/
 * https://www.cnblogs.com/grandyang/p/4447233.html
 * 
 * Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */
/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function (n) {
    let set = new Set();
    while (num != 1) {
        let t = 0;
        while (num > 0) {
            t += (num % 10) * (num % 10);
            num = parseInt(num / 10);
        }
        num = t;//reset the num
        // console.log(num);
        if (set.has(num))
            break;
        else
            set.add(num);
    }
    //console.log(num);
    return num == 1;
};