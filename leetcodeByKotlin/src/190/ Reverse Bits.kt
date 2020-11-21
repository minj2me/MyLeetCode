package LeetCode_190

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/description/
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * =========================
 * 如10进制，反转一个数:n
 * result = result*10+n%10
 * n /= 10
 * 2进制下，也可以相同的方法:
 * do in Base-2 so for so on: 但n是负数时，%2并不能得到正确的数,
 * 如: -3:
 * 11111111111111111111111111111101
 * result = result*2+n%2
 * n /= 2
 *
 * or use bit operators:
 * result  = (result << 1) | (n & 1)
 * n >>=1
 *
  for example: n=123, result = 0
 * result = 123=>0*10+3 = 3
 * n/=10=>12
 * result = 3*10+2 = 32
 * n/=10=>1
 * result = 32*10+1 = 321
 *
 * test case:
 * 43261596
 * */
class Solution {
    fun reverseBits(n_: Int): Int {
        var n = n_
        var result = 0
        for (i in 0 until 32) {
            //n%2 的位运算可用:n and 1
            result = (result shl 1) + (n and 1)
            n = n shr 1

            /*result = result * 2 + n % 2
            println("result:$result")
            n /= 2*/
        }
        //n=-3时:11111111111111111111111111111101
        //kotlin答案为负数:-1073741825
        //java的才正确为:3221225471，二进制为:10111111111111111111111111111111
        return result
    }
}