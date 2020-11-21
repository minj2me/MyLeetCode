/**
 * 515. Find Largest Value in Each Tree Row
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * 
 * You need to find the largest value in each row of a binary tree.

Example:
Input: 
          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function (root) {
    if (root == null)
        return [];
    let stack = [], res = [], max = -Math.pow(2, 31);
    stack.push(root);
    while (stack.length > 0) {
        let size = stack.length;
        max = -Math.pow(2, 31);
        for (let i = 0; i < size; i++) {
            let node = stack.shift();
            max = Math.max(max, node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        res.push(max);
    }
    return res;
};