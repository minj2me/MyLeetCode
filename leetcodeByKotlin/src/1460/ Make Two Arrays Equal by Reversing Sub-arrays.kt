package LeetCode_1460

/**
 * 1460. Make Two Arrays Equal by Reversing Sub-arrays
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 *
 * Given two integer arrays of equal length target and arr.
In one step, you can select any non-empty sub-array of arr and reverse it.
You are allowed to make any number of steps.
Return True if you can make arr equal to target, or False otherwise.

Example 1:
Input: target = [1,2,3,4], arr = [2,4,1,3]
Output: true
Explanation: You can follow the next steps to convert arr to target:
1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
There are multiple ways to convert arr to target, this is not the only way to do so.

Constraints:
1. target.length == arr.length
2. 1 <= target.length <= 1000
3. 1 <= target[i] <= 1000
4. 1 <= arr[i] <= 1000
 * */
class Solution {
    /*
    * solution: use array to check if all element if equals,
    * Time:O(1001), Space:O(1001)
    * */
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val array1 = IntArray(1001)
        val array2 = IntArray(1001)
        //calculate number of appearance for each element
        for (item in target) {
            array1[item]++
        }
        for (item in arr) {
            array2[item]++
        }
        //check the result
        for (i in array1.indices) {
            if (array1[i] != array2[i]) {
                return false
            }
        }
        return true
    }
}