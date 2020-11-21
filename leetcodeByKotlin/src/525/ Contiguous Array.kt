package LeetCode_525

/**
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Example 1:
Input: [0,1]
Output: 2
Explanation:
[0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.
 * */
class Solution {
    /*
    * solution: HashMap + Prefix Sum, Time:O(n), Space:O(n)
    * */
    fun findMaxLength(nums: IntArray): Int {
        //key: sum
        //value: the index of where the sum first appeared
        val map = HashMap<Int, Int>()
        map.put(0, -1)
        var result = 0
        var sum = 0
        for (i in nums.indices) {
            sum += if (nums[i] == 0) -1 else nums[i]
            /*
            * if sum is 0, mean the number of 0 and 1 is the same,
            * when the same prefix sum appears at i,j,
            * if sum(i+1,j)==0, than result = max(result, j-i)
            * */
            /*if (map.contains(sum)) {
                result = Math.max(result, i - map.get(sum)!!)
            } else {
                map.put(sum, i)
            }*/
            //if contains the sum, we do not update it, because current index in map is the top_index,
            //so can keeping i - top_index is the maximum length
            val lastIndex = map[sum - 0]
            if (lastIndex != null) {
                result = Math.max(result, i - lastIndex)
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i)
            }
        }
        //println(map)
        return result
    }
}