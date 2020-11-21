package LeetCode_706

/**
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/description/
 *
 * Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:
    ==put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
    ==get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
    ==remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)

Note:
All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.
 * */
class MyHashMap() {
    /** Initialize your data structure here. */
    val size = 1000
    var keys: Array<ArrayList<Pair<Int, Int>>>? = null

    init {
        keys = Array(size, { ArrayList<Pair<Int, Int>>() })
    }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        var list = keys!![getHash(key)]
        if (list == null) {
            list = ArrayList()
            keys!![getHash(key)] = list
        }
        //if key exist, replace value
        for (item in list) {
            if (item.first == key) {
                list.remove(item)
                val itemClone = item.copy(first = key, second = value)
                list.add(itemClone)
                return
            }
        }
        list.add(Pair(key, value))
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        val list = keys!![getHash(key)]
        if (list == null) {
            return -1
        }
        for (item in list) {
            if (item.first == key) {
                return item.second
            }
        }
        return -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        val list = keys!![getHash(key)]
        if (list != null) {
            for (item in list) {
                if (item.first == key) {
                    list.remove(item)
                    return
                }
            }
        }
    }

    private fun getHash(key: Int): Int {
        return key % size
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */