/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 */

/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function (s) {
    if (s == "") return true;
    var low = s.replace(/\W/g, '').toLowerCase();//去掉所有标点符号并转到小写
    //console.log(low);//amanaplanacanalpanama
    let left = 0, right = low.length - 1;
    while (left < right) {
        // console.log(left + ":" + low[left]);
        // console.log(right + ":" + low[right]);
        if (low[left] != low[right])
            return false;
        left++;
        right--;
    }
    return true;
};