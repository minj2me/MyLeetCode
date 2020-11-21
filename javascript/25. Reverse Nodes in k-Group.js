/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * https://www.programcreek.com/2014/05/leetcode-reverse-nodes-in-k-group-java/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
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
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function (head, k) {
    if (head == null || k == 1)
        return head;
    //1.sepatation it
    //2.segment reverse 
    let dummy = new TreeNode(-1);
    let pre = dummy, cur = head;
    dummy.next = head;
    let i = 0;
    while (cur != null) {
        i++
        if (i % k == 0) {
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