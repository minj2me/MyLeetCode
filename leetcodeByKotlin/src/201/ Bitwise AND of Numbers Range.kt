package LeetCode_201

/**
 * 201. Bitwise AND of Numbers Range (数字范围按位相与)
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
 * https://leetcode.wang/leetcode-201-Bitwise-AND-of-Numbers-Range.html
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
Example 1:
Input: [5,7]
Output: 4
 * */
class Solution {
    /*
    solution 1:traverse all numbers from m to n and do bitwise AND;
    solution 2: Most Significant Bit (msb), 最高有效位, 在大端序中，msb就是左最边的位;
    * 1. get msb of two number
    * 2. if two msb are equals, return 0; else add 2^msp_value into result
    * 3. subtract msp_value from m and n
    * */
    fun rangeBitwiseAnd(m_: Int, n_: Int): Int {
        //solution 1:
        /*if (m == Int.MAX_VALUE) {
            return m
        }
        var result = m
        for (i in m + 1..n) {
            result = i and result
            if (result == 0 || i == Int.MAX_VALUE) {
                break
            }
        }*/

        //solution 2:
        var m = m_
        var n = n_
        var result = 0
        while (m > 0 && n > 0) {
            val msbM = msbPosition(m)
            val msbN = msbPosition(n)
            if (msbM != msbN) {
                break
            }
            //1 shl msbM = 2^msbM = 2的msbM次方
            val msbValue = 1 shl msbM
            result += msbValue
            m -= msbValue
            n -= msbValue
        }
        return result
    }

    private fun msbPosition(n_: Int): Int {
        var msb = -1
        var n = n_
        //position++ when n shift right until n==0 (mean reach n's most highest bit)
        while (n > 0) {
            n = n shr 1
            msb++
        }
        return msb
    }
}