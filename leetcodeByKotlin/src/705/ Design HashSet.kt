package `LeetCode_705`

/**
 * 705. Design HashSet
 * https://leetcode.com/problems/design-hashset/description/
 * https://www.cnblogs.com/grandyang/p/9966807.html
 *
 * Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.

Example:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);
hashSet.contains(2);    // returns true
hashSet.remove(2);
hashSet.contains(2);    // returns false (already removed)
 */

class MyHashSet() {

    private val array = BooleanArray(1000005)

    fun add(key: Int) {
        array[key] = true
    }

    fun remove(key: Int) {
        array[key] = false
    }

    fun contains(key: Int): Boolean {
        return array[key]
    }

}