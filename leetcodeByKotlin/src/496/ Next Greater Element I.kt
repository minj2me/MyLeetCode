package LeetCode_496

import java.util.*
import kotlin.collections.HashMap

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/description/
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
For number 2 in the first array, the next greater number for it in the second array is 3.
For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 * */
class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val result = IntArray(nums1.size)
        //solution 1: brute force
        /*for (i in nums1.indices) {
            var j = 0
            while (j < nums2.size) {
                //find out the index of same digit
                if (nums1[i] == nums2[j]) {
                    break
                }
                j++
            }
            //scan nums2 from the index we find below to end
            //num1 = [2,4], nums2 = [1,2,3,4].
            var k = j + 1
            while (k < nums2.size) {
                //for example in [1,2,3,4], if 3>2 set to the result
                if (nums2[k] > nums2[j]) {
                    result.set(i, nums2[k])
                    break
                }
                k++
            }
            if (k == nums2.size) {
                result.set(i, -1)
            }
        }*/

        //solution 2: monotonic stack + map
        val stack = Stack<Int>()
        val map = HashMap<Int, Int>()
        for (num in nums2) {
            //这里是建立每个数字和其右边第一个较大数之间的映射
            //create the match for each number and the first bigger number in it right hand side for array2
            //for example: 1,2,3,4=>{1=2, 2=3, 3=4}
            while (stack.isNotEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num)
            }
            stack.push(num)
        }
        //println(map)
        for (i in nums1.indices) {
            result.set(i, map.get(nums1[i]) ?: -1)
        }

        return result
    }
}