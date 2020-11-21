/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * https://www.cnblogs.com/grandyang/p/4325648.html
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    //[4,5,6,7,0,1,2,3], 3
    //runtime 52 ms
    let left = 0, right = nums.length - 1;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < nums[right]) {
            //在mid的后半段的递增中找target
            if (nums[mid] < target && nums[right] >= target)
                left = mid + 1;
            else
                right = mid - 1;
        } else {
            //在mid的前半段的递增中找target
            if (nums[left] <= target && nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
    }
    return -1;
};