/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/description/
 * Input:
   1
 /   \
2     3
 \
  5
Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3

时间 O(h) or O(logh)?
空间 O(h) 递归栈空间

 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
    let result = [], path = "";
    //64 ms
    binaryTreePathsHelp(root, path, result);
    console.log(result);
};
//dfs
var binaryTreePathsHelp = function (node, path, result) {
    if (node == null)
        return;
    //recursive
    path = path + "->" + node.val;
    if (node.left == null && node.right == null) {
        result.push(path.substring(2));
        return;
    }
    if (node.right != null)
        binaryTreePathsHelp(node.right, path, result);
    if (node.left != null)
        binaryTreePathsHelp(node.left, path, result);

    //try Iterative
};