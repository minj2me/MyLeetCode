package LeetCode_93

/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
 * */
class Solution {
    /*
    * solution 1: dfs, Time complexity:O(n!), Space complexity:O(n!)
    * */
    val result = ArrayList<String>()

    fun restoreIpAddresses(s: String): List<String> {
        if (s == null || s.isEmpty() || s.length > 12 || s.length < 4) {
            return result
        }
        dfs(s, "", 0)
        return result
    }

    private fun dfs(s: String, cur: String, index: Int) {
        //s:keep shortening
        //cur: keep growing
        if (index == 4 && s.isEmpty()) {
            val ip = cur.substring(0, cur.lastIndex)
            result.add(ip)
            return
        }
        //we can choose 3 situation:
        //choose 1 digit, we don't check first character if zero, because 0.0.0.0 is valid ip
        if (s.length > 0) {
            dfs(s.substring(1), cur + s.substring(0, 1) + ".", index + 1)
        }
        //choose 2 digit
        if (s.length > 1 && s[0] != '0') {
            dfs(s.substring(2), cur + s.substring(0, 2) + ".", index + 1)
        }
        //choose 3 digit
        if (s.length > 2 && s[0] != '0' && Integer.parseInt(s.substring(0, 3)) <= 255) {
            dfs(s.substring(3), cur + s.substring(0, 3) + ".", index + 1)
        }
    }
}