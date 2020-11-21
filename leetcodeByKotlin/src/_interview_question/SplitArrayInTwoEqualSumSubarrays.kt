package _interview_question

/**
 * Split an array into two equal Sum subarrays
Given an array of integers greater than zero, find if it is possible to split it in two subarrays (without reordering the elements),
such that the sum of the two subarrays is the same. Print the two subarrays.

Examples :

Input : Arr[] = { 1 , 2 , 3 , 4 , 5 , 5 }
Output :  { 1 2 3 4 }
{ 5 , 5 }

Input : Arr[] = { 4, 1, 2, 3 }
Output : {4 1}
{2 3}

Input : Arr[] = { 4, 3, 2, 1}
Output : Not Possible
 * */
class Solution2 {
    /*
    * solution:
    * 1. prefix sum
      2. sum up from right to left and reduce the prefix sum
      3. compare two number and find out the split index
    * */
    fun splitArray(nums: IntArray) {
        var prefixSum = 0
        for (num in nums) {
            prefixSum += num
        }
        var sum = 0
        var splitIndex = 0
        for (i in nums.size - 1 downTo 0) {
            sum += nums[i]
            prefixSum -= nums[i]
            if (sum == prefixSum) {
                splitIndex = i
            }
        }
        println(nums.slice(0 until splitIndex))
        println(nums.slice(splitIndex until nums.size))
    }
}