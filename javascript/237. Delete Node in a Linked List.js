/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 
 * Example 1:
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
 */
/**
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function (node) {
    //change node's val and next
    node.val = node.next.val;
    node.next = node.next.next;
};