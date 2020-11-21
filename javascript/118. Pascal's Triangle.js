/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description/
 * 
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * 
 * 除每行最左侧与最右侧的数字以外，每个数字等于它的左上方与右上方两个数字之和
（也就是说，第n行第k个数字等于第n-1行的第k-1个数字与第k个数字的和）。
这是因为有组合恒等式：C_{n}^{i}=C_{n-1}^{i-1}+C_{n-1}^{i}。
可用此性质写出整个杨辉三角形。

 * Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function (numRows) {
    if (numRows == 0)
        return [];
    let result = [], lastRes = [];
    for (let i = 1; i <= numRows; i++) {
        let res = [];
        for (let j = 1; j <= i; j++) {
            if (j == 1 || j == i)
                res.push(1)
            else {
                if (lastRes.length == 0)
                    res.push(1);
                else {
                    //第n行第k个数字等于第n-1行的第k-1个数字与第k个数字的和
                    let k = lastRes[j - 2] + lastRes[j - 1];
                    res.push(k);
                }
            }
        }
        result.push(res);
        lastRes = res;
    }
    //console.log(result);
    return result;
};