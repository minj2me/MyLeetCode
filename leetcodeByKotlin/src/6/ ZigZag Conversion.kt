package LeetCode_6

/**
 * 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1. 1 <= s.length <= 1000
2. s consists of English letters (lower-case and upper-case), ',' and '.'.
3. 1 <= numRows <= 1000
 * */
class Solution {
    /*
    * solution: Array + StringBuilder,
    * Time complexity:O(n)(each letter access one time), Space complexity:O(n), n is length of s,
    * */
    fun convert(s: String, numRows: Int): String {
        val stringBuilders = Array(numRows) { StringBuilder() }
        val len = s.length
        var index = 0
        while (index < len) {
            var row = 0
            while (row < numRows && index < len) {
                /*
                * for example: PAYPALISHIRING
                * stringBuilders[0].append(P)
                  stringBuilders[1].append(A)
                  stringBuilders[2].append(Y)
                  stringBuilders[0].append(P)
                  stringBuilders[1].append(A)
                  stringBuilders[2].append(L)
                  ....
                * */
                stringBuilders[row].append(s[index++])
                row++
            }
            //diagonally upward starting from stringBuilders[numRows-2] and stop at stringBuilders[1]
            var j = numRows - 2
            while (j >= 1 && index < len) {
                stringBuilders[j].append(s[index++])
                j--
            }
        }
        //merge all into StringBuilder 1
        for (i in 1 until stringBuilders.size){
            stringBuilders[0].append(stringBuilders[i])
        }
        return stringBuilders[0].toString()
    }
}