package LeetCode_325

/**
 * Lock by Leetcode
 * 325. Maximum Size Subarray Sum Equals k
 * https://www.lintcode.com/problem/maximum-size-subarray-sum-equals-k/description
 *
 * https://zhuanlan.zhihu.com/p/32854569
 * https://www.cnblogs.com/Dylan-Java-NYC/p/5238223.html
 *
 * Example
Given nums = [1, -1, 5, -2, 3], k = 3, return 4.
Explanation:
because the subarray [1, -1, 5, -2] sums to 3 and is the longest.

Given nums = [-2, -1, 2, 1], k = 1, return 2.
Explanation:
because the subarray [-1, 2] sums to 1 and is the longest.

Challenge
Can you do it in O(n) time?
 */
class Solution {
    /*
   * solution: HashMap + Prefix Sum, Time:O(n), Space:O(n)
   * */
    fun maxSubArrayLen(array: IntArray, k: Int): Int {
        /*
        需要一个Map来记录preSum以及对应的index，
        注意这里是找max size，所以如果有相同的preSum我们并不更新map，这样能保证某一个PreSum对应的最靠前的index，
        如果题目问的是minSize，就应该改成需要更新map，这样每次map存的就是preSum对应的最靠后的index。
        */
        //key: sum
        //value: the index of where the sum first appeared
        val map = HashMap<Int, Int>()
        map.put(0, -1)
        var maxLen = 0
        var sum = 0
        for (i in array.indices) {
            sum += array[i]
            val lastIndex = map[sum - k]
            if (lastIndex != null) {
                maxLen = Math.max(maxLen, i - lastIndex)
            }
            //if contains the sum, we do not update it, because current index in map is the top_index,
            //so can keeping i - top_index is the max length
            if (!map.containsKey(sum)) {
                map.put(sum, i)
            }
        }
        return maxLen
    }
}