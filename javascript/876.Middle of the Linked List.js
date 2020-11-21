/**
 * 876. Middle of the Linked List
 * 
 * https://leetcode.com/problems/middle-of-the-linked-list/description/
 * 
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

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
var middleNode = function(head) {
    let fast = head;
    let slow = head;
    //因为快指针比慢指针走快一倍，所以当fast走完时，slow刚好在中间
    while (fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next
    }
    // console.log(fast);
    // console.log(slow);
    // console.log(head);
    return slow
};