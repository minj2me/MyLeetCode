package LeetCode_338

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 * https://www.cnblogs.com/grandyang/p/5294255.html
 *
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and
 * return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
 * */
class Solution {
    //follow up:
    //But can you do it in linear time O(n) /possibly in a single pass?
    fun countBits(num: Int): IntArray {
        val res = IntArray(num + 1)
        //method 1.
        for (i in 0..num) {
            res.set(i, countOne(i))
        }
        return res
    }

    fun countOne(num: Int): Int {
        var n = num
        var count = 0
        for (i in 0 until 31) {
            count += n and 1
            n = n shr 1
        }
        return count
    }
}