package LeetCode_1331

import java.util.*
import kotlin.collections.HashMap

/**
 * 1331. Rank Transform of an Array
 * https://leetcode.com/problems/rank-transform-of-an-array/
 *
Given an array of integers arr, replace each element with its rank.
The rank represents how large the element is. The rank has the following rules:
Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.

Example 1:
Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.

Example 2:
Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
 * */
class Solution {
    /*
    * solution: Array copy + HashMap, Time:O(nlogn), Space:O(n)
    * */
    fun arrayRankTransform(arr: IntArray): IntArray {
        val array = Arrays.copyOf(arr, arr.size)
        array.sort()
        //key: num, value: the index of this num in sorted array
        val map = HashMap<Int, Int>()
        for (item in array) {
            //avoid replace index if same num
            if (!map.contains(item)) {
                //put number and its index in map
                map.put(item, map.size + 1)
            }
        }
        for (i in array.indices) {
            //update result by index
            array[i] = map.get(arr[i])!!
        }
        return array
    }
}