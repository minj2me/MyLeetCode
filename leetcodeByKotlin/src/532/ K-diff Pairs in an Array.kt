package LeetCode_532

/**
 * 532. K-diff Pairs in an Array
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
 * */
class Solution {
    /*
    *Time complexity:O(n), Sapce:O(n)
    * */
    fun findPairs(nums: IntArray, k: Int): Int {
        var res = 0
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map.put(num, map.getOrDefault(num, 0) + 1)
        }
        //println(map)
        //如果k为0且该数字出现的次数大于1，则结果 res 自增1；
        //如果k不为0，且用当前数字加上k后得到的新数字也在数组中存在，则结果 res 自增1
        for (item in map) {
            if (k == 0 && item.value > 1) {
                res++
            }
            if (k > 0 && map.containsKey(item.key + k)) {
                res++
            }
        }
        return res
    }
}