package LeetCode_387

import kotlin.collections.LinkedHashMap

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
 * */
class Solution {
    fun firstUniqChar(s: String): Int {
        // TreeMap 通过comparator自定义排序规则，LinkedHashMap 既可以通过添加顺序排序也可以通
        val map = LinkedHashMap<Char, Int>()
        for (c in s) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)!! + 1)
            } else {
                map.put(c, map.getOrDefault(c, 0))
            }
        }
        var firstChar: Char? = null
        for (item in map) {
            if (item.value == 0) {
                firstChar = item.key
                break
            }
        }
        if (firstChar != null)
            return s.indexOf(firstChar)
        return -1
    }
}