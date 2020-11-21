package LeetCode_438

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 * */
class Solution {
    /*
    * solution 1: Array + Sliding Window, Time complexity:O(n), Space complexity:O(26)
    * solution 2: HashMap + Sliding Window
    * */
    fun findAnagrams(s: String, p: String): List<Int> {
        /*val result = ArrayList<Int>()
        val window = p.length
        val len = s.length
        if (window == 0 || len == 0) {
            return result
        }
        if (len < window) {
            return result
        }
        var left = 0
        var right = 0
        val hash = IntArray(26)
        val pHasp = IntArray(26)
        while (right < window) {
            hash[s[right] - 'a']++
            pHasp[p[right] - 'a']++
            right++
        }
        //scan remaining len of s
        while (right <= len) {
            if (pHasp contentEquals hash) {
                result.add(left)
            }
            /*
            * keep tracking in window size,
            * for example: cbaebabacd,
            * next track: eba=>bab...
            * */
            if (right != len) {
                hash[s[right] - 'a']++
            }
            right++
            hash[s[left++] - 'a']--
        }
        return result*/

        return solution1(s, p)
    }

    private fun solution1(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        if (p.length > s.length) {
            return result
        }
        val sMap = IntArray(26)
        val pMap = IntArray(26)
        val sLength = s.length
        val pLength = p.length
        for (c in p) {
            pMap[c - 'a']++
        }
        for (i in 0 until sLength) {
            if (i >= pLength) {
                //remove the element out of window to keep tracking compare, the length of this window is pLength
                sMap[s[i - pLength] - 'a']--
            }
            sMap[s[i] - 'a']++
            if (sMap contentEquals pMap) {
                result.add(i + 1 - pLength)
            }
        }
        return result
    }

    private fun solution2(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        if (p.length > s.length) {
            return result
        }
        //key: char in p, value: appearance of this char
        val map = HashMap<Char, Int>()
        for (c in p) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }
        var counter = map.size
        var begin = 0
        var end = 0
        //s:cbaebabacd, p:abc
        while (end < s.length) {
            //keep moving end until counter become to 0
            val c = s[end]
            if (map.contains(c)) {
                //reduce appearance count of c
                map.put(c, map.get(c)!! - 1)
                if (map.get(c) == 0) {
                    counter--
                }
            }
            println("map1:$map")
            println("counter1:$counter")
            end++
            //if counter==0, start moving left pointer to maintain window
            while (counter == 0) {
                val c = s[begin]
                println("map2:$map")
                if (map.contains(c)) {
                    map.put(c, map.get(c)!! + 1)
                    if (map.get(c)!! > 0) {
                        counter++
                    }
                }
                println("counter2:$counter")
                if (end - begin == p.length) {
                    result.add(begin)
                }
                begin++
            }
        }
        println(result)
        return result
    }
}