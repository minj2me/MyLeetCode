/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * https://www.cnblogs.com/Dylan-Java-NYC/p/4868734.html
 * 
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */
/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function (s, nums) {
    //Runtime: 56 ms
    //!!use sliding window, two pointer 
    // let low = 0, high = 0, minLen = nums.length + 1, num = 0, i = 0;
    // for (; high < nums.length; high++) {
    //     num += nums[high];
    //     while (num >= s) {
    //         minLen = Math.min(minLen, high - low + 1);
    //         num -= nums[low];
    //         low++;
    //     }
    // }
    // return minLen == nums.length + 1 ? 0 : minLen;

    if (nums == null || nums.length == 0 || s <= 0)
        return 0;
    let res = Number.MAX_VALUE, left = 0, right = 0, len = nums.length, sum = 0;
    while (right < len) {
        sum += nums[right++];
        while (sum >= s) {
            res = Math.min(res, right - left);
            sum = sum - nums[left++];
        }
    }
    return res == Number.MAX_VALUE ? 0 : res;

};