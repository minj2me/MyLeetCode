/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * 
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */

var nums = null;
var map = null;

/**
 * Initialize your data structure here.
 */
var RandomizedSet = function () {
    nums = [];
    map = new Map();
};

/**
 * Inserts a value to the set. Returns true if the set did not already contain the specified element. 
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function (val) {
    if (map.has(val))
        return false;
    nums.push(val);
    let lastIndex = nums.length - 1;
    map.set(val, lastIndex);
    return true;
};

/**
 * Removes a value from the set. Returns true if the set contained the specified element. 
 * @param {number} val
 * @return {boolean}
 哈希表的删除是常数时间的，而数组并不是，为了使数组删除也能常数级，
 我们实际上将要删除的数字和数组的最后一个数字调换个位置，然后修改对应的哈希表中的值，
 这样我们只需要删除数组的最后一个元素即可，保证了常数时间内的删除
 */
RandomizedSet.prototype.remove = function (val) {
    if (!map.has(val))
        return false;
    let last = nums[nums.length - 1];
    let index = map.get(val);
    //replace in nums
    nums.splice(index, 1, last);
    nums.splice(nums.length - 1, 1, val);
    nums.pop();//delete val
    map.set(last, index);//update the val in map
    map.delete(val);
    return true;
};

/**
 * Get a random element from the set.
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function () {
    //index is 0-nums.length
    //let index = Math.floor(Math.random()*nums.length);
    let index = Math.floor(Math.random() * nums.length);
    //console.log("index:"+index);
    return nums[index];
};

/** 
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = Object.create(RandomizedSet).createNew()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */