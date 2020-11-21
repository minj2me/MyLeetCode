package LeetCode_503

import java.util.*

/**
 * 503. Next Greater Element II
 * https://leetcode.com/problems/next-greater-element-ii/description/
 *
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element.
 * The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number.
 * If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.

Note: The length of given array won't exceed 10000.
 * */
class Solution {
    /**
     * solution 1: brute force, Time complexity:O(n*n), Space complexity:O(n)
     * solution 2: monotonic stack, Time complexity:O(n), Space complexity:O(n)
     * */
    fun nextGreaterElements(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n, { -1 })
        //solution 1
        /*for (i in nums.indices) {
            //because need loop through array, we use j%n
            for (j in i + 1 until (i + n)) {
                if (nums[j % n] > nums[i]) {
                    result.set(i, nums[j % n])
                    break
                }
            }
        }*/
        //solution 2, store indices of monotonically increasing element
        val stack = Stack<Int>()
        for (i in 0 until 2 * n) {
            //because need loop through array, we use j%n
            val num = nums[i % n]
            while (stack.isNotEmpty() && nums[stack.peek()] < num) {
                result.set(stack.pop(), num)
            }
            //need to care about the index
            if (i < n) {
                stack.push(i)
            }
        }
        return result
    }
}