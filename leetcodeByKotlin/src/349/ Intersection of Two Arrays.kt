/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 *
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Note:

Each element in the result must be unique.
The result can be in any order.
 * */
package `LeetCode_349`

class Solution {
    fun intersection(num1: IntArray, num2: IntArray): IntArray {
        num1.sort();
        num2.sort();
        var index1 = 0;
        var index2 = 0;
        var map = HashMap<Int, Int>();
        while (index1 < num1.size && index2 < num2.size) {
            if (num1[index1] < num2[index2])
                index1++
            else if (num1[index1] > num2[index2])
                index2++
            else {
                if (map.get(num2[index2]) == null)
                    map.put(num2[index2], num2[index2]);
                index1++
                index2++
            }
        }
        var totalIndex = 0;
        var result = IntArray(map.size);
        map.forEach { (key, value) ->
            result.set(totalIndex, key);
            totalIndex++;
        };
        return result;
    }

    fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0;
        var right = nums.size - 1;
        while (left <= right) {
            val mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target)
                right = mid - 1;//find in left side
            else
                left = mid + 1;
        }
        return left;
    }

}