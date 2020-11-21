/***
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 *
 * Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]

Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

，这种方法先给两个数组排序，然后用两个指针分别指向两个数组的起始位置，如果两个指针指的数字相等，则存入结果中，
两个指针均自增1，如果第一个指针指的数字大，则第二个指针自增1，反之亦然
 */
package LeetCode_350

import java.util.*

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val size = Math.max(nums1.size, nums2.size)
        val result = ArrayList<Int>(size)
        nums1.sort()
        nums2.sort()
        var i = 0
        var j = 0
        while (nums1.size > i && nums2.size > j) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i])
                i++
                j++
            } else if (nums1[i] > nums2[j]) {
                j++
            } else {
                i++
            }
        }
        val list = IntArray(result.size)
        var index = 0
        for (item in result) {
            list.set(index++, item)
        }
        return list
    }
}