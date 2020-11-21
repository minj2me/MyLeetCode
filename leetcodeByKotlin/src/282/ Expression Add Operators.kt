package LeetCode_282

/**
 * 282. Expression Add Operators
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"]

Constraints:
0 <= num.length <= 10
num only contain digits.
 * */
class Solution {
    private val result = ArrayList<String>()
    private var num = ""
    private var target = 0L
    /**
     * solution: dfs, Time complexity:O(4^n), Space complexity:O(n)
     * */
    fun addOperators(num: String, target: Int): List<String> {
        this.num = num
        this.target = target.toLong()
        dfs(0, "", 0, 0)
        return result
    }

    private fun dfs(index: Int, candidate: String, curSum: Long, last: Long) {
        if (target == curSum && index == num.length) {
            result.add(candidate)
            return
        }
        for (i in index until num.length) {
            if (i != index && num[index] == '0') {
                break//avoid "01"
            }
            val next = num.substring(index, i + 1).toLong()
            if (index == 0) {
                //the first must be +
                dfs(i + 1, next.toString(), next, next)
                continue
            }
            dfs(i + 1, candidate + "+" + next, curSum + next, next)
            dfs(i + 1, candidate + "-" + next, curSum - next, -next)
            dfs(i + 1, candidate + "*" + next, curSum - last + last * next, last * next)
        }
    }
}