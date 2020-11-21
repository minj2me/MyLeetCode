package LeetCode_1647

import java.util.*
import kotlin.collections.HashMap

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * A string s is called good if there are no two different characters in s that have the same frequency.
Given a string s, return the minimum number of characters you need to delete to make s good.
The frequency of a character in a string is the number of times it appears in the string.
For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

Example 1:
Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:
Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:
Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).

Constraints:
1. 1 <= s.length <= 105
2. s contains only lowercase English letters.
 * */
class Solution {
    /*
    * solution: HashMap + HashSet, map to calculate appearance count, set to help reduce duplicate appearance count
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun minDeletions(s: String): Int {
        val map = HashMap<Char, Int>()
        for (c in s) {
            map.put(c, map.getOrDefault(c, 0) + 1)
        }
        var result = 0
        val set = HashSet<Int>()
        for (item in map) {
            var value = item.value
            while (set.contains(value)) {//contains in HashSet is O(1)
                value--
                result++
            }
            if (value > 0) {
                set.add(value)
            }
        }
        return result

        /*val queue = PriorityQueue<Int> { a, b -> b - a }
        for (item in map) {
            queue.offer(item.value)
        }
        while (queue.size >= 2) {
            var cur = queue.poll()
            if (queue.contains(cur)) {//contains in PriorityQueue is O(n)
                result++
                cur--
                if (cur > 0) {
                    queue.offer(cur)
                }
            }
        }
        return result*/
    }
}