/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * @param {TreeNode} root
 * @return {number[]}
 * Preorder: 根-左-右
 */
var preorderTraversal = function (root) {
    //52 ms
    let stack = [], result = [];
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            result.push(root.val);//save root first
            root = root.left;//push left node
        }
        root = stack.pop();
        root = root.right;
    }
    return result;
};