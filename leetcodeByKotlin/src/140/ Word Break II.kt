package LeetCode_140

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
"cats and dog",
"cat sand dog"
]
 * */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        //val map = HashMap<String, String>()
        val map2 = HashMap<String, ArrayList<String>>()
        val set = HashSet<String>()
        //val result = ArrayList<String>()
        for (word in wordDict) {
            set.add(word)
        }
        return dfs2(s,set,map2)
    }

    /**
     * solution 1: recursion
     * TLE
     * */
    private fun dfs(index: Int, s: String, path: String, set: HashSet<String>, map: HashMap<String, String>, result: ArrayList<String>) {
        if (index == s.length) {
            //println("add:$path")
            result.add(path)
            return
        }
        for (i in index until s.length) {
            val word = s.substring(index, i + 1)
            if (!set.contains(word)) {
                continue
            }
            dfs(i + 1, s, path + word + " ", set, map, result)
        }
    }

    /**
     * solution 2: recursion + memorization (dp: Top-Down), Time complexity:O(2^n), Space complexity:O(n)
     * */
    private fun dfs2(s: String, set: HashSet<String>, map: HashMap<String, ArrayList<String>>):ArrayList<String>{
        if (map.contains(s)){
            return map.get(s)!!
        }
        val res = ArrayList<String>()
        if (set.contains(s)){
            res.add(s)
        }
        for (i in 1 until s.length) {
            //just like left word
            val word = s.substring(0,i)
            if (set.contains(word)){
                //s.substring(i) just like right word
                val list = dfs2(s.substring(i),set,map)
                for (str in list){
                    res.add(word+" "+str)
                }
            }
        }
        map.put(s,res)
        return res
    }
}