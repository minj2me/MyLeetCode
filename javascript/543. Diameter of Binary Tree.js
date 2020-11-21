/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 * https://www.cnblogs.com/grandyang/p/6607318.html
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

二叉树的直径，并告诉了我们直径就是两点之间的最远距离，根据题目中的例子也不难理解题意。
我们再来仔细观察例子中的那两个最长路径[4,2,1,3] 和 [5,2,1,3]，我们转换一种角度来看，
是不是其实就是根结点1的左右两个子树的深度之和再加1呢
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
var diameterOfBinaryTree = function (root) {
    let arr = new Array(0);
   arr[0]=0;
   maxDeepth(root,arr);
   return arr[0];
};

var maxDeepth = function (root,arr) {
   if (root == null)
       return 0;
   let leftDeepth = 0, rightDeepth = 0;
   if (root.left != null)
       leftDeepth += maxDeepth(root.left,arr);
   if (root.right != null)
       rightDeepth += maxDeepth(root.right,arr);
   arr[0] = Math.max(arr[0],leftDeepth+rightDeepth);
   console.log("arr[0]:"+arr[0]);
   return Math.max(leftDeepth,rightDeepth)+1;
};