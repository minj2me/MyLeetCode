/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * https://www.programcreek.com/2014/05/leetcode-reverse-linked-list-java/
 * 
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    //iteratively
    let current = head;
    let prev = null;
    let next = null;
    while (current != null) {
        next = current.next;
        current.next = prev
        prev = current;
        current = next;//move the pointer
    }
    return prve;

    //recursively
    // if (head == null || head.next == null)
    //     return head;
    // let second = head.next;
    // head.next = null;
    // let rest = reverseList(second);
    // second.next = head;
    // return rest;
}