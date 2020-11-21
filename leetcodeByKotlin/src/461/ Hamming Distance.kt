package LeetCode_461

/**
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are
 * different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 2的31次方.

Example:

Input: x = 1, y = 4
Output: 2

Explanation:
1 (0 0 0 1)
4 (0 1 0 0)
     ↑   ↑
different bits are 2

The above arrows point to positions where the corresponding bits are different.
 *
 * 我们先了解下位运算，包括:
 * & (与) : 1和1为1，其余为0;
 * | (或) : 有1为1，零零为0;
 * ^ (异或): 相同的为0，不同的为1;
 * ~ (取反): 按位取反；
 * >> (右移): 右移n位等于除于2的n次方；
 * << (左移): 左移n位等于乘于2的n次方；
 *
 * */
class Solution {
    fun hammingDistance(x_: Int, y_: Int): Int {
        //1.
        /*val exc = x xor y
        //calculate the number of 1
        //exc是x,y的异或，所以1就是他们的不同的值
        return exc.toString(2).count { it == '1' }*/

        //2.
        var result = 0
        var x = x_
        var y = y_
        //while (x > 0 || y > 0) {
        for (i in 0 until 32) {
            //result += (x xor y) and 1
            val bx = x and 1//get current bit, equal x%2
            val by = y and 1
            if (bx != by) {
                result++
            }
            x = x shr 1 //除于2
            y = y shr 1
        }
        println("result:$result")
        return result
    }
}