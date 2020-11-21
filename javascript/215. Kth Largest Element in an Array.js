/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.

Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5

 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
    nums.sort(function (a, b) { return a - b })
    return nums[nums.length - k];
    // let left = 0,right = nums.length-1;
    // while (true){
    //     let pos = partition(nums,left,right);
    // }
};

var partition = function (nums, left, right) {

}