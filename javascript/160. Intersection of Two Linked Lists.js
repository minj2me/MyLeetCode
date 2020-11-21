/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * https://www.cnblogs.com/grandyang/p/4128461.html
 */
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 * 
 * 具体算法为：分别遍历两个链表，得到分别对应的长度。
 * 然后求长度的差值，把较长的那个链表向后移动这个差值的个数，然后一一比较即可
 */
var getIntersectionNode = function (headA, headB) {
    if (headA == null || headB == null)
        return null;
    let lenA = getLen(headA);
    let lenB = getLen(headB);
    if (lenA > lenB) {
        for (let i = 0; i < (lenA - lenB); i++) {
            headA = headA.next;
        }
    } else {
        for (let i = 0; i < (lenB - lenA); i++) {
            headB = headB.next;
        }
    }
    while (headA != null && headB != null && headA != headB) {
        //scan untill found out the same
        headA = headA.next;
        headB = headB.next;
    }
    return (headA != null && headB != null) ? headA : null;
};

var getLen = function (head) {
    let len = 0;
    while (head != null) {
        len++;
        head = head.next;
    }
    return len;
}