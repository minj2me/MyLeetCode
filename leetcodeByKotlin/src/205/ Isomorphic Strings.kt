package LeetCode_205

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/description/
 * */
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val a = IntArray(256)//ASCII size is 256
        val b = IntArray(256)
        for (i in 0 until 256) {
            a[i] = -1
            b[i] = -1
        }
        val length = s.length
        for (i in 0 until length) {
            //println("a[${s[i].toInt()}]:${a[s[i].toInt()]}")
            //println("b[${t[i].toInt()}]:${b[t[i].toInt()]}")
            if (a[s[i].toInt()] != b[t[i].toInt()]) {
                return false
            }
            a[s[i].toInt()] = i
            b[t[i].toInt()] = i
        }
        return true
    }
}