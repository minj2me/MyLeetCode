/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Note:
Your algorithm should run in O(n) time and uses constant extra space.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function (nums) {
    let set = new Set();
    let max = 0;
    for (let n of nums) {
        set.add(n);
        max = Math.max(max, n);
    }
    //console.log("max:"+max);
    for (let i = 1; i <= max; i++) {
        if (!set.has(i))
            return i;
    }
    //console.log(res[0]);
    return max + 1;

    //!!but need uses constant extra space
}