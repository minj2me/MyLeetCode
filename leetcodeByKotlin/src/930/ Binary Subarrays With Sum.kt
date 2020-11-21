package LeetCode_930

/**
 * 930. Binary Subarrays With Sum
 * https://leetcode.com/problems/binary-subarrays-with-sum/description/
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?

Example 1:
Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation:
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
 * */
class Solution {
    //hashmap + prefixSum
    fun numSubarraysWithSum(A: IntArray, S: Int): Int {
        val map = HashMap<Int, Int>()
        //key：prefixSum value
        //value：number of appeared of the prefixSum value
        map.put(0, 1)
        var result = 0
        var prefixSum = 0
        for (num in A) {
            prefixSum += num
            result += map.getOrDefault(prefixSum - S, 0)
            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1)
        }
        return result
    }
}