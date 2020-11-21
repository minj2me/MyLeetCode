package LeetCode_1249

/**
 * 1249. Minimum Remove to Make Valid Parentheses
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
 *
 * Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
Formally, a parentheses string is valid if and only if:
1. It is the empty string, contains only lowercase characters, or
2. It can be written as AB (A concatenated with B), where A and B are valid strings, or
3. It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Example 4:
Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

Constraints:
1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 * */
class Solution {
    /*
    * solution 1: BFS, TLE, Time complexity:O(2^n), Space complexity:O(2^n);
    *
    * solution 2: two list, keep tracking the index of open and close parentheses
    * Time complexity:O(n), Space complexity:O(n);
    * */
    fun minRemoveToMakeValid(s: String): String {
        //solution 1:
        /*
        val visited = HashSet<String>()
        val queue = LinkedList<String>()
        queue.offer(s)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            if (visited.contains(cur)) {
                continue
            }
            visited.add(cur)
            if (isValidParenthese(cur)) {
                //println(cur)
                return cur
            }
            //expand the string
            for (i in cur.indices) {
                /*
                * for example: lee(t(c)o)de) to expand like this:
                * => ee(t(c)o)de)
                * => le(t(c)o)de)
                * */
                val children = cur.substring(0, i) + cur.substring(i+1, cur.length)
                println(children)
                queue.offer(children)
            }
        }
        return ""
        */

        //solution 2:
        val open = ArrayList<Int>()
        val close = ArrayList<Int>()
        for (i in s.indices) {
            val c = s[i]
            if (c == '(') {
                open.add(i)
            } else if (c == ')') {
                if (open.isNotEmpty()) {
                    //for keep both balance
                    open.removeAt(open.lastIndex)
                } else {
                    close.add(i)
                }
            }
        }
        val charArray = s.toCharArray()
        //replace the invalid parentheses
        for (i in open) {
            charArray[i] = '#'
        }
        for (i in close) {
            charArray[i] = '#'
        }
        val result = StringBuilder()
        for (ch in charArray) {
            if (ch != '#') {
                result.append(ch)
            }
        }
        return result.toString()
    }

    private fun isValidParenthese(s: String): Boolean {
        var count = 0
        for (c in s) {
            //just check ( or ) if balance
            if (c == '(') {
                count++
            } else if (c == ')') {
                count--
            }
            if (count < 0) {
                return false
            }
        }
        return count == 0
    }
}
