package LeetCode_179

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/description/
 * https://www.cnblogs.com/grandyang/p/4225047.html
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:
Input: [10,2]
Output: "210"

Example 2:
Input: [3,30,34,5,9]
Output: "9534330"

Note: The result may be very large, so you need to return a string instead of an integer.
 * */
class Solution {
    /*
    * solution: array sort by string of num,
    * for example:
    * String s1 = "9";
     String s2 = "31";
    String case1 =  s1 + s2; // 931
    String case2 = s2 + s1; // 319
    * */
    fun largestNumber(nums: IntArray): String {
        val nums_ = nums.sortedWith(Comparator { a, b ->
            /*val aString = a.toString()
            val bString = b.toString()
            when {
                (aString + bString) < (bString + aString) -> 1
                (aString + bString) > (bString + aString) -> -1
                else -> 0
            }*/
            val string1 = a.toString() + b.toString()
            val string2 = b.toString() + a.toString()
            string2.compareTo(string1)
        })
        val result = StringBuilder()
        for (i in nums_.indices) {
            if (nums_[0] == 0) {
                return "0"
            } else {
                result.append(nums_[i])
            }
        }
        print(result.toString())
        return result.toString()
    }
}