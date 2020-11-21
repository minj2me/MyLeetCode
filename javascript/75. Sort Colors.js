/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/description/
 * https://www.cnblogs.com/grandyang/p/4341243.html

 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

- 首先遍历一遍原数组，分别记录0,1,2的个数
- 然后更新原数组，按个数分别赋上0，1，2

 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {
    let count = new Array(3);
    count.fill(0);
    for (let i = 0; i < nums.length; i++) {
        count[nums[i]]++;
    }
    let idx = 0;
    for (let i = 0; i < count.length; i++) {
        //loop i 控制放的值
        for (let j = 0; j < count[i]; j++) {
            //loop j 控制放的个数
            nums[idx] = i;
            idx++;
        }
    }
    //console.log(nums);
};