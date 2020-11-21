package LeetCode_728

/**
 * 728. Self Dividing Numbers
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
Also, a self-dividing number is not allowed to contain the digit zero.
Given a lower and upper number bound, output a list of every possible self dividing number,including the bounds if possible.
 * */
class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val result = ArrayList<Int>()
        for (i in left..right) {
            if (check(i)) {
                result.add(i)
            }
        }
        //println(result)
        return result
    }

    private fun check(n: Int): Boolean {
        //for example 128: 128%10=8,then 128/10 = 12, 12%10=2
        var temp = n
        val num = n
        while (temp != 0) {
            //temp % 10 == 0 is check a number if contains 0
            if (temp % 10 == 0 || num % (temp % 10) != 0) {
                return false
            }
            temp /= 10
        }
        return true
    }
}