/**
 * 669. Trim a Binary Search Tree
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * 
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in 
 * [L, R] (R >= L). You might need to change the root of the tree, 
 * so the result should return the new root of the trimmed binary search tree.

Example 1:
Input: 
    1
   / \
  0   2

  L = 1
  R = 2

Output: 
    1
      \
       2
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
 * @param {number} L
 * @param {number} R
 * @return {TreeNode}
 * 
如果当前 root 不在范围内，比 L 小，那么 它和它的左子树 可以被抛弃了。
如果当前 root 不在范围内，比 R 大，那么 它和它的右子树 可以被抛弃了。
* 如果当前 root 正好在范围之内，那么把问题递归到它的左结点和右结点。
 */
var trimBST = function (root, L, R) {
    if (root == null)
        return root;
    if (root.val < L)
        return trimBST(root.right, L, R);
    if (root.val > R)
        return trimBST(root.left, L, R);
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
};