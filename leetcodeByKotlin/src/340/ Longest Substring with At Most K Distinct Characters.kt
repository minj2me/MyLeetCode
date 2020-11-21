package LeetCode_340

/**
 * 340. Longest Substring with At Most K Distinct Characters
 *  (Locked by leetcode)
 *  https://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters/description
 *
 *  Given a string S, find the length of the longest substring T that contains at most k distinct characters.

Example 1:
Input: S = "eceba" and k = 3
Output: 4
Explanation: T = "eceb"

Example 2:
Input: S = "WORLD" and k = 4
Output: 4
Explanation: T = "WORL" or "ORLD"
 * */
class Solution {
    /*
    Sliding Window solution, Time complexity:O(n), Space complexity:O(256)
        e  c  e  b  a
           ^
           i

                 ^
                 j

    * occMap: e:1, c:1, b:1
    * counter: 3 (when counter > K, need to move i)
    * best length: 3
    *
    * when moving i:
    * occMap[s[i]]--
    * if (occMap[s[i]]==0){
    *   counter--
    * }
    *
    * when moving j:
    * if (occMap[s[j]])==0{
    *   counter++
    * }
    * occMap[s[j]]++
    *
    * bestLength = max(bestLength, length of current window)=>max(bestLength, j-i+1)
    *
    * counter: how many distinct character we have
    *
    * valid window condition:
    * window contains <= 2 distinct characters = window desirable;
    * when move i: when the window becomes not desirable (counter>2)
    * when move j: as long as counter<=2 (as long as window desirable)
    *
    * Sliding Window Tech important point:
    * 1.when to move i, and what have to do when moving i;
    * 2.when to move j, and what have to do when moving j;
    * 3.when to update the goal;
    * */
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        val occMap = IntArray(256)
        var i = 0
        var j = 0
        var counter = 0
        var bestLength = 0
        while (j < s.length) {
            if (occMap[s[j].toInt()] == 0) {
                counter++
            }
            occMap[s[j].toInt()]++
            //if the count of current distinct character lager than k,
            //decrease the left pointer and keep tracking the distinct character
            while (counter > k) {
                occMap[s[i].toInt()]--
                if (occMap[s[i].toInt()] == 0) {
                    counter--
                }
                i++
            }
            bestLength = Math.max(bestLength, j - i + 1)
            j++
        }
        //print(bestLength)
        return bestLength
    }
}