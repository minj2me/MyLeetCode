/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 * 
 *  let l1 = {
      val: 1,
      next: { val: 2, next: { val: 4, next: {} } }
    };
    let l2 = {
      val: 1,
      next: { val: 3, next: { val: 3, next: { val: 1, next: {} } } }
    };

 */

/**
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function (node) {
    node.val = node.next.val;
    node.next = node.next.next;
};

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Input: 1->1->2->3->3
    Output: 1->2->3
 * @param {*} head 
 */
var deleteDuplicates = function (head) {
    if (head == null) return null;
    let result = head;
    while (head.next != null) {
        if (head.val == head.next.val && head.next != null) {
            head.next = head.next.next;
            continue;
        }
        head = head.next;
    }
    console.log(head);
    console.log(result);
    return result;
};


/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/description/
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 * Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
 */
var rotateRight = function (head, k) {
    if (head == null) return null;
    let current = head;
    // let next = null;
    // let prev = null;
    let len = 0;
    while (current != null) {
        len++;
        current = current.next;
    }
    let step = k % len;
    let fast = slow = head;
    for (let i = 0; i < step; i++) {
        if (fast)
            fast = fast.next;
    }
    while (fast.next) {
        fast = fast.next;
        slow = slow.next;
    }
    fast.next = head;
    fast = slow.next;
    slow.next = null;
    console.log(fast);
    return fast;
};

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function (head) {
    let current = head;
    let next = null;
    let prev = null;
    while (current != null) {
        next = current.next;//save down the next
        current.next = prev;
        prev = current;
        current = next;
    };
    return prev;
}

var mergeTwoLists = function (l1, l2) {
    //208 ms!!!
    if (l1 == null)
        return l2;
    if (l2 == null)
        return l1;
    let result = {};
    //while (l1 != null && l2 != null) {
    //console.log("aa");
    if (l1.val < l2.val) {
        result = l1;
        result.next = this.mergeTwoLists(l1.next, l2);
    } else {
        result = l2;
        result.next = this.mergeTwoLists(l2.next, l1);
    }
    //}//end while
    console.log(result);
    return result;
};

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function (head) {
    let str1 = "", str2 = "";
    while (head != null) {
        str1 = str1 + head.val;
        str2 = head.val + str2;
        head = head.next;
    }
    console.log(str1);
    console.log(str2);
    return str1 === str2;
};

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function (head) {
    if (head == null)
        return false;
    let fast = head;
    let slow = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow)
            return true;
    }
    return false;
};

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function (head) {
    //1.check if has cycle
    if (head == null)
        return null;
    let fast = head, slow = head, hasCycle = false;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
            hasCycle = true;
            break;
        }
    }
    if (!hasCycle)
        return null;
    fast = head;
    //2.find out the same value
    while (fast != slow) {
        fast = fast.next;
        slow = slow.next;
    }
    return fast;
};
