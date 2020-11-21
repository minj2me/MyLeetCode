package LeetCode_658

/**
 * 658. Find K Closest Elements
 * https://leetcode.com/problems/find-k-closest-elements/description/
 *
 * Given a sorted array arr, two integers k and x, find the k closest elements to x in the array.
 * The result should also be sorted in ascending order.
 * If there is a tie, the smaller elements are always preferred.

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 10^4
Absolute value of elements in the array and x will not exceed 104
 * */
class Solution {
    /*
    * solution: compare arr[0], arr[lastIndex] with x every time, delete the number that have a large distance,
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var list = arr.toList()
        while (list.size > k) {
            //if the distance of last element larger than the distance of first one, delete the last element,
            //otherwise delete the first one
            if (x - list[0] <= list[list.lastIndex] - x) {
                //Returns a list containing all elements except last [n] elements.
                //remove from tail
                list = list.dropLast(1)
            } else {
                //Returns a list containing all elements except first [n] elements.
                list = list.drop(1)
            }
        }
        return list
    }
}