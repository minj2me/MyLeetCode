/**
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/description/
 * https://www.cnblogs.com/grandyang/p/6529857.html
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function (nums) {
    let len = nums.length;
    for (let i = 0; i < len; i++) {
        if (nums[i] == 0)
            nums[i] = -1;
    }
    //console.log(nums);
    let map = new Map();
    map.set(0, -1);
    let sum = 0, res = 0;
    for (let i = 0; i < len; i++) {
        sum += nums[i];
        // console.log("sum:" + sum + ", i:" + i);
        if (map.has(sum))
            res = Math.max(res, i - map.get(sum));
        else
            map.set(sum, i);
    }
    // console.log(map);
    return res;
};