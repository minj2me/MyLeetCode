/**
 * //1.subproblem 2.guessing 3.recurrence
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 * 
 * 一个DP问题。定义possible[i] 为S字符串上[0,i]的子串是否可以被segmented by dictionary.
possible[i] = true      if  S[0,i]在dictionary里面
                = true      if   possible[k] == true 并且 S[k+1,i]在dictionary里面， 0<k<i
               = false      if    no such k exist.
 */
var wordBreak = function (s, wordDict) {
    //Runtime: 68 ms
    /*let map = new Map();
    initContaner(wordDict, map);
    let n = s.length;
    let dp = new Array(n);
    for (let i = 0; i < dp.length; i++)
        dp[i] = false;
    for (let i = 0; i < n; i++) {
        let check = s.substring(0, i + 1);
        console.log("check:" + check);
        if (isContains(check, map)) {
            //设dp[i]为前i个字符是否可以切割
            dp[i] = true;
            console.log("dp[" + i + "] = true");
            continue;
        }
        for (let j = 0; j < i; j++) {
            let checkAgain = s.substring(j + 1, i + 1);
            console.log("checkAgain:" + checkAgain);
            console.log("j:" + j);
            if (dp[j] && isContains(checkAgain, map)) {
                console.log("dp[" + i + "] = true");
                dp[i] = true;
            }
        }
    }
    console.log(dp[n - 1]);
    return dp[n - 1];*/

    //memorization recursion
    //time, space?
    //60 ms
    let mem = new Map();
    //add wordDic into map
    let dictMap = new Map();
    for (let i = 0; i < wordDict.length; i++)
        dictMap.set(wordDict[i], i);
    return wordBreakHelp(s, wordDict, mem, dictMap);
};

var wordBreakHelp = function (s, wordDice, mem, dictMap) {
    if (mem.has(s))
        return mem.get(s);
    if (dictMap.has(s)) {
        mem.set(s, true);
        return true;
    }
    //check every char
    for (let i = 0; i < s.length; i++) {
        if (dictMap.has(s.substring(i)) && wordBreakHelp(s.substring(0, i), wordDice, mem, dictMap)) {
            mem.set(s, true);
            return true;
        }
    }
    mem.set(s, false);
    return false;
}

var initContaner = function (wordDict, map) {
    for (let i = 0; i < wordDict.length; i++) {
        map.set(wordDict[i], true);
    }
};

var isContains = function (ch, map) {
    return map.get(ch);
};