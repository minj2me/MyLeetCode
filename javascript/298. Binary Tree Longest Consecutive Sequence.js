/**
 * Leetcode is lock.
 * 
 * https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence/description
 * 
 * https://www.cnblogs.com/grandyang/p/5252599.html
 * 
 * Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

Example
For example,

   1
    \
     3
    / \
   2   4
        \
         5

Longest consecutive sequence path is 3-4-5, so return 3.
 */

/**
* @param root: the root of binary tree
* @return: the length of the longest consecutive sequence path

https://www.cnblogs.com/grandyang/p/5252599.html

用的还是DFS的思想，以层序来遍历树，对于遍历到的节点，我们看其左右子节点有没有满足题意的，如果左子节点比其父节点大1，
 * 若右子节点存在，则排入queue，指针移到左子节点，
 * 反之若右子节点比其父节点大1，若左子节点存在，则排入queue，指针移到右子节点，依次类推直到queue为空
*/
var longestConsecutive = function (root) {
    if (root == null)
        return 0;
    let stack = [];
    let max = 0;
    stack.push(root);
    while (stack.length > 0) {
        let len = 1;
        //console.log("root.val:"+root.val);
        let node = stack.pop();
        while ((node.left != null && node.left.val == node.val + 1) ||
            (node.right != null && node.right.val == node.val + 1)) {
            if (node.left != null && node.left.val == node.val + 1) {
                if (node.right != null)
                    stack.push(node.right);
                node = node.left;
            } else if (node.right != null && node.right.val == node.val + 1) {
                if (node.left != null)
                    stack.push(node.left);
                node = node.right;
            }
            len++;
        }
        if (node.left != null)
            stack.push(node.left);
        if (node.right != null)
            stack.push(node.right);
        max = Math.max(max, len);
    }
    return max;
}