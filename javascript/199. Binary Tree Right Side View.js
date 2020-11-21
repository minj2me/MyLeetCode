
/**
 * 199. Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
这道题要求我们打印出二叉树每一行最右边的一个数字，实际上是求二叉树层序遍历的一种变形，我们只需要保存每一层最右边的数字即可
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function (root) {
    let stack = [], result = [];
    if (root == null) return result;
    stack.push(root);
    while (stack.length > 0) {
        //遍历每层的节点时，把下一层的节点都存入到stack中，每当开始新一层节点的遍历之前，先把新一层最后一个节点值存到结果中
        let size = stack.length;
        result.push(stack[size - 1].val);
        for (let i = 0; i < size; i++) {
            let node = stack.shift();
            // last one is the right most, because add right after left by below code
            if (i == size - 1)
                result.push(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }
    return result;
};
