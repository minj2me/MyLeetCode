package LeetCode_974

/**
 * 974. Subarray Sums Divisible by K
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
Example 1:
Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Note:
1. 1 <= A.length <= 30000
2. -10000 <= A[i] <= 10000
3. 2 <= K <= 10000
 * */
class Solution {
    /*
    * solution: prefixSum, Mathematics, HashMap,
    * if any two number divided by k have the same remainder,then the difference between the two number can be divisible by k;
    * for example: a=7, b=12, k=5, a%k==b%k; 7%5=2, 12%5=2, so (b-a)%k=0 => (12-7)%5=0,
    * so the problem can change to find out the number of same remainder.
    * */
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        var result = 0
        //key: remainder, value:appearance of this remainder
        val map = HashMap<Int, Int>()
        var sum = 0
        for (item in A) {
            sum += item
            var remainder = sum % K
            if (remainder < 0) {
                remainder += K
            }
            //if remainder==0, mean current range is a result
            if (remainder == 0) {
                result++
            }
            val currentCount = map.getOrDefault(remainder, 0)
            result += currentCount
            map.put(remainder, currentCount + 1)

        }
        return result
    }
}
