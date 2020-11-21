package LeetCode_31

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/description/
 *
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place and use only constant extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * */
class Solution {
    /*
    solution 1: Time complexity:O(n^2), Space complexity:O(1)
    * Approach
    ==Find the first decreasing index moving from end to start
        E.g. [7, 2, 3, 1, 5, 4, 3, 2, 0] num 1 is the first decreasing index going from the end backwards
    ==Swap num 1 with the next large num to its right which is 2
        [7, 2, 3, 2, 5, 4, 3, 1, 0]
    ==Reverse/sort nums to the right
        [7, 2, 3, 2, 0, 1, 3, 4, 5]
    ==If there is no next permutation return a sorted array
    * */
    fun nextPermutation(nums: IntArray): Unit {
        if (nums == null || nums.isEmpty()) {
            return
        }
        //start from the second last number, because need compare it and the last number
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                val large = nextLargeIndex(nums, i)
                swap(nums, i, large)
                reverse(i+1,nums)
                return
            }
        }
        nums.sort()

    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun nextLargeIndex(nums: IntArray, index: Int): Int {
        for (i in nums.size - 1 downTo index) {
            if (nums[i] > nums[index]) {
                return i
            }
        }
        return 0
    }

    private fun reverse(start: Int, nums: IntArray) {
        var i = start
        var j = nums.size - 1
        while (i <= j) {
            swap(nums, i, j)
            i++
            j--
        }
    }
}