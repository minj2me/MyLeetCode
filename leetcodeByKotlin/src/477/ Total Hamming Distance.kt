package LeetCode_477

/**
 * 477. Total Hamming Distance
 * https://leetcode.com/problems/total-hamming-distance/description/
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
 * */
class Solution {
    /*
    * solution:bit, Time complexity:O(n)
    * Hamming Distance is how many bits are different in binary;
    * */
    fun totalHammingDistance(nums: IntArray): Int {
        //count one on each bit, total distance+=ones*zeros
        var result = 0
        var mark = 1
        for (i in 0 until 32) {
            var oneCount = 0
            for (num in nums) {
                //oneCount += (num shr i) and 1
                if ((num and mark) > 0) {
                    oneCount++
                }
            }
            result += (nums.size - oneCount) * oneCount
            mark = mark shl 1//left shift
        }
        return result
    }
}