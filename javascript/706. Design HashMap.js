/**
 * 706. Design HashMap
 * https://leetcode.com/problems/design-hashmap/description/
 * 
 * Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */

const CAPACITY = 1000;
// const CAPACITY2 = 1000000;
let array = new Array(CAPACITY);
/**
 * Initialize your data structure here.
 */
var MyHashMap = function () {
    for (let i = 0; i < array.length; i++) {
        array[i] = new Array();
    }
};

function arrayResize(arr, newSize, defaultVal) {
    while (newSize > arr.length) {
        arr.push(defaultVal);
    }
    arr.length = newSize;
};

/**
 * value will always be non-negative. 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
    let hashKey = key % CAPACITY;
    if (array[hashKey] == null) {
        //if not create in init, resize it
        arrayResize(array[hashKey], 1000, -1);
    }
    array[hashKey][parseInt(key / 1000)] = value;

    // array[key] = value;
};

/**
 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
    let hashKey = key % CAPACITY;
    if (array[hashKey] != null) {
        let value = array[hashKey][parseInt(key / 1000)];
        return value == undefined ? -1 : value;
    }
    return -1;

    // return array[key];
};

/**
 * Removes the mapping of the specified value key if this map contains a mapping for the key 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
    let hashKey = key % CAPACITY;
    if (array[hashKey] != null)
        array[hashKey][parseInt(key / 1000)] = -1;

    // array[key] = -1;
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = Object.create(MyHashMap).createNew()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */