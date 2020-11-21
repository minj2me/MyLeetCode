/**
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * 
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumOfLeftLeaves = function (root) {
    // if (root == null || root.left == null)
    //     return 0;
    // let res = 0;
    // let stack = [];
    // stack.push(root);
    // while (stack.length > 0) {
    //     let node = stack.pop();
    //     if (node.left != null && node.left.left == null && node.left.right == null) {
    //         console.log(node.left.val);
    //         res += node.left.val;
    //     }
    //     if (node.left != null) {
    //         stack.push(node.left);
    //     }
    //     if (node.right != null) {
    //         stack.push(node.right);
    //     }
    // }
    // console.log(res);
    // return res;
    if (root == null || (root.left == null && root.right==null))
        return 0;
    let res = new Array(1).fill(0);
    helper(root.left, true, res);
    helper(root.right, false, res);
    return res[0];
};
var helper = function (node, isLeft, res) {
    if (node == null)
        return;
    if (node.left == null && node.right == null && isLeft)
        res[0] += node.val;
    helper(node.left, true, res);
    helper(node.right, false, res);
};