/**
 * 267. Palindrome Permutation II
 * Given a string s, return all the palindromic permutations (without duplicates) of it. 
 * Return an empty list if no palindromic permutation could be form.

 https://www.lintcode.com/problem/palindrome-permutation-ii/description
 https://www.jianshu.com/p/cec059f214f5

Example
Given s = "aabb", return ["abba","baab"].
Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: 
Permutations II or Next Permutation.
 */

/**
* @param s: the given string
* @return: all the palindromic permutations (without duplicates) of it
*/
const generatePalindromes = function (s) {
    let len = s.length;
    let needCenter = len % 2 != 0;
    let strMap = new Map();
    for (let i = 0; i < len; i++) {
        let c = s.charAt(i);
        if (!strMap.has(c))
            strMap.set(c, 1);
        else
            strMap.set(c, strMap.get(c) + 1);
    }
    //console.log(strMap);
    let oddCount = 0;
    let str = "", center = "";
    for (let m of strMap) {
        let key = m[0];
        console.log("key:" + key);
        let value = m[1];//count of letter
        if (value % 2 == 1)
            oddCount++;
        if (oddCount > 1)
            return [];
        center = key;
        //get the half string of s
        for (let i = 0; i < Math.floor(strMap.get(key) / 2); i++) {
            str += key;//half string of s
        }
    }
    let halfStringPalindrome = [];
    let result = [];
    this.getPermutation(str, halfStringPalindrome);
    //console.log(halfStringPalindrome);
    //generate result palindrome
    for (let i = 0; i < halfStringPalindrome.length; i++) {
        let str_ = halfStringPalindrome[i].join("");
        let str_2 = halfStringPalindrome[i].reverse().join("");
        // console.log("center:" + center);
        result.push(str_ + (needCenter ? center : "") + str_2);
    }
    //console.log(result);
    return result;
};
var getPermutation = function (s, result) {
    let visited = new Array(s.length).fill(0);
    this.dfs(0, s, [], visited, result);
    return result;
};
var dfs = function (level, s, out, visited, result) {
    if (level == s.length) {
        result.push(out);
        return;
    }
    for (let i = 0; i < s.length; i++) {
        if (visited[i] == 0) {
            if (i > 0 && s[i] == s[i - 1] && visited[i - 1] == 0)
                continue;
            visited[i] = 1;
            out.push(s[i]);
            this.dfs(level + 1, s, out.concat(), visited, result);
            out.pop();
            visited[i] = 0;
        }
    }
};