/**
 * LOCK!
 * [LeetCode] Longest Substring with At Most Two Distinct Characters 最多有两个不同字符的最长子串

Given a string S, find the length of the longest substring T that contains at most two distinct characters.
For example,
Given S = “eceba”,
T is “ece” which its length is 3.

这道题给我们一个字符串，让我们求最多有两个不同字符的最长子串。
那么我们首先想到的是用哈希表来做，哈希表记录每个字符的出现次数，然后如果哈希表中的映射数量超过两个的时候，我们需要删掉一个映射，
比如此时哈希表中e有2个，c有1个，此时把b也存入了哈希表，那么就有三对映射了，
这时我们的left是0，先从e开始，映射值减1，此时e还有1个，不删除，left自增1。
这是哈希表里还有三对映射，此时left是1，那么到c了，映射值减1，此时e映射为0，将e从哈希表中删除，left自增1，然后我们更新结果为i - left + 1，
以此类推直至遍历完整个字符串。

use sliding window, 2 prointer, 一前一后
题意是 在s里找出两个不相同的字母所组成的最张的substring
 */

var longestSubstringAtTwoDistinctChar = function (s) {
    let start = 0, end = 0, windowSize = 0, k = 2;//,windowStart=0
    let len = s.length;
    let map = new Map();
    let ch = s.charAt(0);
    map.set(ch, 1);
    //console.log(map);
    for (let i = 1; i < len; i++) {
        ch = s.charAt(i);
        if (!map.has(ch)) {
            map.set(ch, 1);
        } else {
            //console.log("has "+ch);
            let temp = map.get(ch);
            map.set(ch, temp + 1);
        }
        end++;
        //move start forward if number of unique characters is greater than k
        while (!isLassThanK(map, k)) {
            let temp = map.get(s.charAt(start));
            map.set(s.charAt(start), temp - 1);
            start++;
        }
        if (end - start + 1 > windowSize) {
            windowSize = end - start + 1;
            //windowStart = start;
        }
    }
    console.log(windowSize);
    return windowSize;
    //below return substring
    //console.log(s.substring(windowStart, windowStart+windowSize));
}

var isLassThanK = function (map, k) {
    let count = 0;
    for (let m of map) {
        if (map.get(m[0]) > 0)
            count++;
    }
    return (count <= k);
}