package LeetCode_287

/**
 * 287. Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one duplicate number in nums, return this duplicate number.
Follow-ups:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)?

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Constraints:
1. 2 <= n <= 3 * 104
2. nums.length == n + 1
3. 1 <= nums[i] <= n
4. All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * */
class Solution {
    /*
    * solution: Binary Search, scan array to find how many number in range: [low,mid),[mid,mid],(mid,high]
    * Time complexity:O(nlogn), Space complexity:O(1)
    * */
    fun findDuplicate(nums: IntArray): Int {
        var low = 1
        var high = nums.size
        while (low < high) {
            var leftCount = 0
            var midCount = 0
            var rightCount = 0
            val mid = low + (high - low) / 2
            //check each number
            for (num in nums) {
                if (num == mid) {
                    midCount++
                } else if (num >= low && num < mid) {
                    leftCount++
                } else if (num > mid && num < high) {
                    rightCount++
                }
            }
            if (midCount > 1) {
                return mid
            } else if (leftCount > mid - low) {
                //if (leftCount > mid - low),just mean duplicate num in left side
                //because this duplicate num occupy in left side position
                high = mid
            } else if (rightCount > high - mid - 1) {
                //otherwise duplicate num occupy in right side
                low = mid + 1
            }
        }
        //because must have answer, so no check if need return -1
        return low
    }
}