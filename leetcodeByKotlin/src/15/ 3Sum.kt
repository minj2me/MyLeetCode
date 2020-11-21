package LeetCode_15

import kotlin.collections.ArrayList

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
1. 0 <= nums.length <= 3000
2. -105 <= nums[i] <= 105
 * */
class Solution {
    /*
    * solution 1: DFS, Backtracking, TLE
    * solution 2: Two Pointer, Time:O(n^2), Space complexity:O(n)
    * */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (nums==null || nums.isEmpty()){
            return result
        }
        //solution 1
        /*val used = BooleanArray(nums.size)
        dfs(0, 0, 3, nums, ArrayList(), used, result)*/

        //solution 2:
        findThreeSum(nums, result)
        println("result:$result")
        return result
    }

    private fun findThreeSum(nums: IntArray, result:ArrayList<ArrayList<Int>>){
        nums.sort()
        val set = HashSet<ArrayList<Int>>()
        var left = 0
        var right = 0
        for (i in nums.indices){
            left = i + 1
            right = nums.size - 1
            //avoid duplicate
            /*if (i > 0 && nums[i] == nums[i-1]){
                continue
            }*/
            while (left < right){
                //avoid duplicate
                /*if ((right < nums.size - 1) && (nums[right] == nums[right + 1])){
                    right--
                    continue
                }*/
                if (nums[i] + nums[left] + nums[right] == 0){
                    val list = arrayListOf(nums[i], nums[left], nums[right])
                    if (!set.contains(list)) {
                        set.add(list)
                        result.add(list)
                    }
                    //result.add(list)
                    left++
                    right--
                }
                else if (nums[i] + nums[left] + nums[right] < 0){
                    //if sum less than 0, we need more large number, so left++
                    left++
                } else {
                    right--
                }
            }
        }
    }

    private fun dfs(index: Int, target: Int, count:Int, nums: IntArray, cur: ArrayList<Int>, used: BooleanArray,result: ArrayList<ArrayList<Int>>) {
        //because need 3 numbers and sum up is 0
        if (count == 0 && target == 0) {
            val temp = ArrayList<Int>(cur)
            result.add(temp)
            return
        }
        for (i in index until nums.size) {
            //avoid duplicate number
            if (used[i]){
                continue
            }
            used[i] = true
            cur.add(nums[i])
            dfs(index + 1, target - nums[i],count-1, nums, cur, used, result)
            cur.removeAt(cur.lastIndex)
            used[i] = false
        }
    }
}