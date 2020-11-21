/**
 * 461. Hamming Distance
 * 
 * https://leetcode.com/problems/hamming-distance/description/
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

两个数字之间的汉明距离就是其二进制数对应位不同的个数，那么最直接了当的做法就是按位分别取出两个数对应位上的数并异或，
我们知道异或的性质上相同的为0，不同的为1，如：如2与2异或是0， 我们只要把为1的情况累加起来就是汉明距离了
我们可以一开始直接将两个数字异或起来，然后我们遍历异或结果的每一位，统计为1的个数
 */
/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
   let res = 0,exc = x^y;
   //console.log(exc);
   for (let i=0;i<32;i++){
       res+=(exc>>i)&1;///&1,不同的为1
   }
   return res;
};