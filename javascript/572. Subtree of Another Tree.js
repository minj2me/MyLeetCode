/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * https://www.cnblogs.com/Dylan-Java-NYC/p/7060009.html
 * 
 * Given two non-empty binary trees s and t, 
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 *  A subtree of s is a tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.
 * 
 * 
Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} s
 * @param {TreeNode} t
 * @return {boolean}
 */
var isSubtree = function (s, t) {
    // console.log(inOrderToStr(s));
    // console.log(inOrderToStr(t));
    let sStr = preOrderToStr(s);
    let tStr = preOrderToStr(t);
    //  console.log(sStr);
    // console.log(tStr);
    //  console.log(sStr.indexOf(tStr));
    // console.log(tStr.indexOf(sStr));
    return sStr.indexOf(tStr) >= 0;
};

//根-左-右
var preOrderToStr = function (root) {
    if (root == null)
        return "";
    let stack = [];
    let str = "";
    while (root != null || stack.length > 0) {
        while (root != null) {
            stack.push(root);
            str += "," + root.val
            root = root.left;
        }
        root = stack.pop();
        root = root.right;
        if (root == null)
            str += ",#";
    }
    return str;
}