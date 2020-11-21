package LeetCode_1356

import java.util.*

/**
 * 1356. Sort Integers by The Number of 1 Bits
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
 *
 * Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in
 * their binary representation and in case of two or more integers have the same number of 1's you have to sort
 * them in ascending order.

Return the sorted array.

Example 1:
Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]

Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.

The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 4:

Input: arr = [2,3,5,7,11,13,17,19]
Output: [2,3,5,17,7,11,13,19]
 * */
class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        val list = arr.sortedWith(Comparator<Int> { a, b ->
            val countOneA = countOneBit(a)
            val countOneB = countOneBit(b)
            if (countOneA - countOneB == 0) {
                //All integers have 1 bit in the binary representation,
                //you should just sort them in ascending order.
                a - b
            } else {
                countOneA - countOneB
            }
        })
        return list.toIntArray()
    }

    private fun countOneBit(n_: Int): Int {
        var n = n_
        var count = 0
        for (i in 0 until 32) {
            count += n and 1
            n = n shr 1
        }
        return count
    }
}