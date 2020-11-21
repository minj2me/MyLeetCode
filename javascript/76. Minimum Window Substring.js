/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/description/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 */

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
    if (s == "" || t == "") return "";
    let matchCount = 0, result = "";
    let arrT = [], arrS = [];
    //set up arrT and arrS
    for (let c of t) {
        if (arrT[c] == NaN || arrT[c] == undefined)
            arrT[c] = 1;
        else
            arrT[c]++;
    }
    for (let c of s) {
        if (arrS[c] == undefined)
            arrS[c] = 0;
    }
    //console.log(arrS);
    let left = findNextStr(0, s, arrT);
    if (left == s.length)
        return "";
    let right = left;
    //start scan. 
    //use right pointer to check each letter
    while (right < s.length) {
        let rightChar = s.charAt(right);
        if (arrS[rightChar] < arrT[rightChar])
            matchCount++;
        arrS[rightChar]++;
        while (left < s.length && matchCount == t.length) {
            if (result == "" || result.length > right - left + 1) {
                //如果result为空或者找到比当前result更短的
                result = s.substring(left, right + 1);
            }
            //start to move left pointer
            let leftChar = s.charAt(left);
            if (arrS[leftChar] <= arrT[leftChar])
                matchCount--;
            arrS[leftChar]--;
            //left pointer move to next vaild character
            left = findNextStr(left + 1, s, arrT);
        }
        //right pointer also move to next vaild character
        //right = findNextStr(right + 1, s, arrT);
        //i changed to right++, fast than right = findNextStr(right + 1, s, arrT);
        right++;
    }
    //console.log(result);
    return result
};
var findNextStr = function (start, s, arrT) {
    while (start < s.length) {
        let c = s.charAt(start);
        if (arrT[c] > 0)
            return start;
        start++;
    }
};