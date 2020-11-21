/**
 * 98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/description/
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
 * @return {boolean}
 */
var isValidBST = function (root) {
    if (root == null) return true;
    let array = [];
    addInArrayByInOrder(root, array);
    //console.log(array);
    let len = array.length;
    for (let i = 0; i < len - 1; i++) {
        if (array[i] >= array[i + 1])
            return false;
    }
    return true;
};

/**
add tree's every element into array by InOrder
*/
var addInArrayByInOrder = function (node, arr) {
    if (node.left != null)
        addInArrayByInOrder(node.left, arr)
    if (node != null)
        arr.push(node.val);
    if (node.right != null)
        addInArrayByInOrder(node.right, arr)
}