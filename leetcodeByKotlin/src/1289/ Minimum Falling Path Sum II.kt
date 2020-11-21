package LeetCode_1289

/**
 * 1289. Minimum Falling Path Sum II
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * Given a square grid of integers arr,
 * a falling path with non-zero shifts is a choice of exactly one element from each row of arr,
 * such that no two elements chosen in adjacent rows are in the same column.
Return the minimum sum of a falling path with non-zero shifts.

Example 1:
Input: arr =
[[1,2,3],
[4,5,6],
[7,8,9]]
Output: 13
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.

Constraints:
1. 1 <= arr.length == arr[i].length <= 200
2. -99 <= arr[i][j] <= 99
 * */
class Solution {
    /*
   * solution : DP, Bottom-Up, for example array is:
   * [
       [1,2,3],
       [4,5,6],
       [7,8,9]
       ]
      fill new value from second row,the value of current i,j is: current value + (value by: smallest value in prevRow and currentCol!=prevCol)
       [1,2,3],
       [6,6,7],//<-this row after fill by: 4+min(2,3), 5+min(1,3), 6+min(1,2)
       [13,12,13],//<-this row after fill by: 7+min(6,7), 8+min(4,6), 9+min(4,5)
       result is minimum in last row

       Time complexity:O(m*n*logn), Space complexity:O(1)
   * */
    fun minFallingPathSum(arr: Array<IntArray>): Int {
        if (arr == null || arr.isEmpty()) {
            return 0
        }
        val m = arr.size
        val n = arr[0].size
        for (i in 1 until m) {
            //find out two smallest number at prev level
            //first: dp[i][j], second:cols
            val temp = Array<Pair<Int, Int>>(m) { Pair(0, 0) }
            for (k in 0 until n) {
                temp[k] = Pair(arr[i - 1][k], k)
            }
            temp.sortWith(Comparator { a, b -> a.first - b.first })
            for (j in 0 until n) {
                if (j != temp[0].second) {
                    //if current cols not equals prev cols and the value in prev cols is the smallest
                    arr[i][j] += temp[0].first
                } else {
                    arr[i][j] += temp[1].first
                }
            }
        }
        var result = Int.MAX_VALUE
        for (cols in 0 until n) {
            result = Math.min(result, arr[n - 1][cols])
        }
        return result
    }
}