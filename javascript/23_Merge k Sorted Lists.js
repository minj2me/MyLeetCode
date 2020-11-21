/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * https://www.cnblogs.com/grandyang/p/4606710.html
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function (lists) {
    //496ms
    let len = lists.length;
    if (len == 0)
        return null;
    if (len == 1)
        return lists[0];
    let result = {};
    for (let i = 0; i < lists.length; i++) {
        if (i == 0) {
            let l1 = lists[i];
            let l2 = lists[i + 1];
            result = mergeKListsHelp(l1, l2, null);
        } else if (i > 1) {
            result = mergeKListsHelp(result, lists[i], null);
        }
    }
    return result;
};

var mergeKListsHelp = function (l1, l2, result) {
    if (l1 == null)
        return l2;
    if (l2 == null)
        return l1;
    if (l1.val < l2.val) {
        if (result == null) {
            result = l1;
            result.next = mergeTwoSortedLists(l1.next, l2);
        } else {
            result.next = l1;
            result.next.next = mergeTwoSortedLists(l1.next, l2);
        }
    } else {
        if (result == null) {
            result = l2;
            result.next = mergeTwoSortedLists(l2.next, l1);
        } else {
            result.next = l2;
            result.next.next = mergeTwoSortedLists(l2.next, l1);
        }
    }
    return result;
};

var mergeTwoSortedLists = function (l1, l2) {
    //console.log("aa");
    // console.log(l2);
    if (l1 == null)
        return l2;
    if (l2 == null)
        return l1;
    let result = {};
    if (l1.val < l2.val) {
        result = l1;
        result.next = mergeTwoSortedLists(l1.next, l2);
    } else {
        result = l2;
        result.next = mergeTwoSortedLists(l2.next, l1);
    }
    //console.log(result);
    return result;
};