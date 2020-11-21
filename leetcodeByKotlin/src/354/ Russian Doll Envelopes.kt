package LeetCode_354

/**
 * 354. Russian Doll Envelopes
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:
Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * */
class Solution {
    /*
    * Solution 1: DP, like LIS, Time complexity:O(n^2), Space complexity:O(n)
    * */
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        if (envelopes.isEmpty()) {
            return 0
        }
        val dp = IntArray(envelopes.size, { 1 })
        var result = 0
        //sort array by width increasing
        envelopes.sortWith(Comparator { a, b -> a[0] - b[0] })
        for (i in envelopes.indices) {
            for (j in 0 until i) {
                //if size of current envelope less than previous one,mean can put in
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1)
                }
            }
            //update result after scan every envelope
            result = Math.max(result, dp[i])
        }
        return result
    }
}