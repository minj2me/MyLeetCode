/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    //console.log("aa");
    // console.log(l2);
   if (l1 == null)
        return l2;
    if (l2 == null)
        return l1;
     let result={};
   if (l1.val < l2.val) {
      result = l1;
      result.next = mergeTwoLists(l1.next, l2);
    } else {
      result = l2;
      result.next = mergeTwoLists(l2.next, l1);
    }
    console.log(result);
    return result;
};