/**
 * 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/description/
 * https://www.cnblogs.com/grandyang/p/7865693.html
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function (nums) {
    let sum = 0;
    for (let i = 0; i < nums.length; i++) {
        sum += nums[i];
    }
    let curSum = 0;
    for (let i = 0; i < nums.length; i++) {
        // console.log("sum - nums[i] :"+(sum - nums[i]));
        // console.log("curSum:"+curSum);
        if (sum - nums[i] == 2 * curSum)
            return i;
        curSum += nums[i];
    }
    return -1;
};