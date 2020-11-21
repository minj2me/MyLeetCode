package LeetCode_139

/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 *
 * Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 * */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val map = HashMap<String, Boolean>()
        val set = HashSet<String>()
        /*val set = HashSet<Char>()
        //check every latter of s if exist in set first
        for (word in wordDict) {
            for (c in word) {
                set.add(c)
            }
        }
        for (c in s) {
            if (!set.contains(c)) {
                return false
            }
        }*/

        for (word in wordDict) {
            set.add(word)
        }
        val result = dfs(s, set, map)
        println(result)
        return result
        //return helper(s, wordDict, "", map)
    }

    /**
     * soulution: backtracking+memorized, Time complexity:O(2^n), Space complexity:O(n)
     * */
    private fun dfs(s: String, set: HashSet<String>, map: HashMap<String, Boolean>): Boolean {
        if (map.contains(s)) {
            return map.get(s)!!
        }
        if (set.contains(s)) {
            map.put(s, true)
            return true
        }
        //check left side and right side by each levels
        for (i in 1 until s.length) {
            val left = s.substring(0, i)
            val right = s.substring(i)
            if (set.contains(right) && dfs(left, set, map)) {
                map.put(s, true)
                return true
            }
        }
        map.put(s, false)
        return false
    }

    private fun helper(s: String, wordDict: List<String>, temp: String, map: HashMap<String, Boolean>): Boolean {
        if (map.containsKey(temp)) {
            return map.get(temp)!!
        }
        if (s.length < temp.length) {
            return false
        }
        for (i in temp.indices) {
            if (s[i] != temp[i]) {
                return false
            }
        }
        if (s.length == temp.length) {
            return true
        }
        for (word in wordDict) {
            if (helper(s, wordDict, temp + word, map)) {
                map.put(temp, true)
                return true
            }
        }
        map.put(temp, false)
        return false
    }
}