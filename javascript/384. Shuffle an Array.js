/**
 * 384. Shuffle an Array
 * https://leetcode.com/problems/shuffle-an-array/description/
 * http://www.cnblogs.com/grandyang/p/5783392.html
 * https://yjk94.wordpress.com/2017/03/17/%E6%B4%97%E7%89%8C%E7%9A%84%E6%AD%A3%E7%A1%AE%E5%A7%BF%E5%8A%BF-knuth-shuffle%E7%AE%97%E6%B3%95/
 * 
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */

let array = [],array2=[];
/**
 * @param {number[]} nums
 */
var Solution = function (nums) {
    array = nums;
    array2 = array.concat();
};

/**
 * Resets the array to its original configuration and return it.
 * @return {number[]}
 */
Solution.prototype.reset = function () {
    return array2;
};

/**
 * Returns a random shuffling of the array.
 * @return {number[]}
 */
Solution.prototype.shuffle = function () {
    let v = array;
    for (let i = 0; i < v.length; i++) {
        let j = Math.floor(i + Math.random() * Math.pow(2, 31) % (v.length - i));
        let temp = v[j];
        v[j] = v[i];
        v[i] = temp;
    }
    return v;
};

/** 
 * Your Solution object will be instantiated and called as such:
 * var obj = Object.create(Solution).createNew(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */