/**
 * 179. Largest Number
https://leetcode.com/problems/largest-number/description/

 * Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"

Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
 */
/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function (nums) {
    let len = nums.length;
    //let map = new Map();
    if (len == 0)
        return "";
    //let result = [];
    nums.sort(function (a, b) {
        //console.log(b.toString()+a.toString());
        return b.toString() + a.toString() > a.toString() + b.toString();
    });
    console.log(nums);
    return nums[0] == "0" ? "0" : nums.join("");
};