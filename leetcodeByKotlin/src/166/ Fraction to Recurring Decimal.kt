package LeetCode_166

/**
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description/
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"
 * */
class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) {
            return "0"
        }
        if (denominator == 0) {
            return ""
        }
        val fractionSb = StringBuilder()
        //check if need add '-' in first
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            fractionSb.append("-")
        }
        val num = Math.abs(numerator.toLong())
        val den = Math.abs(denominator.toLong())
        var result = num / den
        fractionSb.append(result.toString())
        //get the remainder
        var remainder = num % den
        if (remainder == 0L) {
            //if divisible
            return fractionSb.toString()
        }
        fractionSb.append(".")
        //use map to help, key is remainder, value is result length
        val map = HashMap<Long, Int>()
        while (remainder != 0L) {
            val curString = fractionSb.toString()
            println(map)
            if (map.containsKey(remainder)) {
                val begin = map.get(remainder) ?: 0
                val part1 = curString.substring(0, begin)
                val part2 = curString.substring(begin, curString.length)
                return part1 + "(" + part2 + ")"
            }
            map.put(remainder, curString.length)
            //because we need to get every decimal, so *10 and do again
            remainder *= 10
            result = remainder / den
            fractionSb.append(result.toString())
            //continue to get the new remainder
            remainder %= den
        }
        return fractionSb.toString()
    }
}