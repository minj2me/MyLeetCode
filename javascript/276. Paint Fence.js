/**
 * 276. Paint Fence
 * https://www.lintcode.com/problem/paint-fence/description
 * https://www.cnblogs.com/grandyang/p/5231220.html
 * 
 * There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

Example
Given n=3, k=2 return 6

      post 1,   post 2, post 3
way1    0         0       1 
way2    0         1       0
way3    0         1       1
way4    1         0       0
way5    1         0       1
way6    1         1       0
Notice
n and k are non-negative integers.
 */
/**
 * @param n: non-negative integer, n posts
 * @param k: non-negative integer, k colors
 * @return: an integer, the total number of ways
 * 
 * 当n=2时，k=2时，我们可以分两种情况来统计，一种是相邻部分没有相同的，一种相同部分有相同的颜色，
 * 那么对于没有相同的，对于第一个格子，我们有k种填法，对于下一个相邻的格子，由于不能相同，所以我们只有k-1种填法。
 * 而有相同部分颜色的刷法和上一个格子的不同颜色刷法相同，因为我们下一格的颜色和之前那个格子颜色刷成一样的即可，最后总共的刷法就是把不同和相同两个刷法加起来
 */
const numWays = function (n, k) {
    if (n == 0)
        return 0;
    let same = 0, diff = k, result = same + diff;
    for (let i = 2; i <= n; i++) {
        same = diff;
        diff = result * (k - 1);
        result = same + diff;
    }
    return result;
}