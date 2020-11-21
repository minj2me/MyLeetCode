/**
 * Lock by Leetcode
 * 369. Plus One Linked List
 * https://www.lintcode.com/problem/plus-one-linked-list/description
 * 
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.

Example
Given head = 1 -> 2 -> 3 -> null, return 1 -> 2 -> 4 -> null.
 */
/**
 * @param head: the first Node
 * @return: the answer after plus one
 */
const plusOne = function (head) {
    // Write your code here
    let str = "";
    while (head != null) {
        str += head.val;
        head = head.next;
    }
    let resultStr = addTwoString(str, "1");
    let arr = resultStr.split("");
    let newHead = new ListNode(parseInt(arr[0]));
    createList(newHead, 1, arr);
    return newHead;
};

var addTwoString = function (str1, str2) {
    let len1 = str1.length - 1, len2 = str2.length - 1;
    let carry = 0;
    let res = [];
    while (len1 >= 0 || len2 >= 0) {
        let a = len1 >= 0 ? str1.charAt(len1--) - '0' : 0;
        let b = len2 >= 0 ? str2.charAt(len2--) - '0' : 0;
        let temp = a + b + carry;
        if (temp >= 10) {
            carry = Math.floor(temp / 10);//10位
            temp = Math.floor(temp % 10);//个位 
        } else
            carry = 0;
        //   console.log("carry:" + carry);
        //   console.log("temp:" + temp);
        res.unshift(temp);
    }
    if (carry)
        res.unshift(1);

    return res.join("");
};

var createList = function (head, index, arr) {
    if (index >= arr.length)
        return;
    let node = new ListNode(parseInt(arr[index]));
    head.next = node;
    createList(node, index + 1, arr.concat());
};