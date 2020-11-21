package LeetCode_507

/**
 * 507. Perfect Number
 * https://leetcode.com/problems/perfect-number/description/
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.

Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14

Note: The input number n will not exceed 100,000,000. (1e8)
 * */
class Solution {
    fun checkPerfectNumber(num: Int): Boolean {
        if (num == 1) {
            return false
        }
        var sum = 0
        for (i in 1..num / 2) {
            //if the num can divide positive number from 2 to num/2
            if (num % i == 0) {
                sum += i
            }
        }

        return sum == num
    }
}