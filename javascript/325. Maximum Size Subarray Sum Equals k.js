/**
 * Lock by Leetcode
 * 
 * 325. Maximum Size Subarray Sum Equals k
 * https://www.lintcode.com/problem/maximum-size-subarray-sum-equals-k/description
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

/**
 * @param nums: an array
 * @param k: a target value
 * @return: the maximum length of a subarray that sums to k
 */
const maxSubArrayLen = function (nums, k) {
    let sum = 0, max = 0, len = nums.length;
    let map = new Map();
    for (let i = 0; i < len; i++) {
        sum += nums[i];
        console.log(sum);
        if (sum == k)
            max = i + 1;
        let target = sum - k;
        //console.log("target:" + target);
        if (map.has(target)) {
            /**
             * [2,0,2,1,1,1]
             * K=3
            Index : 0,1,2,3,4,5....
            Value : 2,0,2,1,1,1....
            Sum: 2,2,4,5,6,7
            Sum-K: 4
            map.containsKey(sum - k) : The index is 2
        从index0~2的总和是4了，从0~5的总和是7了，那么从3~5的总和是不是就是我们想要的3？
             */
            let index = i - map.get(target);
            //console.log("index:" + index);
            max = Math.max(max, index);
        }
        if (!map.has(sum))
            map.set(sum, i);
    }
    return max;
}