package LeetCode_168

/**
 * 168. Excel Sheet Column Title
 *https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
...

Example 1:
Input: 1
Output: "A"

Example 2:
Input: 28
Output: "AB"

Example 3:
Input: 701
Output: "ZY"
 * */
class Solution {
    /*
    * Ex. Input : 731

   n = 731;

1)  --n = 730;
    n % 26 = 730 % 26 = 2
	sb.append( (char)(2 + 'A') = 'C');

	n = n / 26 ( 730 / 26 = 28 )
	// sb = C

2) --n = 27
   n % 26 = 27 % 26 = 1
   sb.append( (char)(1 + 'A') = 'B');

   n = n /26 ( 27 / 26 = 1 )
   // sb = 'CB'

2) --n = 0
   n % 26 = 0 % 26 = 0
   sb.append( (char)(0 + 'A') = 'A');

   n = n /26 ( 0 / 26 = 0 )
   // sb = 'CBA'

   sb.reverse() = 'ABC'

    * */
    fun convertToTitle(n: Int): String {
        val sb = StringBuilder()
        var n_ = n
        while (n_ > 0) {
            n_--
            sb.append(((n_ % 26) + 'A'.toInt()).toChar())
            n_ /= 26
        }
        return sb.reverse().toString()
    }
}