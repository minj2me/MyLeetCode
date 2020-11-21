/**
 * 670. Maximum Swap
 * https://leetcode.com/problems/maximum-swap/description/
 * https://www.cnblogs.com/grandyang/p/7583875.html
 * 
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
 * Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: 9973
Output: 9973
Explanation: No swap.

Note:
The given number is in the range [0, 108]
 */

/**
* @param {number} num
* @return {number}
*/
var maximumSwap = function (nums) {
    let res = nums;
    let numArr = nums.toString().split("");
    let len = numArr.length;
    for (let i = 0; i < len; i++) {
        for (let j = i + 1; j < len; j++) {
            swap(numArr, i, j);
            res = Math.max(res, parseInt(numArr.join("")));
            //swap back
            swap(numArr, i, j);
        }
    }
    return res;
};
var swap = function (numArray, index1, index2) {
    let val1 = numArray[index1];
    let val2 = numArray[index2];
    numArray.splice(index1, 1, val2);
    numArray.splice(index2, 1, val1);
}