package LeetCode_917
import java.util.*
/**
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.

Example 1:
Input: "ab-cd"
Output: "dc-ba"

Example 2:
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

Note:
1. S.length <= 100
2. 33 <= S[i].ASCIIcode <= 122
3. S doesn't contain \ or "
 * */
class Solution {
    /*
    * solution:Stack, replace latter one by one
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun reverseOnlyLetters(S: String): String {
        val stack = Stack<Char>()
        for (i in S.indices) {
            if (S[i].isLetter()) {
                stack.add(S[i])
            }
        }
        val charArray = S.toCharArray()
        for (i in charArray.indices){
            if (charArray[i].isLetter()){
                charArray[i] = stack.pop()
            }
        }
        return String(charArray)
    }
}