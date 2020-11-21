/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * 
 * 解释：https://www.cnblogs.com/grandyang/p/4280120.html
 * 
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, 
a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxPathSum = function (root) {
    //time: O(n), space: O(n)
    if (root == null)
        return 0;
    let res = new Array(0);
    res[0] = -10000;//let it most min
    helper(root, res);
    return res[0];
};

var helper = function (node, res) {
    if (node == null)
        return 0;
    //递归求左子树的最大
    let left = Math.max(0, helper(node.left, res));
    //递归求右子树的最大
    let right = Math.max(0, helper(node.right, res));
    //这次中最大可能值
    let sum = left + right + node.val;
    //更新res
    res[0] = Math.max(res[0], sum);
    //返回单边最大的, left or right
    return Math.max(left, right) + node.val;
};