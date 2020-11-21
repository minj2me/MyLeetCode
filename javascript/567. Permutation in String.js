/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/description/
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.
 * 
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].

下面这种解法也是用一个哈希表外加双指针来做的，跟上面的解法思路大体相同，写法有些不同，不变的还是统计s1中字符出现的次数，
不一样的是我们用一个变量cnt来表示还需要匹配的s1中的字符的个数，初始化为s1的长度，然后遍历s2中的字符，如果该字符在哈希表中存在，
说明匹配上了，cnt自减1，哈希表中的次数也应该自减1，然后如果cnt减为0了，说明s1的字符都匹配上了，
如果此时窗口的大小正好为s1的长度，那么说明找到了s1的全排列，返回true，否则说明窗口过大，里面有一些非s1中的字符，我们将左边界右移，
同时将移除的字符串在哈希表中的次数自增1，如果增加后的次数大于0了，说明该字符是s1中的字符，我们将其移除了，那么cnt就要自增1
 */
/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var checkInclusion = function (s1, s2) {
    if (s1 == "" || s2 == "")
        return false;
    let left = 0, cnt = s1.length;
    let arrS1 = [];
    for (let c of s1) {
        if (arrS1[c] == undefined)
            arrS1[c] = 1;
        else
            arrS1[c]++;
    }
    for (let right = 0; right < s2.length; right++) {
        let ch = s2.charAt(right);
        if (arrS1[ch]-- > 0) {
            cnt--;
        }
        while (cnt == 0) {
            if (right - left + 1 == s1.length)
                return true;
            if (++arrS1[s2.charAt(left++)] > 0)
                cnt++;
        }
    }
    return false;
};