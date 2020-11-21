package LeetCode_408

/**
 * 408. Valid Word Abbreviation
 * (Prime)
 * Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word".
Any other string is not a valid abbreviation of "word".
Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":
Return true.

Example 2:
Given s = "apple", abbr = "a2e":
Return false.
 * */
class Solution {
    /*
    * solution: Sliding-Window, Time complexity:O(n), Space complexity:O(1)
    * */
    fun isValidAbberviation(s: String?, abbr: String?): Boolean {
        if (s == null || abbr == null) {
            return false
        }
        if (s.length == abbr.length && s != abbr) {
            return false
        }
        //calculate the total length than compare both
        val charArray = abbr.toCharArray()
        val length = charArray.size
        var count = 0
        var right = 0
        var i = 0
        while (i < length) {
            if (charArray[i].isDigit()) {
                right = i
                while (charArray[right].isDigit()) {
                    //keep tracking all the number in current check
                    right++
                    if (right >= length) {
                        break
                    }
                }
                val countString = abbr.substring(i, right)
                count += countString.toInt()
                //update the index
                i = right - 1
            } else {
                count++
            }
            i++
        }
        return count == s.length
    }
}