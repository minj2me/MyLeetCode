/**
 * Lock by leetcode
 * 
 * 170. Two Sum III - Data structure design
 * https://www.lintcode.com/problem/two-sum-iii-data-structure-design/description
 */
/**
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Have you met this question in a real interview?  
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
 */
let lastOne = 0, index = 0;
let map = new Map();
/**
 * @param number: An integer
 * @return: 
 */
const add = function (number) {
    index++;
    map.set((lastOne + number), index);
    lastOne = number;
}

/**
 * @param value: An integer
 * @return: Find if there exists any pair of numbers which sum is equal to the value.
 */
const find = function (value) {
    return map.has(value);
}