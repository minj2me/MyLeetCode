package _interview_question

/**
 * Given an array of integers size 'n'
Our aim is to calculate the maximum sum of 'k'
consecutive elements in the array
//input
const arr = [100,200,300,400]
k = 2
//Output
700
 * */
class Solution12 {
    /*
    * Solution: Sliding Window, Time complexity:O(n), Space complexity:O(1)
    * */
    fun maximumSumOfKConsecutive(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var max = 0
        var windowSum = 0
        for (i in 0 until k) {
            windowSum += nums[i]
        }
        for (i in k until nums.size) {
            /*
            * set up the sum of range, for example: 1,2,3,4; k=1
            * windowSum = 1+2 after below, then add 3 and minus 1 at first loop and keep looping
            * */
            windowSum += nums[i]
            windowSum -= nums[i - k]
            max = Math.max(windowSum, max)
        }
        return max
    }
}