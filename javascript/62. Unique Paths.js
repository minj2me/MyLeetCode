/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/description/
 * https://www.cnblogs.com/grandyang/p/4353555.html
 */
/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    //dfs will Time Limit exceedd
    // let result = new Array(1).fill(0);
    // dfs(0, 0, m, n, result);
    // return result[0];

    //try dp
    let dp = new Array(n).fill(1);
    for (let i=1;i<m;i++){
        for (let j=1;j<n;j++){
            dp[j]+=dp[j-1];
        }
    }
    return dp[n-1];
};
var dfs=function(x,y,m,n,result){
    if (x >= m || y >= n)
        return;
    if ((x == m - 1) && y == n - 1) {
        result[0] += 1;
    }
    dfs(x, y + 1, m, n, result);
    dfs(x + 1, y, m, n, result);
}