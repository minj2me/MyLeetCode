/**
 * 674. Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 * https://www.cnblogs.com/grandyang/p/7608976.html
 * 
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 

Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function (nums) {
    let len = nums.length;
    if (len <= 1)
        return len;
    let right = 0, res = 0, count = 1;
    while (right < len) {
        let cur = nums[right];
        let next = nums[right + 1];
        if (next > cur)
            count++;
        else
            count = 1;//found again
        res = Math.max(res, count);
        right++;
    }
    return res;
};