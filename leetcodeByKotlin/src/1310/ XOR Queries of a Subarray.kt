package LeetCode_1310

/**
 * 1310. XOR Queries of a Subarray
 * https://leetcode.com/problems/xor-queries-of-a-subarray/description/
 *
 * Given the array arr of positive integers and the array queries where queries[i] = [Li, Ri],
 * for each query i compute the XOR of elements from Li to Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ).
 * Return an array containing the result for the given queries.

Example 1:
Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
Output: [2,7,14,8]
Explanation:
The binary representation of the elements in the array are:
1 = 0001
3 = 0011
4 = 0100
8 = 1000
The XOR values for queries are:
[0,1] = 1 xor 3 = 2
[1,2] = 3 xor 4 = 7
[0,3] = 1 xor 3 xor 4 xor 8 = 14
[3,3] = 8

Example 2:
Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
Output: [8,0,4,4]

Constraints:
1. 1 <= arr.length <= 3 * 10^4
2. 1 <= arr[i] <= 10^9
3. 1 <= queries.length <= 3 * 10^4
4. queries[i].length == 2
5. 0 <= queries[i][0] <= queries[i][1] < arr.length
 * */
class Solution {
    /*
    * solution: prefix xor array,
    * because a^b^a = b, q[l,r] = q[0,r] ^ q[0,l-1], so q[l,r] = prefixXOR[r+1] ^ prefixXOR[l]
    * Time complexity:O(n)+O(q), Space complexity:O(n)
    * */
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray? {
        val n = arr.size
        val prefixXOR = IntArray(n + 1)
        for (i in 0 until n) {
            prefixXOR[i + 1] = prefixXOR[i] xor arr[i]
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val left = queries[i][0]
            val right = queries[i][1]
            result[i] = prefixXOR[right + 1] xor prefixXOR[left]
        }
        return result
    }
}