package LeetCode_1426

import java.util.*

/**
 * 1426. Counting Elements
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them separately.
 * Example 1:
 * Input: arr = [1,2,3] Output: 2, Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:
Input: arr = [1,1,2] Output: 2, Explanation: 1 counted twice cause 2 is in arr.
 * */
class Solution {
    fun countElements(array: IntArray): Int {
        var ans = 0
        val set = HashSet<Int>()
        for (item in array) {
            set.add(item)
        }
        for (i in array.indices) {
            if (set.contains(array[i] + 1)) {
                ans++
            }
        }
        return ans
    }
}