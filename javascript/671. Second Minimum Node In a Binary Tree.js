/**
 * 671. Second Minimum Node In a Binary Tree
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 * https://www.cnblogs.com/grandyang/p/7590156.html
 * 
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
 * then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
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
var findSecondMinimumValue = function (root) {
    if (root == null)
        return -1;
    let stack = [], set = new Set();
    let first = root.val, second = 1000000;
    //preorder, root->left->right
    while (root != null || stack.length > 0) {
        while (root != null) {
            stack.push(root);
            //set.add(root.val);
            if (root.val != first && root.val < second)
                second = root.val;
            root = root.left;
        }
        root = stack.pop();
        root = root.right;
    }
    return (second == first || second == 1000000) ? -1 : second;

    // if (set.size == 1)
    //     return -1;
    // else {
    //     let arr = [];
    //     for (let s of set) {
    //         arr.push(s);
    //     }
    //     arr.sort(function (a, b) { return a - b });
    //     console.log(arr[1]);
    //     return arr[1];
    // }
};