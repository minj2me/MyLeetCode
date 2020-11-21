package LeetCode_315

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
 * */
class Solution {
    fun countSmaller(nums: IntArray): List<Int> {
        val size = nums.size
        val result = ArrayList<Int>()
        //solution 1
        /*for (i in 0 until size) {
            help(size, i, nums, result)
        }*/

        //solution 2
        val list = ArrayList<Int>()
        for (i in size - 1 downTo 0) {
            if (list.isEmpty()) {
                list.add(nums[i])
                result.add(0)
            } else if (nums[i] > list.get(list.size - 1)) {
                //insert into last
                list.add(list.size, nums[i])
                result.add(list.size - 1)
            } else {
                val index = binarySearch(list, nums[i])
                list.add(index, nums[i])
                result.add(index)
            }
        }
        result.reverse()
        return result
    }

    /*
   * solution 2: binary search, Time complexity: O(nlogn), Space complexity:O(n)
   * [left,right), 左闭右开，mean not including right
   * for example: for loop,
   * for(i in 0 until 10)=>[0,10)=>0 count to 9
   * for(i in 0 ... 10)=>[0,10]=>0 count to 10
   * */
    private fun binarySearch(list: ArrayList<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1
        while (left < right) {
            val mid = (left + right) / 2
            if (target > list[mid]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        //return the position that can be insert target into list,
        //the element in the left of position which just less than target
        return left
    }

    /*
    * solution 1: brute force, Time complexity: O(n*n), Space complexity:O(1)
    * */
    private fun help(size: Int, currentIndex: Int, nums: IntArray, result: ArrayList<Int>) {
        var count = 0
        val currentNum = nums[currentIndex]
        var newIndex = currentIndex + 1
        if (newIndex == size) {
            newIndex = size - 1
        }
        for (i in newIndex until size) {
            if (nums[i] < currentNum) {
                count++
            }
        }
        result.add(count)
    }


}