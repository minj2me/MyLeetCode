/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/description/
 * http://bookshadow.com/weblog/2015/09/09/leetcode-perfect-squares/
 * https://www.cnblogs.com/grandyang/p/4800552.html
 * 
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

考察：四平方和定理
解法I：数论（Number Theory）
时间复杂度：O(sqrt n)
四平方和定理(Lagrange's Four-Square Theorem)：所有自然数至多只要用四个数的平方和就可以表示。
 */
/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function (n) {
    //我们将数字化简一下，由于一个数如果含有因子4，那么我们可以把4都去掉，并不影响结果
    while (n % 4 == 0)
        n /= 4;
    //如果一个数除以8余7的话，那么肯定是由4个完全平方数组成，这里就不证明了，因为我也不会证明，读者可自行举例验证
    if (n % 8 == 7)
        return 4;
    for (let a = 0; a * a <= n; a++) {
        //let b = Math.sqrt(n - a * a);
        let b = parseInt(Math.sqrt(n - a * a));
        if (a * a + b * b == n)
            //!!a + !!b这个表达式，可能很多人不太理解这个的意思，其实很简单，感叹号!表示逻辑取反，那么一个正整数逻辑取反为0，再取反为1，
            //所以用两个感叹号!!的作用就是看a和b是否为正整数，都为正整数的话返回2，只有一个是正整数的话返回1
            return !!a + !!b;
    }
    return 3;
};