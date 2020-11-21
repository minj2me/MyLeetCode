package LeetCode_860

/**
 * 860. Lemonade Change
 * https://leetcode.com/problems/lemonade-change/description/
 * */
class Solution {
    //使用贪心，策略是每次找钱选择10元，尽量保留5元的
    fun lemonadeChange(bills: IntArray): Boolean {
        var fiveCount = 0
        var tenCount = 0
        for (bill in bills) {
            if (bill == 5) {
                fiveCount++
            } else if (bill == 10) {
                tenCount++
                fiveCount--
            } else if (tenCount > 0) {
                //if can change for 10, give 10 and 5
                fiveCount--
                tenCount--
            } else {
                //just can give back 5
                fiveCount -= 3
            }
            if (fiveCount < 0) {
                return false
            }
        }
        return true
    }
}