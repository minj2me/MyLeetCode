package LeetCode_49

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 * Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]
 * */
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, ArrayList<String>>()
        for (str in strs) {
            val chars = CharArray(26)
            for (d in str) {
                chars[d.toInt() - 'a'.toInt()]++
            }
            val ns = String(chars)
            if (map.contains(ns)) {
                map.get(ns)?.add(str)
            } else {
                val arrayList = ArrayList<String>()
                arrayList.add(str)
                map.put(ns, arrayList)
            }
        }
        //println(map.size)
        val result = ArrayList<ArrayList<String>>()
        result.addAll(map.values)
        return result
    }
}