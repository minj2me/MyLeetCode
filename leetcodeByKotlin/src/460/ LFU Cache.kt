package LeetCode_460

import java.util.*
import kotlin.collections.HashMap

/**
 * 460. LFU Cache
 * https://leetcode.com/problems/lfu-cache/description/
 *
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
==get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
==put(key, value) - Set or insert the value if the key is not already present.
When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),the least recently used key would be evicted.
Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted.
This number is set to zero when the item is removed.

 * Follow up:
Could you do both operations in O(1) time complexity?
 * */

/*
  solution 1: HashMap+TreeSet, Time complexity:O(logc), Space complexity:O(c), c is capacity;
* solution 2: HashMap+Double LinkedList, Time complexity:O(1);
* O(1): HashMap insert and get;
* O(1): Double LinkedList: remove the tail, insert into head, move element to head;
* the key of least frequency will store in the tail
* */

class Node(key: Int, value: Int, frequency: Int) {
    var key = 0
    var value = 0
    var frequency = 0
    var next: Node? = null
    var prev: Node? = null

    init {
        this.key = key
        this.value = value
        this.frequency = frequency
    }
}

class CacheNode(key: Int, value: Int, frequency: Int, time: Int) : Comparable<CacheNode> {
    var key = 0
    var value = 0
    var frequency = 0
    var time = 0

    init {
        this.key = key
        this.value = value
        this.frequency = frequency
        this.time = time
    }

    override fun compareTo(other: CacheNode): Int {
        return if (this.frequency != other.frequency) this.frequency - other.frequency else this.time - other.time
    }
}

class LFUCache(capacity: Int) {
    /*var head: Node? = null
    var tail: Node? = null*/
    //val values = HashMap<Int, Int>(capacity)
    val cacheMap = HashMap<Int, CacheNode>(capacity)
    val freqTree = TreeSet<CacheNode>()
    var capacity = 0
    var clock = 0

    init {
        this.capacity = capacity
    }

    fun get(key: Int): Int {
        if (!cacheMap.containsKey(key)) {
            return -1
        }
        val node = cacheMap.get(key)!!
        val value = node.value
        updateFreq(node)
        return value
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        if (cacheMap.containsKey(key)) {
            //key exists: update value and updateFreq
            val node = cacheMap.get(key)!!
            node.value = value
            updateFreq(node)
            return
        }
        //if inserting item when cache is capacity,
        if (cacheMap.size == capacity) {
            //remove the first node in the tree,because it's least frequency or haven't been visited recently
            val first = freqTree.first()
            cacheMap.remove(first.key)
            freqTree.remove(first)
        }
        //create new node
        //clock++,represent in use this moment
        val node = CacheNode(key, value, 1, clock++)
        cacheMap.put(key, node)
        freqTree.add(node)
    }

    private fun updateFreq(node: CacheNode) {
        freqTree.remove(node)
        node.time = clock++
        node.frequency++
        freqTree.add(node)
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * var obj = LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */