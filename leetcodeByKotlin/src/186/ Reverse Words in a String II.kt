package LeetCode_186

/**
 * 186. Reverse Words in a String II
 * (Prime)
 * Given an input string , reverse the string word by word.
Example:
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note:
1. A word is defined as a sequence of non-space characters.
2. The input string does not contain leading or trailing spaces.
3. The words are always separated by a single space.
3. Follow up: Could you do it in-place without allocating extra space?
 * */
class Solution {
    /*
    * solution: reverse each words then reverse whole string then reverse,
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun reverseWords(chars: CharArray) {
        val n = chars.size
        var start = 0
        for (i in 0..n) {
            //if go through to the end or meet a space
            if (i == n || chars[i] == ' ') {
                //reverse current word
                reverse(chars, start, i - 1)
                //update start
                start = i + 1
            }
        }
        //after above, now is: e,h,t, ,y,k,s, ,s,i, ,e,u,l,b,
        //then reverse whole string
        reverse(chars, 0, n - 1)
    }

    private fun reverse(chars: CharArray, i_: Int, j_: Int) {
        var i = i_
        var j = j_
        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
    }
}