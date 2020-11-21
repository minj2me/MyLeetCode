/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
 * 
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
 * @return {TreeNode}
 */
var invertTree = function (root) {
    let stack = [];
    stack.push(root);
    while (stack.length > 0) {
        let node = stack.shift();
        let temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null)
            stack.push(node.left);
        if (node.right != null)
            stack.push(node.right);
    }
}