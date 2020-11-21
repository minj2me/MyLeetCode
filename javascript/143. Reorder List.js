/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/description/
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function (head) {
    //1.find the middle of list
    let middle = findMiddle(head);
    let secondHead = middle.next;
    middle.next = null;//断开中点和后一段
    //2.reserve it
    let reverseSecondHead = reverseLinkedList(secondHead);
    //3.merge 
    return mergeLinkedList(head,reverseSecondHead);
};

var findMiddle = function (head) {
    let slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
};

var reverseLinkedList = function (head) {
    let prev = null;
    let next = null;
    let current = head;
    while (current != null) {
        next = current.next;
        current.next = prev;//point to prve
        prev = current;
        current = next;
    }
    return prev;
};

var mergeLinkedList = function (node1,node2) {
    /*if (node1==null)
        return node2;
    if (node2==null)
        return node1;
    let result={};
    if (node1.val<node2.val){
        result = node1;
        result.next = mergeLinkedList(node1.next,node2);
    } else {
        result = node2;
        result.next = mergeLinkedList(node1,node2.next);
    }
    return result;*/

    let cur = node1;
    while (node2!=null){
        let temp = node2.next;
        node2.next = cur.next;
        cur.next = node2;
        cur = cur.next.next;
        node2 = temp;
    }
};

var listToArray = function (head) {
    let arr = [];
    while (head != null) {
        arr.push(head.val);
    }
    return arr;
};

var arrayToList = function (head, index, arr) {
    if (index >= arr.length)
        return;
    let node = new ListNode(arr[index]);
    head.next = node;
    arrayToList(node, index + 1, arr.concat());
}