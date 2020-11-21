/**
 * Lock by leetcode
 * 624. Maximum Distance in Arrays
 * https://www.lintcode.com/problem/maximum-distance-in-arrays/description
 * 
Given m arrays, and each array is sorted in ascending order. 
Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. 
We define the difference between two integers a and b to be their absolute difference |a-b|. 
Your task is to find the maximum difference.

Example1

Input: [[1,2,3], [4,5], [1,2,3]]
Output: 4
Explanation:
One way to reach the maximum difference 4 is to pick 1 in the first or third array and pick 5 in the second array.

Example2

Input: [[1,2,3,4,5,6,7,8,9],[0,10]]
Output: 9
Notice
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].
 */
/**
 * @param arrs: an array of arrays
 * @return: return the max distance among arrays
 */
const maxDiff = function (arrs) {
}
