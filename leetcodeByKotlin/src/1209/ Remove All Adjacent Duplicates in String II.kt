package LeetCode_1209

import java.util.*

/**
 * 1209. Remove All Adjacent Duplicates in String II
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
 *
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made.
It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"

Constraints:
1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
 * */

data class Node(var char: Char, var count: Int = 1)

class Solution {
    /*
    * solution:Queue, Time complexity:O(n), Space complexity:O(n)
    * */
    fun removeDuplicates(s: String, k: Int): String {
        val result = StringBuilder()
        var removed = false
        val queue = LinkedList<Node>()
        for (c in s) {
            //keep tracking the element at the tail
            if (queue.isEmpty() || queue.last.char != c) {
                queue.addLast(Node(c))
            } else {
                queue.last.count++
                if (queue.last.count == k) {
                    queue.removeLast()
                    removed = true
                }
            }
        }
        if (!removed) {
            return s
        }
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            while (cur.count-- > 0) {
                result.append(cur.char)
            }
        }
        return result.toString()
    }
}