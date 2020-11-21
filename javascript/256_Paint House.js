
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