/**
 * 965. Univalued Binary Tree
 * https://leetcode.com/problems/univalued-binary-tree/description/
 * 
 * A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.
 */
/**
* @param {TreeNode} root
* @return {boolean}
*/
var isUnivalTree = function (root) {
    //inorder
    let stack = [];
    let lastValue = -1;
    while (stack.length > 0 || root != null) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            if (lastValue != -1) {
                if (lastValue != root.val)
                    return false;
            }
            lastValue = root.val;
            root = root.right;
        }
    }
    return true;
};