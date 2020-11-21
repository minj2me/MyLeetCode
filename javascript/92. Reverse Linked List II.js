/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 * https://www.cnblogs.com/grandyang/p/4306611.html
 * 
 * Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function (head, m, n) {
    let dummy = new ListNode(-1);
    dummy.next = head;
    let cur = dummy;
    let pre = null, front = null, last = null;
    for (let i = 1; i <= m - 1; i++) {
        cur = cur.next;
        //console.log(cur);
    }
    pre = cur;
    //console.log(pre);
    last = cur.next;
    //console.log(last);
    //take out m to n
    for (let i = m; i <= n; i++) {
        cur = pre.next;
        pre.next = cur.next;
        cur.next = front;
        front = cur;
    }
    //merge it into old linked list
    cur = pre.next;
    //console.log(front);
    pre.next = front;
    last.next = cur;
    //console.log(dummy.next);
    return dummy.next;
};