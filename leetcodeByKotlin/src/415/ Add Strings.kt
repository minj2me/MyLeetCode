package LeetCode_415


/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/description/
 *
 * follow up, need fix decimals fraction
 * */
class Solution {
    fun addStrings(num1: String, num2: String): String {
        val point1Index = num1.indexOf(".")
        val point2Index = num2.indexOf(".")
        val sb = StringBuilder()
        val needHandleDecimalFraction = point1Index > 0 || point2Index > 0

        if (!needHandleDecimalFraction) {
            return help(num1, num2, 0)
        } else {
            var num1Integer = ""
            var num1DecimalFraction = ""

            var num2Integer = ""
            var num2DecimalFraction = ""

            if (point1Index > 0) {
                val num1List = num1.split(".")
                num1Integer = num1List.get(0)
                num1DecimalFraction = num1List.get(1)
            } else {
                num1Integer = num1
            }
            if (point2Index > 0) {
                val num2List = num2.split(".")
                num2Integer = num2List.get(0)
                num2DecimalFraction = num2List.get(1)
            } else {
                num2Integer = num2
            }

            val sbSub = StringBuilder()
            if (help2(num1DecimalFraction, num2DecimalFraction, sbSub)) {
                sb.append(help(num1Integer, num2Integer, 1))
            } else {
                sb.append(help(num1Integer, num2Integer, 0))
            }
            sb.append(".")
            sb.append(sbSub.reverse().toString())
            //sb.append(help2(num1DecimalFraction, num2DecimalFraction))
            println("result:${sb.toString()}")
            return sb.toString()
        }
    }

    private fun help(num1: String, num2: String, defaultCarry: Int): String {
        var i = num1.length - 1
        var j = num2.length - 1
        val sb = StringBuilder()
        var carry = defaultCarry
        while (i >= 0 || j >= 0) {
            var sum = 0
            if (i >= 0) {
                sum += (num1[i].toInt() - '0'.toInt())
            }
            if (j >= 0) {
                sum += (num2[j].toInt() - '0'.toInt())
            }
            sum += carry
            if (sum >= 10) {
                carry = sum / 10
                sum %= 10
            } else {
                carry = 0
            }
            sb.append(sum)
            i--
            j--
        }
        if (carry != 0) {
            sb.append(1)
        }
        return sb.reverse().toString()
    }

    private fun insertZero(string: String, count: Int): String {
        val sb = StringBuilder()
        sb.append(string)
        for (i in 0 until count) {
            sb.append("0")
        }
        return sb.toString()
    }

    /**
     * follow up, need fix decimals fraction
     * 处理小数点后面的数的添加
     * */
    private fun help2(num1: String, num2: String, sb: StringBuilder): Boolean {
        val maxLength = Math.max(num1.length, num2.length)
        var newNum1 = num1
        var newNum2 = num2
        if (num1.length < maxLength) {
            newNum1 = insertZero(num1, maxLength - num1.length)
        }
        if (num2.length < maxLength) {
            newNum2 = insertZero(num2, maxLength - num2.length)
        }
        //println("newNum1:$newNum1")
        //println("newNum2:$newNum2")
        val n1 = newNum1.length
        val n2 = newNum2.length
        var i = n1 - 1
        var j = n2 - 1
        var carry = 0
        while (i >= 0 || j >= 0) {
            var sum = 0
            if (i >= 0) {
                sum += (newNum1[i].toInt() - '0'.toInt())
            }
            if (j >= 0) {
                sum += (newNum2[j].toInt() - '0'.toInt())
            }
            sum += carry
            if (sum >= 10) {
                carry = sum / 10
                sum %= 10
            } else {
                carry = 0
            }
            sb.append(sum)
            i--
            j--
        }
        if (carry != 0) {
            return true
        }
        return false
    }
}