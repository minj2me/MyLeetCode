/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is 
 * the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

我们转换一种角度来看，是不是其实就是根结点1的左右两个子树的深度之和再加1呢。那么我们只要对每一个结点求出其左右子树深度之和，再加上1就可以更新结果res了

 */
/**
 * @param {TreeNode} root
 * @return {number}
 * 
 * Time: O(root.node.count);
 * Space: O(high of tree);
 */
var diameterOfBinaryTree = function (root) {
    let arr = new Array(0);
    arr[0] = 0;
    maxDeepth(root, arr);
    return arr[0];
};

var maxDeepth = function (root, arr) {
    if (root == null)
        return 0;
    let leftDeepth = 0, rightDeepth = 0;
    if (root.left != null)
        leftDeepth += maxDeepth(root.left, arr);
    if (root.right != null)
        rightDeepth += maxDeepth(root.right, arr);
    arr[0] = Math.max(arr[0], leftDeepth + rightDeepth);
    console.log("arr[0]:" + arr[0]);
    return Math.max(leftDeepth, rightDeepth) + 1;
};