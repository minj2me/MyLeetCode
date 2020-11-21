/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
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
 * @return {ListNode}
 */
var swapPairs = function (head) {
    if (head == null || head.next == null)
        return head;
    let dummy = new ListNode(-1);
    let pre = dummy;
    let cur = head;
    dummy.next = head;
    let i = 0;
    while (cur != null) {
        i++;
        if (i % 2 == 0) {
            pre = reserveGroup(pre, cur.next);
            cur = pre.next;
        } else
            cur = cur.next;
    }
    return dummy.next;
};
var reserveGroup = function (pre, next) {
    let last = pre.next;
    let cur = last.next;
    while (cur != next) {
        last.next = cur.next;
        cur.next = pre.next;
        pre.next = cur;
        cur = last.next;
    }
    return last;
}