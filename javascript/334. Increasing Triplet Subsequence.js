/**
 * 334. Increasing Triplet Subsequence
 * 
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * 
 * https://www.programcreek.com/2015/02/leetcode-increasing-triplet-subsequence-java/
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true

Example 2:

Input: [5,4,3,2,1]
Output: false
 */
/**
 * @param {number[]} nums
 * @return {boolean}
 * 
 * This problem can be converted to be finding if there is a sequence such that 
 * the_smallest_so_far < the_second_smallest_so_far < current. We use x, y and z to denote the 3 number respectively.
 */
var increasingTriplet = function (nums) {
    let len = nums.length;
    if (len < 3) return false;
    let x = Number.MAX_VALUE, y = Number.MAX_VALUE, z = 0;
    for (let i = 0; i < len; i++) {
        z = nums[i];
        if (x >= z) {
            x = z;
            //console.log("x:" + x);
        } else if (y >= z) {
            y = z;
            //console.log("y:" + y);
        } else
            return true;
    }
    return false;
};