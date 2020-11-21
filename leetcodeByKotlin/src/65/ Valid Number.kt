package LeetCode_65

/**
 * 65. Valid Number
 * https://leetcode.com/problems/valid-number/description/
 *
 * Validate if a given string can be interpreted as a decimal number.
Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous.
You should gather all requirements up front before implementing one.
However, here is a list of characters that can be in a valid decimal number:
1. Numbers 0-9
2. Exponent - "e"
3. Positive/negative sign - "+"/"-"
4. Decimal point - "."
 * */
class Solution {
    fun isNumber(s: String): Boolean {
        var eSeen = false
        var dotSeen = false
        var numSeen = false
        val s2 = s.trim()
        for (i in s2.indices) {
            val c = s2[i]
            if (c.isDigit()) {
                numSeen = true
            } else if (c == 'e') {
                //e can not seen more than one time
                if (!numSeen || eSeen) {
                    return false
                }
                eSeen = true
                //for example "1e" is not valid, so while e has seen, need set numSeen to false
                numSeen = false
            } else if (c == '.') {
                if (dotSeen || eSeen) {
                    /*
                    * 1.dot cannot appear two times
                    * 2.just can appear after e, for example: 99e2.5 is not Valid
                    * */
                    return false
                }
                dotSeen = true
            } else if (c == '+' || c == '-') {
                if (i != 0 && s2[i - 1] != 'e') {
                    /*
                    * + and -
                    * 1.can appear in first position
                    * 2.if appear after e, is valid, for example: "005047e+6" is valid
                    * */
                    return false
                }
            } else {
                //abc is not valid
                return false
            }
        }
        return numSeen
    }
}