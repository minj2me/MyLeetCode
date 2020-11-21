package LeetCode_22

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/description/
 * https://github.com/grandyang/leetcode/issues/22
 * https://www.youtube.com/watch?v=sz1qaKt0KGQ&t=360s (recursion tree)
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
 * */
class Solution {

    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        //backtrack(result, "", 0, 0, n)
        backtrack2(result, "", n, n)
        println(result)
        return result
    }

    private fun backtrack(result: ArrayList<String>, currentStr: String, open: Int, close: Int, n: Int) {
        //println("currentStr:$currentStr")
        if (currentStr.length == n * 2) {
            //println("currentStr:$currentStr")
            result.add(currentStr)
            return
        }
        if (open < n) {
            //println("add (")
            backtrack(result, currentStr + "(", open + 1, close, n)
            //println("begin to backtracking after add (")
        }
        //because we cannot have closing parenthesis before opening parenthesis
        if (close < open) {
            //println("add )")
            backtrack(result, currentStr + ")", open, close + 1, n)
            //println("begin to backtracking after add )")
        }
    }

    private fun backtrack2(result: ArrayList<String>, currentStr: String, open: Int, close: Int) {
        //左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现 ')(' 这样的非法串，所以这种情况直接返回，不继续处理。
        if (open < 0 || close < 0 || open > close) {
            return
        }
        //如果 left 和 right 都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回
        if (open == 0 && close == 0) {
            result.add(currentStr)
            return
        }
        backtrack2(result, currentStr + "(", open - 1, close)
        backtrack2(result, currentStr + ")", open, close - 1)
    }
}