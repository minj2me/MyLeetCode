package LeetCode_581

/**
 * 581. Shortest Unsorted Continuous Subarray
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * */
class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var rightIndex = 0
        var leftIndex = 0
        var maxSoFar = Int.MIN_VALUE
        //scan from left to right
        for (i in 0 until nums.size) {
            //println("i:$i")
            if (maxSoFar < nums[i]) {
                //keeping track the max number, avoid the same num also, for example:1,3,2,2,2
                maxSoFar = nums[i]
                println("maxSoFar:$maxSoFar")
            }
            if (nums[i] < maxSoFar) {
                rightIndex = i//keeping find the index of last unsorted num
                println("rightIndex:$rightIndex")
            }
        }
        println()
        var minSoFar = Int.MAX_VALUE
        //scan from right to left
        for (j in nums.size - 1 downTo 0) {
            if (minSoFar > nums[j]) {
                minSoFar = nums[j]
                println("minSoFar:$minSoFar")
            }
            if (nums[j] > minSoFar) {
                leftIndex = j
                println("leftIndex:$leftIndex")
            }
        }
        return if (leftIndex==0 && rightIndex==0) return 0 else nums.toList().subList(leftIndex,rightIndex+1).size
    }
}