package LeetCode_1011

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
 *
 * binary search + greedy
 * */
class Solution {
    fun shipWithinDays(weights: IntArray, D: Int): Int? {
        var left: Int = weights.max() ?: 0
        var right: Int = weights.sum()
        while (left <= right) {
            val mid = (left + right) / 2
            val t = greedy(weights, mid)
            if (t > D) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        print("result:$left")
        return left
    }

    private fun greedy(weights: IntArray, C: Int): Int {
        var ans = 0
        var cums = 0
        for (weight in weights) {
            if ((cums + weight) > C) {
                ans += 1
                cums = 0
            }
            cums += weight
        }
        return ans + if (cums > 0) 1 else 0
    }
}
