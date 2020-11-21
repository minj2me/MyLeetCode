/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/description/
 * 最近最少使用页面置换缓存器
 * https://www.cnblogs.com/grandyang/p/4587511.html
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 );//capacity

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

Hashmap + double linked list
 */
let map = new Map();
let capacity;
//let currentSize;
let head = null, tail = null;

var Node = function (key, value) {
    //let key, value;
    let next = null, prve = null;
    this.key = key;
    this.value = value;
};

var remove = function (node) {
    //because is double linkedlist, so need handle prev and next
    //is a head
    if (node.prve == null)
        head = node.next;
    else
        node.prve.next = node.next;//point to the next of the node want to delete

    //is a tail
    if (node.next == null)
        tail = node.prve;//set tail to the prve of the node want to delete
    else
        node.next.prve = node.prve;

};

var setHead = function (node) {
    node.next = head;
    node.prve = null;
    if (head != null)
        head.prve = node;
    head = node;
    if (tail == null)
        tail = head;
};

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity_) {
    capacity = capacity_;
};

/** 
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
    //我们在m中查找给定的key，若不存在直接返回-1,如果存在则将此项移到顶部
    if (map.has(key)) {
        let n = map.get(key);
        remove(n);
        setHead(n);
        return n.value;
    }
    return -1;
};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
    //如果原缓存器中有该key，则需要先删除掉原有的，将新的插入到缓存器的顶部
    if (map.has(key)) {
        let old = map.get(key);
        old.value = value;
        remove(old);
        setHead(old);
    } else {
        //如果不存在，则直接插入到顶部
        //若加入新的值后缓存器超过了容量，则需要删掉一个最不常用的值，也就是底部的值
        let created = new Node(key, value);
        if (map.size >= capacity) {
            map.delete(tail.key);
            remove(tail);
            setHead(created);
        } else {
            setHead(created);
        }

        map.set(key, created);
    }
};

/** 
 * Your LRUCache object will be instantiated and called as such:
 * var obj = Object.create(LRUCache).createNew(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */