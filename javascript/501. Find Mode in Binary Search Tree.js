/**
 * 501. Find Mode in Binary Search Tree
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 * 
 * Given a binary search tree (BST) with duplicates, 
 * find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

For example:

Given BST [1,null,2,2],

   1
    \
     2
    /
   2
 

return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? 
(Assume that the implicit stack space incurred due to recursion does not count).
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
 * @return {number[]}
 */
var findMode = function (root) {
    if (root == null)
        return [];
    //follow up, without using extra space
    //let map = new Map();
    let stack = [];
    let result = [];
    let max = 0, lastVal = 0, preCount = 0;
    while (stack.length > 0 || root != null) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            let val = root.val;
            if (val == lastVal) {
                preCount++;
            } else
                preCount = 1;
            lastVal = val;
            if (preCount >= max) {
                if (preCount > max)
                    result = [];
                result.push(root.val);
                max = preCount;
            }
            /*if (map.get(val) == null)
                map.set(val, 1)
            else {
                let value = map.get(val);
                value++;
                map.set(val, value)
            }
            max = Math.max(max, map.get(val));*/
            root = root.right;
        }
    }//end while

    //follow up
    // for (let m of map) {
    //     if (m[1] == max)
    //         result.push(m[0]);
    // }
    return result;
};