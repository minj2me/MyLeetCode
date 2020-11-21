/**
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */

var currentNode=null;

var sortedListToBST = function (head) {
    if (head == null)
        return null;
    ///////////////////solusion 1
    //runtime: 76 ms
    //1.changed into array 
    //2.do it via array 
    // let arr = listNodeToArray(head);
    // return sortedArrayToBST(arr);
    ///////////end solution 1

    //////////////////solution 2
    //Runtime: 76 ms
    //1. calculate the len of the linkedlink
    let node = head, len = 0;
    while (node != null) {
        len++;
        node = node.next;
    }
    currentNode = head;
    return help(0, len-1);
};

var listNodeToArray = function (root) {
    let arr = [];
    while (root) {
        arr.push(root.val);
        root = root.next;
    }
    return arr;
};

var sortedArrayToBST = function (nums) {
    if (nums == null || nums.length == 0)
        return null;
    return sortedArrayToBST_(nums, 0, nums.length - 1);
};

var sortedArrayToBST_ = function (nums, left, right) {
    if (left > right)
        return null;
    let mid = Math.floor((left + right) / 2);
    let node = new TreeNode(nums[mid]);
    node.left = sortedArrayToBST_(nums, left, mid - 1);
    node.right = sortedArrayToBST_(nums, mid + 1, right);
    return node;
};

///solution 2
var help = function (left, right, root) {
    if (left > right)
        return null;
    let mid = Math.floor((left + right) / 2);
    let leftNode = help(left, mid - 1);
    if (currentNode==null) return null;
    let curr = new TreeNode(currentNode.val);
    currentNode = currentNode.next;
    let rightNode = help(mid + 1, right);
    curr.left = leftNode;
    curr.right = rightNode;
    return curr;
};