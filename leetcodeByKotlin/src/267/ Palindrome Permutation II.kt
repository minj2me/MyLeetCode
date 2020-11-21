package LeetCode_267

import java.lang.StringBuilder

/**
 * 267. Palindrome Permutation II
 * (Peime)
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.

Example 1:
Input: "aabb"
Output: ["abba", "baab"]

Example 2:
Input: "abc"
Output: []
 * */
class Solution {
    /*
    * solution: DFS+backtracking
    * Time complexity:O((n/2)!), Space complexity:O(n): the depth of recursion is at most n/2
    * */
    fun generatePalindromes(s: String): List<String> {
        val result = ArrayList<String>()
        val charList = ArrayList<Char>()
        //count number of c and odd
        var oddCount = 0
        var mid=""
        val map = HashMap<Char, Int>()
        for (c in s) {
            map.put(c, map.getOrDefault(c, 0) + 1)
            oddCount += if (map.get(c)!! % 2 != 0) 1 else -1
        }
        //cannot form any palindrome string
        if (oddCount > 1) {
            return result
        }
        for ((key, value) in map) {
            //if is odd, add string in mid
            if (value % 2 != 0) {
                mid += key
            }
            //get half of string to gen palindrome permutation
            for (i in 0 until value / 2) {
                charList.add(key)
            }
        }
        dfs(charList, mid, BooleanArray(charList.size), StringBuilder(), result)
        //println(result)
        return result
    }

    private fun dfs(chatList:ArrayList<Char>, mid:String, visited:BooleanArray, cur:StringBuilder, result: ArrayList<String>) {
        if (cur.length == chatList.size) {
           //create the palindrome string
           result.add(cur.toString() + mid + cur.reverse().toString())
           //set it back
           cur.reverse()
           return
       }
        for (i in 0 until chatList.size) {
            if (!visited[i]) {
                visited[i] = true
                cur.append(chatList.get(i))
                dfs(chatList, mid, visited, cur, result)
                //backtracking
                cur.deleteCharAt(cur.lastIndex)
                visited[i] = false
            }
        }
    }
}