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
const CAPACITY = 1000;
let array = new Array(CAPACITY);
/**
 * Initialize your data structure here.
 */
var MyHashSet = function () {
    for (let i = 0; i < array.length; i++) {
        array[i] = new Array();
    }
};

arrayResize = function (arr, newSize, defaultValue) {
    while (newSize > arr.length) {
        arr.push(defaultValue);
    }
    arr.length = newSize;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function (key) {
    let hashKey = key % CAPACITY;
    if (array[hashKey] == null) {
        arrayResize(array, CAPACITY, 0);
    }
    array[hashKey][parseInt(key / 1000)] = 1;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
    let hashKey = key % CAPACITY;
    if (array[hashKey] != null || array[hashKey] != undefined)
        array[hashKey][parseInt(key / 1000)] = 0;
};

/**
 * Returns true if this set contains the specified element 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
    let hashKey = key % CAPACITY;
    let key_ = parseInt(key / 1000);
    return (array[hashKey][key_] == undefined || array[hashKey][key_] == 0) ? false : true;
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = Object.create(MyHashSet).createNew()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */