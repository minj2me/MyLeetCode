/**
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * 
 * Given a Binary Search Tree and a target number, 
 * return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
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
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function (root, k) {
    if (root == null)
        return false;
    let array = [];
    let stack = [];
    //inorder
    while (stack.length > 0 || root != null) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            array.push(root.val);
            root = root.right;
        }
    }
    //two sum
    let map = new Map();
    for (let i = 0; i < array.length; i++) {
        let target = k - array[i];
        if (map.has(target))
            return true;
        map.set(array[i], i);
    }
    return false;
};