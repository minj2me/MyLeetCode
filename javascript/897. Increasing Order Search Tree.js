/**
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 * 
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only 1 right child.
 * 
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
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
 * @return {TreeNode}
 */
var increasingBST = function (root) {
    let stack = [], array = [];
    //inorder
    while (root != null || stack.length > 0) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            array.push(root.val);
            root = root.right;
        }
    }
    let node = new TreeNode(array[0]);
    arrayToTree(node, array, 1);
    return node;
};

var arrayToTree = function (root, array, index) {
    if (array.length == index)
        return;
    let node = new TreeNode(array[index]);
    root.right = node;
    arrayToTree(node, array, index + 1);
}