/**
 * 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/description/
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function (root1, root2) {
    return getTreeLeaf(root1) == getTreeLeaf(root2);
};

var getTreeLeaf = function (root) {
    let stack = [], res = "";
    while (stack.length > 0 || root != null) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            if (root.left == null && root.right == null)
                res += root.val + ",";
            root = root.right;
        }
    }
    return res;
};