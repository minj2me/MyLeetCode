/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/description/
 * Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000

Example 2:

Input: 2.10000, 3
Output: 9.26100

 */
/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function (x, n) {
    //time complexity: O(logn),因为除了2
    if (n < 0)
        return 1 / myPow_(x, n);
    return myPow_(x, n);
};

var myPow_ = function (x, n) {
    if (n == 0)
        return 1;
    let half = myPow_(x, parseInt(n / 2));//parseInt与Math.floor一样。。
    if (n % 2 == 0)
        return half * half;
    else
        return half * half * x;
}