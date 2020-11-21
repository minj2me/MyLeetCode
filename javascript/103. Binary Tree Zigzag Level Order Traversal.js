/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function (root) {
    //56 ms
    let stack = [], result = [];
    if (root == null) return result;
    stack.push(root);
    while (stack.length > 0) {
        let oneLevel = [];
        let size = stack.length;
        for (let i = 0; i < size; i++) {
            let node = null
            node = stack.shift();
            if (node != null) {
                oneLevel.push(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        //https://www.cnblogs.com/grandyang/p/4297009.html
        //其实每一层同样操作，然后在偶数层翻转一下
        if (result.length % 2 == 0) {
            oneLevel.reverse();
        }
        result.push(oneLevel);
    }
    return result;
};