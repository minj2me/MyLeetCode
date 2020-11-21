package _interview_question

/**
 * Problem: Find the most frequent element in all intervals
Given an unsorted list of start and end time ( a range basically), find any number within all the ranges that occurs in maximum number of intervals.
Example: [[1,4],[3,5],[4,6]].
Answer should be 4 because it occurs in all the interval ranges.
 * */
class Solution6 {
    /*
    * solution 1:brute force, Time complexity:O(n*n), Space complexity:O(n)
    * */
    fun findMostFrequent(intervals: Array<IntArray>): Int {
        val map = HashMap<Int, Int>()
        for (interval in intervals) {
            for (item in interval) {
                map.put(item, map.getOrDefault(item, 0) + 1)
            }
        }
        var maxValue = Int.MIN_VALUE
        for (item in map) {
            maxValue = Math.max(maxValue, item.value)
        }
        var result = 0
        for (item in map) {
            if (maxValue == item.value) {
                result = item.key
            }
        }
        println(map)
        return result
    }

    /*
    * solution 2:Time complexity:O(n), Space complexity:O(n);
      1.Initialize a freq array with 0, let the size of the array be 10^6 as this is the maximum possible.
      2.Increase the freq[l] by 1, for every starting index of the given range.
      3.Decrease the freq[r+1] by 1 for every ending index of the given range.
      4.Iterate from the minimum Left to the maximum Right and add the frequencies by freq[i] += freq[i-1].
      5.The index with the maximum value of freq[i] will be the answer.
    * */
    fun findMostFrequent2(intervals: Array<IntArray>): Int {
        val freq = IntArray(1000000)
        var first = 0
        var last = 0
        /*
        * eg: { {1, 6}, {2, 3}, {2, 5}, {3, 8} }
            {
            0: 0
            1: 1
            2: 2
            3: 1
            4: -1
            7: -1
            6: -1
            9: -1
            }
            change into:
             1 -> 0 + 1
             2 -> 1 + 2
             3 -> 4
             4 -> 3
             5 -> 3
             6 -> 2
             7 -> 1
             8 -> 1
        * */
        for (i in intervals.indices) {
            val left = intervals[i][0]
            val right = intervals[i][1]
            freq[left]++
            freq[right + 1]--
            first = Math.min(left, first)
            last = Math.max(right, last)
        }
        var maxFrequent = 0
        var num = 0
        //check for most frequent element
        for (i in first + 1..last) {
            //increase the frequency
            freq[i] = freq[i - 1] + freq[i]
            if (freq[i] > maxFrequent) {
                maxFrequent = freq[i]
                num = i
            }
        }
        return num
    }

}