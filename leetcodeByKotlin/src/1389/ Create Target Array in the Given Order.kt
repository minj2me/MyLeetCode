package LeetCode_1389

/**
 * 1389. Create Target Array in the Given Order
 *https://leetcode.com/problems/create-target-array-in-the-given-order/
 *
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
1. Initially target array is empty.
2. From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
3. Repeat the previous step until there are no elements to read in nums and index.
Return the target array.
It is guaranteed that the insertion operations will be valid.

Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]

Constraints:
1. 1 <= nums.length, index.length <= 100
2. nums.length == index.length
3. 0 <= nums[i] <= 100
4. 0 <= index[i] <= i
 * */
class Solution {
    /*
    *solution: ArrayList, add(value): O(1), add(index, value): O(n),
    * insert into specified index, so Time:O(n^2), Space:O(n)
    * */
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val list = ArrayList<Int>()
        for (i in index.indices) {
            list.add(index[i],nums[i])
        }
        return list.toIntArray()
    }
}