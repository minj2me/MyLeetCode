package LeetCode_1534

/**
 * 1534. Count Good Triplets
 * https://leetcode.com/problems/count-good-triplets/
 *
 * Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.
Return the number of good triplets.
 * */
class Solution {
    /*
    * solution: bruce force, Time:O(n^3), Space:O(1)
    * */
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var count = 0
        for (i in 0 until arr.size - 2) {
            for (j in i + 1 until arr.size - 1)
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (k in j + 1 until arr.size) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++
                        }
                    }
                }
        }
        return count
    }
}