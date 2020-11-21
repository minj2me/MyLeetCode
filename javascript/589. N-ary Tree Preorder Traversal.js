/**
 * 589. N-ary Tree Preorder Traversal
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
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
 * @return {number[]}
 */
//preorder: root->left->right
var preorder = function (root) {
    if (root == null)
        return [];
    let stack = [], result = [];
    stack.push(root);
    while (stack.length > 0) {
        let cur = stack.pop();
        result.push(cur.val);
        if (cur.children != null) {
            for (let i = cur.children.length - 1; i >= 0; i--) {
                stack.push(cur.children[i]);
            }
        }
    }
    for (let i = 0; i < result.length / 2; i++) {
        let end = result.length - 1 - i;
        swap(result, i, end);
    }
    return result.reverse()
};

var swap = function (numArray, index1, index2) {
    let val1 = numArray[index1];
    let val2 = numArray[index2];
    numArray.splice(index1, 1, val2);
    numArray.splice(index2, 1, val1);
};