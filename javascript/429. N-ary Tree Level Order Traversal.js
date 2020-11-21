/**
 * 429. N-ary Tree Level Order Traversal
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 * 
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]
 */
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    let result = [];
    if (root == null) return result;
    let stack = [];
    stack.push(root);
    while (stack.length > 0) {
        let oneLevel = [];
        for (let i = stack.length; i > 0; i--) {
            let node = stack.shift();
            if (node.children != null) {
                for (let i = 0; i < node.children.length; i++)
                    stack.push(node.children[i]);
            }
            oneLevel.push(node.val);
        }
        result.push(oneLevel);
    }
    return result;
};