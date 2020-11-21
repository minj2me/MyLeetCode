/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * https://www.cnblogs.com/yaoyudadudu/p/9227069.html
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
    let left = 0, right = nums.length - 1;
    let mid = 0;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (left == mid)
            break;
        if (nums[mid] > nums[right])
            left = mid;//表示小的在右段，如3,4,5,1,2
        else
            right = mid;//表示小的在左段
    }
    return Math.min(nums[mid], nums[right]);
};