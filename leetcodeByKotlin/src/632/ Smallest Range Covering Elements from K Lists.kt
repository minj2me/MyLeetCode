package LeetCode_632

import java.util.*
import kotlin.collections.ArrayList

/**
 * 632. Smallest Range Covering Elements from K Lists
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 *
 * You have k lists of sorted integers in non-decreasing order.
 * Find the smallest range that includes at least one number from each of the k lists.
We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

Example 1:
Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation:
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

Constraints:
1. nums.length == k
2. 1 <= k <= 3500
3. 1 <= nums[i].length <= 50
4. -105 <= nums[i][j] <= 105
5. nums[i] is sorted in non-decreasing order.
 * */
class Solution {
    /*
    * solution: Sliding window+Tree Map
    * */
    fun smallestRange(nums: List<List<Int>>): IntArray {
        /*
        * keep index for each element, and sort it,
        * for example: [[1,2],[0,3]]=>{0=[1],1=[0],2=[0],3=[1]}, mean 0 from list2, 1 from list1
        * */
        //key is num, value is the list, contains the index of the key in which list
        val treeMap = TreeMap<Int, ArrayList<Int>>()
        for (i in nums.indices) {
            for (n in nums[i]) {
                if (!treeMap.containsKey(n)) {
                    treeMap.put(n, ArrayList())
                }
                treeMap.get(n)!!.add(i)
            }
        }
        //println(treeMap)
        val list = ArrayList<Int>(treeMap.keys)
        //init result by first and last element in list
        val result = IntArray(2)
        result[0] = list[0]
        result[1] = list[list.lastIndex]
        //println(list)
        var left = 0
        var right = 0
        val cnt = IntArray(nums.size)
        val n = list.size
        while (left < n) {
            //moving right pointer
            while (right < n && !allIn(cnt)) {
                val curNum = list.get(right)
                println("list.get($right):${curNum}")
                //checking current number in which list
                for (m in treeMap.get(curNum)!!) {
                    println("m:$m")
                    cnt[m]++
                }
                right++
            }
            //condition matching by:
            //define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.
            if (allIn(cnt) && (list[right - 1] - list[left] < result[1] - result[0])) {
                result[0] = list[left]
                result[1] = list[right - 1]
            }
            //moving left pointer???
            val curNum2 = list.get(left)
            println("list.get($left):${curNum2}")
            for (m in treeMap.get(curNum2)!!){
                cnt[m]--
            }
            left++
        }
        result.forEach { print("$it,") }
        return result
    }

    //check if all index of list in cnt array
    private fun allIn(cnt: IntArray): Boolean {
        for (n in cnt) {
            if (n == 0) {
                return false
            }
        }
        return true
    }
}