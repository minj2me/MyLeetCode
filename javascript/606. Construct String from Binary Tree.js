/**
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 * https://www.cnblogs.com/grandyang/p/7000040.html
 * 
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". 
And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string 
and the original binary tree.

Example 1:
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} t
 * @return {string}
 */
var tree2str = function (root) {
    let res = new Array(1).fill("");
    helper(root, res);
    let result = res[0].substr(1, res[0].length);
    result = result.substr(0, result.length - 1);
    return result;
};
var helper = function (root, res) {
    if (root == null)
        return;
    res[0] += "(" + root.val;
    if (root.left == null && root.right != null)
        res[0] += "()";
    helper(root.left, res);
    helper(root.right, res);
    res[0] += ")";
};