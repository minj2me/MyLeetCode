package LeetCode_763

/**
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/
 *
 * A string S of lowercase English letters is given.
 * We want to partition this string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:
S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
 * */
class Solution {
    /*
    * solution: brute force, Time complexity:O(n^2), Space complexity:O(1);
    * traverse S from left to right to find the last position of current char in String,
    * then compare to find partition;
    * */
    fun partitionLabels(S: String): List<Int> {
        val result = ArrayList<Int>()
        var start = 0
        var end = 0
        for (i in S.indices) {
            end = Math.max(end, S.lastIndexOf(S[i]))
            //found out the split point
            if (i == end) {
                result.add(end - start + 1)
                //update the start to current end
                start = end + 1
            }
        }
        return result
    }
}