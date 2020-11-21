package LeetCode_191

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/description/
 *
 * Write a function that takes an unsigned integer and return the number of '1' bits it has
 * (also known as the Hamming weight).
 * */
class Solution {

    fun hammingWeight(n: Int): Int {
        /**
         * 以下是完整的位运算符（只用于Int和Long）
        shl(bits) – 有符号左移（signed shift left，相当于Java的<<）
        shr(bits) – 有符号右移（signed shift right，相当于Java的>>）
        ushr(bits) – 无符号右移（unsigned shift right，相当于Java的>>>）
        and(bits) – 按位与（bitwise and，相当于Java的&）//一一为一，其它为0
        or(bits) – 按位或（bitwise or，相当于Java的|） //有一为一，零零为0
        xor(bits) – 按位异或（bitwise xor，相当于Java的^）//相同为0，不相同为1
        inv() – 按位取反（bitwise inversion，相当于Java的~）var z = y.inv() //z是y取反获得的
         */
        /*var binN = Integer.toBinaryString(n)
        var count = 0
        println(binN)
        for (str in binN){
            //println(str);
            if (str=='1')
                count++
        }*/
        var n_ = n
        var count = 0
        for (i in 0..31) {//无符号整型只是正整数,有符号整型可以是正和负整数
            count += (n_ and 1)//n_和1进行与运算，如结果是1，count就等于++
            n_ = n_ shr 1//右移1位, 等于除以2
        }
        return count
    }

    /**
     * 打印n的二进制值
     * */
    fun intToBinaryString(n: Int) {
        println(Integer.toBinaryString(n))
        val sb = StringBuilder()
        var n_ = n
        for (i in 0..31) {
            sb.append((n_ and 1))
            n_ = n_ shr 1
        }
        println(sb.toString())
    }

    /**
     * 左移，正负都是在右边补0；
     * 右移，正数补0，负数补1
     * */

    var answerList: Array<Int>? = null

    private fun addendValue(x: Int, y: Int, N: Int, queries: Array<Array<Int>>): Array<Int> {
        answerList = Array<Int>(10, { 0 })//init it, all element is 0
        var rowIndex = x.xor(1) % N
        val seq = queries.get(rowIndex)
        seq.set(0, y)
        var type = 0
        when (type){
            1->{
                
            }
        }
        return answerList!!
    }

}
