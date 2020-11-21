/**
 * 91. Decode Ways
 * https://leetcode.com/problems/decode-ways/description/
 * https://www.cnblogs.com/Dylan-Java-NYC/p/4824951.html
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
    /*if (s == "")
        return 0;
    let mem = new Array(s.length + 1);
    for (let i = 0; i < s.length + 1; i++)
        mem[i] = -1;
    console.log(mem);
    let way = numDecodings_(s, 0, mem);
    console.log(way);
    return way;*/

    //try dp
    /*递推和等台阶的题目很像. 以"321" 为例，到了第三位时,  s.substring(i-1, i) = "1"是 valid的, s.substring(i-2, i) = "21" 也是valid的.
    dp[i] = dp[i-1] + dp[i-2]. 
    答案是dp[dp.length-1].
*/
    if (s == null || s.length == 0)
        return 0;
    let dp = new Array(s.length + 1).fill(0);
    dp[0] = 1;
    dp[1] = isValid(s.substring(0, 1)) ? 1 : 0;//handle input "0"
    for (let i = 2; i < dp.length; i++) {
        if (isValid(s.substring(i - 1, i)))
            dp[i] += dp[i - 1];
        if (isValid(s.substring(i - 2, i)))
            dp[i] += dp[i - 2];
    }
    return dp[dp.length - 1];
};

var isValid = function (s) {
    if (s.charAt(0) == '0')
        return false;
    return parseInt(s) >= 1 && parseInt(s) <= 26;
};

var numDecodings_ = function (s, level, mem) {
    if (mem[level] != -1)
        return mem[level];
    if (s.length == level) {
        mem[level] = 1;
        return 1;
    }
    //example:12,check 2 and 12
    let way = 0;
    if (s[level] != 0)
        way += numDecodings_(s, level + 1, mem);
    //let num = s[level]+""+s[level+1];
    if (checkIfValid(s, level))
        way += numDecodings_(s, level + 2, mem);
    mem[level] = way;
    //console.log(way);
    return way;
};

var checkIfValid = function (s, start) {
    if (start + 1 >= s.length) {
        return false;
    }
    if (s[start] == "1") {
        return true;
    }
    if (s[start] == "2" && parseInt(s[start + 1]) - 6 <= 0) {//if within 26
        return true;
    }
    return false;
};