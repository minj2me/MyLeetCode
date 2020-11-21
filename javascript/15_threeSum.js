/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/description/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
var threeSum = function () {
    //time: O(n平方)
    //space: O(n)
    // 220 ms!!!
    let result = [];
    let target = 0;
    //result[0] = [];
    let start = 0, end = nums.length - 1;
    //sort it first
    nums.sort(function (a, b) { return a - b });
    for (let i = 0; i < nums.length; i++) {
        if (i != 0 && nums[i] == nums[i - 1])//avoid duplicate
            continue;
        start = i + 1;
        end = nums.length - 1;
        while (start < end) {
            let tempValue = nums[i] + nums[start] + nums[end];
            if (tempValue > target)
                end--;
            else if (tempValue < target)
                start++;
            else {
                //found
                result.push([nums[i], nums[start], nums[end]]);
                //以下为去重作用
                start++;
                end--;
                while (nums[start] == nums[start - 1])
                    start++;
                while (nums[end] == nums[end + 1])
                    end--;
                // while (start < end && nums[start] == nums[start - 1])
                //     start++;
                // while (start < end && nums[end] == nums[end + 1])
                //     end--;
            }
        }
    }
    //console.log(result);
    return result;
};