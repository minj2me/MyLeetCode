/**
 * 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 * https://www.cnblogs.com/grandyang/p/4518674.html
 * 
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 */
/**
 * @param {number[]} nums
 * @return {number}
 * 
 * 这道题是之前那道House Robber 打家劫舍的拓展，现在房子排成了一个圆圈，则如果抢了第一家，就不能抢最后一家，因为首尾相连了，
 * 所以第一家和最后一家只能抢其中的一家，或者都不抢，那我们这里变通一下，如果我们把第一家和最后一家分别去掉，各算一遍能抢的最大值，
 * 然后比较两个值取其中较大的一个即为所求。那我们只需参考之前的House Robber 打家劫舍中的解题方法，然后调用两边取较大值
 */
var rob = function (nums) {
    let len = nums.length;
    if (len == 0)
        return 0;
    if (len == 1)
        return nums[0];
    //http://www.w3school.com.cn/jsref/jsref_slice_array.asp
    let nums1 = nums.slice(0, len - 1)
    let nums2 = nums.slice(1, len)
    // console.log(nums1);
    // console.log(nums2);
    let a = helper(nums1);
    let b = helper(nums2);
    return Math.max(a, b);
};
var helper = function (nums) {
    let len = nums.length;
    let a = 0, b = 0;
    for (let i = 0; i < len; i++) {
        if (i % 2 == 0)
            a = Math.max(a += nums[i], b);
        if (i % 2 != 0)
            b = Math.max(b += nums[i], a);
    }
    return Math.max(a, b);
}