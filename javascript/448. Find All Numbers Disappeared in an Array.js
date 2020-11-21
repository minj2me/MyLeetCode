/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDisappearedNumbers = function (nums) {
    // let res = [];
    // for (let i = 0; i < nums.length; i++) {
    //     let idx = Math.abs(nums[i]) - 1
    //     if (nums[idx] > 0)
    //         nums[idx] = -nums[idx];
    // }
    // for (let i = 0; i < nums.length; i++) {
    //     if (nums[i] > 0)
    //         res.push(i + 1);
    // }
    // return res;

    let set = new Set();
    let index = 1;
    let res = [];
    for (let n of nums) {
        set.add(n);
    }
    for (let n of nums) {
        if (!set.has(index)) {
            res.push(index);
        }
        index++;
    }
    //console.log(res);
    return res;
};