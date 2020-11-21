/**
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * https://www.programcreek.com/2015/03/leetcode-odd-even-linked-list-java/
 * 
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL

Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
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
var oddEvenList = function (head) {
    if (head == null)
        return head;
    let result = head;
    let p1 = head;
    let p2 = head.next;
    let current = head.next;
    while (p1 != null && p2 != null) {
        if (p2.next == null)
            break;
        p1.next = p2.next;
        p1 = p1.next;

        p2.next = p1.next;
        p2 = p2.next;
    }
    //p2.next = p2.next.next;
    //因为current为head.next的值，经过p2.next = p2.next.next后，head.next的值变了，所以current也变了
    //console.log(current);
    p1.next = current;
    //console.log(p2);
    //return p1;
    //console.log(result);
    return result
};
