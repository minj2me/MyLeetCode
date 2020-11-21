/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function (k, n) {
    let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9];
    let result = [];
    help(k, n, 0, [], result, arr);
    //console.log(result);
    return result;
};

var help = function (k, target, start, out, result, arr) {
    if (target == 0 && out.length == k) {
        result.push(out);
    } else if (target < 0) {
        return;
    } else {
        for (let i = start; i < arr.length; i++) {
            out.push(arr[i]);
            help(k, target - arr[i], i + 1, out.concat(), result, arr);
            out.pop();
        }
    }
};