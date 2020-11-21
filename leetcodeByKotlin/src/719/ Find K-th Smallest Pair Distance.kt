package LeetCode_719

/**
 * 719. Find K-th Smallest Pair Distance
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/
 *https://www.cnblogs.com/grandyang/p/8627783.html
 *
 * Given an integer array, return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.

Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * */
class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        var k_ = k
        //val N = 1000000
        val N = 10
        val array = IntArray(N)
        //1,3,1,1,2,3
        for (i in nums.indices) {
            for (j in (i + 1) until nums.size) {
                //保存距离出现的次数
                array[Math.abs(nums[i] - nums[j])]++
                //println("array[${Math.abs(nums[i] - nums[j])}]++")
            }
        }
        for (item in array){
            println(item)
        }
        for (i in 0 until N) {
            if (array[i] >= k_) {
                return i
            }
            //否则就用k减去这个距离的出现次数
            k_ -= array[i]
        }
        return -1
    }

    /*private fun subSetHelper(
        subSetList: ArrayList<ArrayList<Int>>,
        tempList: ArrayList<Int>,
        nums: IntArray,
        index: Int
    ) {
        subSetList.add(ArrayList<Int>(tempList))
        for (i in index until nums.size) {
            tempList.add(nums[i])
            subSetHelper(subSetList, tempList, nums, i + 1)
            tempList.removeAt(tempList.size - 1)
        }
    }*/
}