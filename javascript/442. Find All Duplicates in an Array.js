/**
 * 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function (nums) {
    /*let set = new Set();
    let len = nums.length;
    let res = [];
    for (let i = 0; i < len; i++) {
        let n = nums[i];
        if (set.has(n)) {
            res.push(n);
        }
        set.add(n);
    }
    return res;*/

    //need without extra memory
    nums.sort(function (a, b) { return a - b });
    //console.log(nums);
    let last = 0, res = [];
    for (let n of nums) {
        if (n == last)
            res.push(n);
        last = n;
    }
    return res;
};