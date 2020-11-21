package LeetCode_347

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Time complexity try on O(n)
 * */
class Solution {
    /*
    * solution 1: maxHeap, Time complexity:O(nlogn), Space complexity:O(n)
    * solution 2: bucket sort, Time complexity:O(n), Space complexity:O(n)
    * */
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val result = ArrayList<Int>()
        //solution 1:
        //first: num
        //second: the frequency of num
        /*val maxHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
        val frequencyMap = HashMap<Int, Int>()
        for (num in nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1)
        }
        frequencyMap.forEach { key, value ->
            //key is num
            //value is frequency
            val pair = Pair(key, value)
            maxHeap.add(pair)
            if (maxHeap.size > k){
                maxHeap.remove()
            }
        }
        for (i in 0 until k) {
            //result.add(maxHeap.remove().first)
            result.add(0, maxHeap.remove().first)
        }*/

        //solution 2:
        val frequencyMap = HashMap<Int, Int>()
        for (num in nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1)
        }
        /*
        * bucket to save that numbers appear the same frequency, for example:
        * 1,1,1,2,2,3, bucket[3]=1, bucket[2]=2
        * */
        val bucket = Array<ArrayList<Int>>(nums.size + 1) { ArrayList() }
        for (item in frequencyMap) {
            val frequency = item.value
            if (bucket[frequency] == null) {
                bucket[frequency] = ArrayList()
            }
            bucket[frequency].add(item.key)
        }
        var i = bucket.size - 1
        while (i > 0 && result.size < k) {
            if (bucket[i]!=null){
                result.addAll(bucket[i])
            }
            i--
        }
        return result
    }
}