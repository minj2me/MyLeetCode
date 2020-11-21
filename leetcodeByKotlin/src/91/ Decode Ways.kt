package LeetCode_91

/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2

Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * */
class Solution {
    val map = HashMap<String,Int>()

    fun numDecodings(s: String): Int {
        //1.Recursion with memoization, Time complexity and Space complexity both N square
        //check first and first two
        if (s.length==0){
            return 0
        }
        return getWay(s)
    }

    private fun getWay(s:String):Int{
        if (s.equals("")){
            return 1
        }
        if (map.containsKey(s)){
            return map.get(s)!!
        }
        if (s[0].equals('0')){
            return 0
        }
        if (s.length==1){
            return 1
        }
        //check the string behind the first
        var way = getWay(s.substring(1))
        val firstTwo = s.substring(0,2).toInt() - "0".toInt()
        if (firstTwo<=26){
            //if the first two is valid, then check the string behind it
            way+=getWay(s.substring(2))
        }
        map.set(s,way)
        return way
    }
}