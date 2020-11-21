package LeetCode_146

import kotlin.collections.HashMap

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/description/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?
 *
 * 我们需要设计：
 * 1：使用HashMap：用于存储现有的key,value就是指向双向链表(LinkedList)中的节点
 * 2：双向链表：在移除尾部元素、添加元素到头部、移动元素到头部都可以在O(1)完成
 * */

class Node(key: Int, value: Int) {
    var key = 0
    var value = 0
    var next: Node? = null
    var prev: Node? = null

    init {
        this.key = key
        this.value = value
    }
}

class LRUCache(capacity: Int) {

    var head: Node? = null
    var tail: Node? = null
    var capacity = 0
    val map = HashMap<Int, Node>(capacity)

    init {
        this.capacity = capacity
    }

    fun get(key: Int): Int {
        val n = map.get(key)
        if (n == null) {
            return -1
        }
        removeNode(n)
        //add node to tail
        addNode(n)
        return n.value
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node = map.get(key)
            node?.value = value
            removeNode(node!!)
            addNode(node)
        } else {
            if (map.size >= capacity) {
                if (head != null) {
                    //remove the head
                    map.remove(head?.key)
                    removeNode(head!!)
                }
            }
            val newNode = Node(key, value)
            addNode(newNode)
            map.put(key, newNode)
        }
    }

    private fun removeNode(node: Node) {
        if (node.prev != null) {
            node.prev?.next = node.next
        } else {
            head = node.next
        }
        if (node.next != null) {
            node.next?.prev = node.prev
        } else {
            tail = node.prev
        }
    }

    private fun addNode(node: Node) {
        if (tail != null) {
            tail?.next = node
        }
        node.prev = tail
        node.next = null
        tail = node
        if (head == null) {
            head = tail
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */