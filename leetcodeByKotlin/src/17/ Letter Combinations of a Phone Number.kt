package LeetCode_17

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 * */
class Solution {
    /*
    * solution: backtracking + dfs;
    * Time complexity:O(4^n), because each button has 4 letter;
    * Space complexity:O(4^n), because result.add each calculate
    * */
    fun letterCombinations(digits: String): List<String> {
        //create a mapping for each button
        val map = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val result = ArrayList<String>()
        val cur = StringBuilder()
        dfs(0, digits, cur, map, result)
        return result
    }

    private fun dfs(index: Int, digits: String, cur: StringBuilder, map: Array<String>, result: ArrayList<String>) {
        if (index == digits.length) {
            result.add(cur.toString())
            return
        }
        //set the index for get string from map
        val i = digits[index] - '0'
        //found out string for split
        val string = map.get(i)
        for (c in string) {
            cur.append(c.toString())
            dfs(index + 1, digits, cur, map, result)
            //clean last for next level
            cur.deleteCharAt(cur.lastIndex)
        }
    }
}