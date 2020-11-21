/**
 * Lock by leetcode
 * 186. Reverse Words in a String II
 * https://www.lintcode.com/problem/reverse-words-in-a-string-ii/description
 * 
 * Given an input character array, reverse the array word by word. 
 * A word is defined as a sequence of non-space characters.
The input character array does not contain leading or trailing spaces and the words are always separated by a single space.

Example
Given s = "the sky is blue",
after reversing : "blue is sky the"

Challenge
Could you do it in-place without allocating extra space?
 */
/**
 * @param array: char array
 * @return: return a string
 */
const reverseWords = function (strArray) {
    let left = 0, len = strArray.length;
    for (let i = 0; i < len; i++) {
        if (strArray[i] == " ") {
            strArray = this.reverseStr(strArray, left, i + 1);
            left = i + 1;
        }
    }
    //str =  this.reverseStr(str, 0, len - 1);
    console.log(strArray);
};

var reverseStr = function (strArray, left, right) {
    // console.log("left:" + left);
    // console.log("right:" + right);
    while (left < right) {
        let temp = strArray[left];
        //console.log("temp:" + temp);
        strArray[left] = strArray[right];
        strArray[right] = temp;
        left++;
        right--;
    }
    return strArray;
}