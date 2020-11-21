package LeetCode_1060

/**
 * 1060. Missing Element in Sorted Array
 * (Prime)
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.

Example 1:
Input: A = [4,7,9,10], K = 1
Output: 5
Explanation:
The first missing number is 5.

Example 2:
Input: A = [4,7,9,10], K = 3
Output: 8
Explanation:
The missing numbers are [5,6,8,...], hence the third missing number is 8.

Example 3:
Input: A = [1,2,4], K = 3
Output: 6
Explanation:
The missing numbers are [3,5,6,7,...], hence the third missing number is 6.

Note:
1 <= A.length <= 50000
1 <= A[i] <= 1e7
1 <= K <= 1e8
 * */
class Solution {
    /*
    * solution 1: iterate, Time complexity:O(n), Space complexity:O(1)
    * solution 2: binary search, Time complexity:O(logn), Space complexity:O(1)
    * */
    fun getKMissingNumber(nums: IntArray, k: Int): Int {
        //Solution 1:
        val n = nums.size
        var count = k
        var difference = 0
        for (i in 1 until n) {
            //save the difference
            difference = nums[i] - nums[i - 1] - 1
            if (difference >= count) {
                return nums[i - 1] + count
            } else {
                count -= difference
            }
        }
        //the range out of array
        return nums[nums.lastIndex] + count

        //Solution 2:
        /*val n = nums.size
        val missing = nums[n - 1] - nums[0] - (n - 1 - 0)
        //If the missing numbers count of the whole array < k, then missing number must be after nums[n-1].
        //then: res = nums[n-1] + missingCount.
        if (missing < k) {
            println("result:${nums[n - 1] + k - missCount(nums, n - 1)}")
            return nums[n - 1] + k - missCount(nums, n - 1)
        }
        var left = 0
        var right = n - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (missCount(nums, mid) < k) {
                //fall in right side
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        println("result2:${nums[left - 1] + k - missCount(nums, left - 1)}")
        return nums[left - 1] + k - missCount(nums, left - 1)*/
    }

    //for example: 4,(5,6),7 -- > 7 - 4  - (1 - 0) = 3 - 1 = 2;
    private fun missCount(nums: IntArray, index: Int): Int {
        return nums[index] - nums[0] - index
    }

}