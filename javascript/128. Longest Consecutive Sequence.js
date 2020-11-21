/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 * 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function (nums) {
    let len = nums.length;
    let map = {};// key is nums[i], value is i
    let visited = [];
    let i, left, right, curLen, maxLen = 0;
    for (let i = 0; i < len; i++) {
        map[nums[i]] = i;
    }
    //console.log(map);
    for (var val in map) {
        i = map[val];
        if (visited[i])
            continue;
        val = parseInt(val);
        left = val - 1;
        right = val + 1;
        curLen = 1;
        while (map.hasOwnProperty(left)) {
            visited[map[left]] = true;
            curLen++;
            left--;
        }
        while (map.hasOwnProperty(right)) {
            visited[map[right]] = true;
            curLen++;
            right++;
        }
        if (curLen > maxLen)
            maxLen = curLen;
        //console.log(maxLen);
    }
    return maxLen;
};