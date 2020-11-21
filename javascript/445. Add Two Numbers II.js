/**
 * 445. Add Two Numbers II
https://leetcode.com/problems/add-two-numbers-ii/description/

You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let str1 = "", str2 = "";
    while (l1 != null) {
        if (l1 != null)
            str1 += l1.val + "";
        l1 = l1.next;
    }
    while (l2 != null) {
        if (l2 != null)
            str2 += l2.val + "";
        l2 = l2.next;
    }
    //let result = parseInt(str1) + parseInt(str2);
    //使用字符串相加
    let resultStr = addStrings(str1, str2);
    //let resultStr = result + "";
    //console.log(resultStr);
    let arr = resultStr.split("");
    let head = new ListNode(parseInt(arr[0]));
    //array to linked list
    createList(head, 1, arr);
    return head;
};
var createList = function (head, index, array) {
    if (index >= array.length) {
        return;
    } else {
        let val = parseInt(array[index]);
        let node = new ListNode(val);
        head.next = node;
        createList(node, index + 1, array.concat());
    }
};
var addStrings = function (num1, num2) {
    let len1 = num1.length - 1, len2 = num2.length - 1;
    let carry = 0;
    let result = [];
    while (len1 >= 0 || len2 >= 0) {
        let a = len1 >= 0 ? num1.charAt(len1--) - '0' : 0;
        let b = len2 >= 0 ? num2.charAt(len2--) - '0' : 0;
        let temp = a + b + carry;
        if (temp >= 10) {
            carry = Math.floor(temp / 10);//进位
            temp = Math.floor(temp % 10);//个位数
        } else
            carry = 0;
        //console.log(carry);
        //console.log(temp);
        result.unshift(temp);
    }
    if (carry)
        result.unshift(1);
    //console.log(result.join(""));
    return result.join("");
};