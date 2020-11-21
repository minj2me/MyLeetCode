/**
 * 148. Sort List
https://leetcode.com/problems/sort-list/description/
https://www.cnblogs.com/grandyang/p/4249905.html

 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
var sortList = function (head) {
    if (head == null || head.next == null)
        return head;
    let cur = head, slow = head, fast = head;
    while (fast != null && fast.next != null) {
        cur = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    cur.next = null;
    return mergeList(sortList(head), sortList(slow));
};

var mergeList = function (l1,l2) {
    let fake = new ListNode(-1);
    let cur = fake;//set the head to cur
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        cur = cur.next;
    }
    if (l1 != null)
        cur.next = l1;
    if (l2 != null)
        cur.next = l2;
    //console.log(fake);
    return fake.next;
};