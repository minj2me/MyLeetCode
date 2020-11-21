/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/description/
 * 
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function (a, b) {
    let result = [];
    let aLen = a.length, bLen = b.length;
    let n = Math.max(aLen, bLen);
    let zero = "";
    //是否要进位
    let carry = false;
    if (aLen > bLen) {
        //b补0
        for (let i = 0; i < (aLen - bLen); i++)
            zero += "0";
        b = zero + b;
    } else if (aLen < bLen) {
        //a补0
        for (let i = 0; i < (bLen - aLen); i++)
            zero += "0";
        a = zero + a;
    }
    //console.log(a);
    //console.log(b);
    //reverse() 颠倒数组中元素的顺序。
    //pop() 方法用于删除并返回数组的最后一个元素。
    //shift() 删除并返回数组的第一个元素。
    //unshift() 向数组的开头添加一个或更多元素，并返回新的长度。
    //concat() 连接两个或更多的数组，并返回结果。
    //join() 把数组的所有元素放入一个字符串。元素通过指定的分隔符进行分隔。
    for (let i = n - 1; i >= 0; i--) {
        let temp = 0;
        if (carry)
            temp = parseInt(a[i]) + parseInt(b[i]) + 1;
        else
            temp = parseInt(a[i]) + parseInt(b[i]);
        if (temp == 0 || temp == 1) {
            result.unshift(temp);
            carry = false;
        }
        if (temp == 2) {//1+1=10的情况
            result.unshift(0);
            carry = true;
        }
        if (temp == 3) {//1+1+1=11 进位
            result.unshift(1);
            carry = true;
        }
    }
    if (carry)
        result.unshift(1);
    console.log(result.join(""));
    return result.join("");
};