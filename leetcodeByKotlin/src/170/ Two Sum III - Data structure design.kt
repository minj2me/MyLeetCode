package LeetCode_170

import java.util.*

/**
 * 170. Two Sum III - Data structure design
 * (Prime)
 * Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 * */
class Solution {
    //key: number, value: the number of appearance of this number
    var map: HashMap<Int, Int> = HashMap()

    fun add(number: Int) {
        map.put(number, map.getOrDefault(number, 0) + 1)
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    fun find(value: Int): Boolean {
        for (key in map.keys) {
            val toFind = value - key
            //toFind + key = value, and toFind,key both exists in map
            if (toFind == key && map.get(key) ?: 0 > 1) {
                return true
            } else if (toFind != key && map.containsKey(toFind)) {
                return true
            }
        }
        return false
    }
}