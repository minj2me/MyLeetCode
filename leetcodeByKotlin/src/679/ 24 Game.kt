package LeetCode_679

/**
 * 679. 24 Game
 * https://leetcode.com/problems/24-game/
 *
 * You have 4 cards each containing a number from 1 to 9.
 * You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24

Example 2:
Input: [1, 2, 1, 2]
Output: False

Note:
1. The division operator / represents real division, not integer division.
For example, 4 / (1 - 2/3) = 12.
2. Every operation done is between two numbers. In particular, we cannot use - as a unary operator.
For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
3. You cannot concatenate numbers together.
For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 * */
class Solution {
    /*
    * solution: DFS,recursion, Time complexity:O(1), Space complexity:O(1)
    * */
    fun judgePoint24(nums: IntArray): Boolean {
        val cards = ArrayList<Double>()
        for (num in nums) {
            cards.add(num.toDouble())
        }
        return dfs(cards)
    }

    //take two card to calculate each dfs operation
    private fun dfs(list: List<Double>): Boolean {
        if (list.size == 1) {
            //check if can reach 24
            if (Math.abs(list.last() - 24.0) < 0.001) {
                return true
            }
            return false
        }
        //take out 2 cards each time
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                //possible combinations
                val a = list[i]
                val b = list[j]
                val combinations = arrayListOf(a + b, a - b, b - a, a * b)
                //check a,b if 0, because divisor can not be 0
                if (a > 0) {
                    combinations.add(b / a)
                }
                if (b > 0) {
                    combinations.add(a / b)
                }
                for (item in combinations) {
                    val nextRound = ArrayList<Double>()
                    nextRound.add(item)
                    for (k in list.indices) {
                        //if this card had calculated in this round, remove it for next round
                        if (k == i || k == j) {
                            continue
                        }
                        nextRound.add(list[k])
                    }
                    if (dfs(nextRound)) {
                        return true
                    }
                }
            }
        }
        return false
    }
}