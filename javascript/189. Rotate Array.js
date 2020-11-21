/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 */
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    //reverse() 颠倒数组中元素的顺序。
     //pop() 方法用于删除并返回数组的最后一个元素。
     //shift() 删除并返回数组的第一个元素。
     //unshift() 向数组的开头添加一个或更多元素，并返回新的长度。
     //concat() 连接两个或更多的数组，并返回结果。
   let size = nums.length;
     if (size < 1)
       return;
     let step = k % size;
     for (let i = 0; i < step; i++) {
       let temp = nums.pop();
       nums.unshift(temp);
     }
     //console.log(nums);
    
 };