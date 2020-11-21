package LeetCode_1064

/**
 * 1064. Fixed Point
 * Lock by LeetCode
 * Given an array A of distinct integers sorted in ascending order, return the smallest index i that satisfies A[i] == i.
 * Return -1 if no such i exists.

Example 1:
Input: [-10,-5,0,3,7]
Output: 3
Explanation:
For the given array,
A[0] = -10, A[1] = -5, A[2] = 0, A[3] = 3
, thus the output is 3.

Example 2:
Input: [-10,-5,3,4,7,9]
Output: -1
Explanation:
There is no such i that A[i] = i, thus the output is -1.

Note:
1 <= A.length < 10^4
-10^9 <= A[i] <= 10^9
 * */
class Solution {
    fun fixedPoint(array: IntArray): Int {
        //brute force, O(n)
        /*for (i in 0 until array.size) {
            if (i == array[i]) {
                return i
            }
        }
        return -1*/

        //binary search, O(logN)
        var left = 0
        var right = array.size
        while (left <= right) {
            val mid = (left + right) shr 1
            if (array[mid] == mid) {
                return mid
            } else if (array[mid] < mid) {
                //need find in right side
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return -1
    }
}