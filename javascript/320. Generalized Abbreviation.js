/**
 * Lock by leetcode
 * 320. Generalized Abbreviation
 * https://www.lintcode.com/problem/generalized-abbreviation/description
 * https://www.cnblogs.com/Dylan-Java-NYC/p/5297329.html
 * http://www.cnblogs.com/grandyang/p/5261569.html
 * 
Write a function to generate the generalized abbreviations of a word.

Example
Given word = `"word"`, return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
/**
 * @param word: the given word
 * @return: the generalized abbreviations of a word
 */
const generateAbbreviations = function (word) {
    // Write your code here
    let len = word.length;
    let n = Math.pow(2, len);
    let result = [];
    // console.log("n&1:"+n&1);
    // console.log("n^1:"+n^1);
    // console.log("n^0:"+n^0);
    for (let i = 0; i < n; i++) {
        result.push(abbr(i, word));
    }
    //console.log(result);
    return result;
};
var abbr = function (num, s) {
    let sb = "";
    let count = 0;
    for (let i = 0; i < s.length; i++ , num = num >> 1) {
        if ((num & 1) == 0) {//如果是0
             // 先加上之前的非零count, 再把count清零
            if (count != 0) {
                sb += count;
                count = 0;
            }
            sb += s[i];//加上word的字符
            //console.log(sb);
        } else
            count++;//如是1就是count++
    }
    if (count != 0)
        sb += count;
    return sb;
};
