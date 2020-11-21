/**
 * Lock by Leetcode
 * 161. One Edit Distance
 * https://www.lintcode.com/problem/one-edit-distance/description
 * https://www.cnblogs.com/grandyang/p/5184698.html
 * https://blog.csdn.net/huaweidong2011/article/details/7727482
 * 
 * Description
Given two strings S and T, determine if they are both one edit distance apart.

Example
Given s = "aDb", t = "adb"
return true

这道题是之前那道Edit Distance的拓展，然而这道题并没有那道题难，这道题只让我们判断两个字符串的编辑距离是否为1，
那么我们只需分下列三种情况来考虑就行了：
1. 两个字符串的长度之差大于1，那么直接返回False
2. 两个字符串的长度之差等于1，那么长的那个字符串去掉一个字符，剩下的应该和短的字符串相同
3. 两个字符串的长度之差等于0，那么两个字符串对应位置的字符只能有一处不同。
 */
/**
 * @param s: a string
 * @param t: a string
 * @return: true if they are both one edit distance apart or false
 */
var isOneEditDistance = function (s, t) {
    if (s.length < t.length) {
        let temp = s;
        s = t;
        t = temp;
    }
    let longLen = s.length, shortLen = t.length;
    let diff = longLen - shortLen;
    if (diff >= 2)
        return false;
    else if (diff == 1) {
        for (let i = 0; i < longLen; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(i + 1) == t.substring(i);
        }
        return true;
    } else {
        let diffCount = 0;
        for (let i = 0; i < longLen; i++) {
            if (s.charAt(i) != t.charAt(i))
                diffCount++;
        }
        return diffCount == 1;
    }
}