/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 * 
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
    let result = [];
    let map = new Map();
    var key = "";
    for (let str of strs) {//quick than for than strs[i]
        key = sortString(str);
        if (!map.has(key)) {
            let arr = [];
            arr.push(str);
            map.set(key, arr);
        } else {
            map.get(key).push(str);
        }
    }
    for (let m of map) {
        result.push(m[1]);
    }
    //console.log(result);
    return result;
};

var sortString = function (string) {
    let arr = string.split("");
    let sorted = arr.sort();
    let str = sorted.join("");
    return str;
};