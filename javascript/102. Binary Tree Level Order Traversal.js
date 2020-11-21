/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    //bsf
    //56 ms
    let result = [];
    if (root == null) return result;
    let stack = [];
    stack.push(root);
    while (stack.length > 0) {
        let oneLevel = [];
        let size = stack.length;
        //console.log("size:"+size);
        for (let i = 0; i < size; i++) {
            let node = stack.shift();
            oneLevel.push(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        // /console.log(oneLevel);
        result.push(oneLevel);
    }
    //console.log(result);
    return result;
};