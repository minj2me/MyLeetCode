/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    if (n < 1)
        return 0;
    if (n == 1)
        return 1;
    if (n == 2)
        return 2;
    let a = 1, b = 2, temp = 0;
    for (let i = 3; i <= n; i++) {
        temp = a + b;
        a = b;
        b = temp;
    }
    return temp;
};

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    //360ms 
    let len = prices.length;
    if (len == 0) return 0;
    let big = 0, min = prices[0];
    for (let i = 1; i < len; i++) {
        big = Math.max(big, prices[i] - min);
        min = Math.min(prices[i],min);
    }
    return big;
};

/**
 * 256. Paint House
 * 问题描述：
There are a row of n houses, each house can be painted with one of the three colors: 0 red, 1 blue or 2 green. 
The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
Example:
Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.

解题思路：
如果当前的房子要用红色刷，那么上一个房子只能用绿色或蓝色来刷，那么我们要求刷到当前房子，
且当前房子用红色刷的最小花费就等于当前房子用红色刷的钱加上刷到上一个房子用绿色和刷到上一个房子用蓝色的较小值，
这样当我们算到最后一个房子时，我们只要取出三个累计花费的最小值即可，
 */
var minCost = function (nums) {
    let len = nums.length;
    if (len == 0) return 0;
    for (let i = 1; i < len; i++) {
        //如果用红色刷的,最小花费就等于当前房子用红色刷的钱加上刷到上一个房子用绿色和刷到上一个房子用蓝色的较小值
        nums[i][0] = nums[i][0] + Math.min(nums[i - 1][1], nums[i - 1][2]);
        nums[i][1] = nums[i][1] + Math.min(nums[i - 1][0], nums[i - 1][2]);
        nums[i][2] = nums[i][2] + Math.min(nums[i - 1][0], nums[i - 1][1]);
    }
    //这样当我们算到最后一个房子时，我们只要取出三个累计花费的最小值即可，
    return Math.min(nums[len - 1][0], Math.min(nums[len - 1][1], nums[len - 1][2]));
}

/**
 * 265. Paint House II
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. 
For example, 
costs[0][0] is the cost of painting house 0 with color 0; 
costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
Example:
Input: [
    [1,5,3],
    [2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 
Follow up:
Could you solve it in O(nk) runtime?
 */
var minCost2 = function (nums) {
}

/**
 * //1.subproblem 2.guessing 3.recurrence
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 * 
 * 一个DP问题。定义possible[i] 为S字符串上[0,i]的子串是否可以被segmented by dictionary.
possible[i] = true      if  S[0,i]在dictionary里面
                = true      if   possible[k] == true 并且 S[k+1,i]在dictionary里面， 0<k<i
               = false      if    no such k exist.
 */
var wordBreak = function (s, wordDict) {
    //Runtime: 68 ms
    let map = new Map();
    initContaner(wordDict, map);
    let n = s.length;
    //let dp = new Array(n + 1);
    let dp = new Array(n);
    for (let i = 0; i < dp.length; i++)
        dp[i] = false;

    /**
     * check:leet
        dp[3] = true
        check:leetc
      checkAgain:eetc
      checkAgain:etc
      checkAgain:tc
     * 
     */
    for (let i = 0; i < n; i++) {
        let check = s.substring(0, i + 1);
        console.log("check:" + check);
        if (isContains(check, map)) {
            //设dp[i]为前i个字符是否可以切割
            dp[i] = true;
            console.log("dp[" + i + "] = true");
            continue;
        }
        for (let j = 0; j < i; j++) {
            let checkAgain = s.substring(j + 1, i + 1);
            console.log("checkAgain:" + checkAgain);
            console.log("j:" + j);
            if (dp[j] && isContains(checkAgain, map)) {
                console.log("dp[" + i + "] = true");
                dp[i] = true;
            }
        }
    }

    //console.log(dp[n-1]);
    //console.log(dp);
    console.log(dp[n - 1]);
    return dp[n - 1];
};

var initContaner = function (wordDict, map) {
    for (let i = 0; i < wordDict.length; i++) {
        map.set(wordDict[i], true);
    }
};

var isContains = function (ch, map) {
    return map.get(ch);
};
