package LeetCode_76

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * */
class Solution {
    /*
    * solution 1: brute force
    * solution 2: two pointer + array
    * solution 3: Sliding window, two pointer, HashMap
    * */
    fun minWindow(s: String, t: String): String {
        /////solution 3:
        //calculate frequency for t, key: char, value: frequency for char
        val map = HashMap<Char, Int>()
        for (c in t) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }
        var counter = map.size
        var left = 0
        var right = 0
        var len = Int.MAX_VALUE
        var startIndex = 0
        while (right < s.length) {
            val c = s[right]
            //keep tracking string by current window size, for example: s=ADOBECODEBANC
            //when meet a latter in s, decrease counter
            if (map.contains(c)) {
                map.put(c, map.get(c)!! - 1)
                if (map.get(c)!! == 0) {
                    counter--
                }
            }
            right++
            //if counter==0, find out one substring contains all letter in t, and record this substring's len
            //then increase counter to make the window valid again by moving left pointer to find out next substring
            while (counter == 0) {
                val c = s[left]
                if (map.contains(c)) {
                    map.put(c, map.get(c)!! + 1)
                    if (map.get(c)!! > 0) {
                        counter++
                    }
                }
                /*
                * compare the most small size, and save current index when found out the shorter substring to help s.substring
                * */
                if (right - left < len) {
                    len = right - left
                    //update startIndex
                    startIndex = left
                }
                left++
            }
        }
        if (len == Int.MAX_VALUE) {
            return ""
        } else {
            //println("return:${s.substring(startIndex, startIndex + len)}")
            return s.substring(startIndex, startIndex + len)
        }

        /////solution 1: brute force/////////
        /*
        * 1.get all substring of S
        * 2.for each substrings, check whether the substring contains all characters of T
        * 3.find out the smallest substring and contains T
        *
        * solution 2: two pointer, sliding window
        * */

        //solution 1:
        /*val len1 = s.length
        val len2 = t.length
        if (len1 < len2) {
            return ""
        }
        if (s == t) {
            return s
        }
        val charSize = 256
        val hashS = IntArray(charSize)
        val hashT = IntArray(charSize)
        for (c in t) {
            hashT[c.toInt()]++
        }
        var start = 0
        var startIndex = -1
        var minLen = Int.MAX_VALUE
        var count = 0
        var j = 0
        for (c in s) {
            //count occurrence of characters of S
            hashS[c.toInt()]++
            //if S's character match T's character then increment count
            if (hashT[c.toInt()] != 0 && hashS[c.toInt()] <= hashT[c.toInt()]) {
                count++
            }
            //if all the characters are match
            if (count == len2) {
                // Try to minimize the window i.e.,
                // check if any character is occurring more no. of times than its occurrence in pattern,
                // if yes then remove it from starting and also remove the useless characters.
                while (hashS[s[start].toInt()] > hashT[s[start].toInt()] || hashT[s[start].toInt()] == 0) {
                    if (hashS[s[start].toInt()] > hashT[s[start].toInt()]) {
                        hashS[s[start].toInt()]--
                    }
                    start++
                }
                val windowLen = j - start + 1
                if (minLen > windowLen) {
                    minLen = windowLen
                    startIndex = start
                }
            }
            j++
        }
        if (startIndex == -1) {
            print("no such window exits")
            return ""
        }
        val result = s.substring(startIndex, startIndex + minLen)
        print(result)*/

        //////solution 2:///////
        /*val map = IntArray(256)
        var left = 0
        var right = 0
        var count = t.length
        var minLen = Int.MAX_VALUE
        for (c in t) {
            //can handle lower case and upper case
            map[c.toInt()]++
        }
        var result = ""
        /*
        * 了解了第一道题目以后，这道题目也很容易思考出来。解题时，按照步骤：
        * (sliding template code ?)
           1.扩展窗口，窗口中包含一个T中子元素，count–；
           2.通过count或其他限定值，得到一个可能解。
           3.只要窗口中有可能解，那么缩小窗口直到不包含可能解。
        首先，维护一个map，一个窗口。先看右边界，当窗口扩展包含全部ABC时停下，这个时候必然有count == 0。
        但是，这个时候的结果字符串可能很长，所以我们要接着缩小左边界。
        同时，当count == 0时，我们要一直缩小左边界以找到更短的字符串。
        慢慢count>0了，表明窗口中不包含全部的T了，那么又要扩展窗口。依次类推，最终找到最短字符串。
        * */
        while (right < s.length || count == 0) {
            if (count == 0) {//find out one match string
                if (minLen > right - left + 1) {
                    minLen = right - left + 1
                    result = s.substring(left, right)
                }
                //left pointer to keep tracking s[i] if in map,if found it, count++
                if (map[s[left++].toInt()]++ >= 0) {
                    count++
                }
            } else {
                //S = "ADOBECODEBANC", T = "ABC"
                //find out the character in S match in map
                if (map[s[right++].toInt()]-- >= 1) {
                    count--
                }
            }
        }
        //println(result)
        return result*/
    }
}