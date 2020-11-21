/**
 * 266. Palindrome Permutation
 * Given a string, determine if a permutation of the string could form a palindrome.
 * leetcode was lock 
 * https://www.lintcode.com/problem/palindrome-permutation/description
 * https://www.cnblogs.com/grandyang/p/5223238.html

For example,
Given s = "code", return False.
Given s = "aab", return True.
Given s = "carerac", return True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */

/**
* @param s: the given string
* @return: if a permutation of the string could form a palindrome

 用到了一个set，我们遍历字符串，如果某个字母不在set中，我们加入这个字母，如果字母已经存在，我们删除该字母，
 那么最终如果set中没有字母或是只有一个字母时，说明是回文串
*/
const canPermutePalindrome = function (s) {
    let len = s.length;
    //set method
    // let strSet = new Set();
    // for (let i = 0; i < len; i++) {
    //     let c = s.charAt(i);
    //     if (strSet.has(c))
    //         strSet.delete(c);
    //     else
    //         strSet.add(s.charAt(i));
    // }
    // return strSet.size == 1 || strSet.size == 0;

    //map method
    let strMap = new Map();
    for (let i = 0; i < len; i++) {
        let c = s.charAt(i);
        if (!strMap.has(c))
            strMap.set(c, 1);
        else
            strMap.set(c, strMap.get(c) + 1);
    }
    //console.log(strMap);
    //遍历哈希表，统计出现次数为奇数的字母的个数，那么只有两种情况是回文数，
    //第一种是没有出现次数为奇数的字母，第二种就是字符串长度为奇数，且只有一个出现次数为奇数的字母
    let oddCount = 0;
    for (let m of strMap) {
        //let key = m[0];
        let value = m[1];//count of letter
        if (value % 2 == 1)
            oddCount++;
    }
    return oddCount == 0 || (len % 2 == 1 && oddCount == 1);
}