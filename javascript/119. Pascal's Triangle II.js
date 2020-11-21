/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 * https://www.cnblogs.com/grandyang/p/4031536.html
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

除每行最左侧与最右侧的数字以外，每个数字等于它的左上方与右上方两个数字之和
（也就是说，第n行第k个数字等于第n-1行的第k-1个数字与第k个数字的和）。
这是因为有组合恒等式：C_{n}^{i}=C_{n-1}^{i-1}+C_{n-1}^{i}。
可用此性质写出整个杨辉三角形。
 */
/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function (rowIndex) {
    if (rowIndex == 0)
        return [1];
    let result = [], lastArr = [];
    for (let i = 1; i <= rowIndex; i++) {
        let res = [];
        for (let j = 1; j <= i + 1; j++) {
            if (j == 1 || j == i + 1)
                res.push(1);
            else {
                if (lastArr.length == 0) {
                    res.push(1);
                } else {
                    //第n行第k个数字等于第n-1行的第k-1个数字与第k个数字的和
                    let k = lastArr[j - 2] + lastArr[j - 1]
                    res.push(k);
                }
            }
        }
        result.push(res);
        lastArr = res;
    }
    //console.log(result[rowIndex-1]);
    return result[rowIndex - 1];
};