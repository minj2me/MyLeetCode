/**
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 * 
 * struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.

Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
 */

/**
* Definition for binary tree with next pointer.
* function TreeLinkNode(val) {
*     this.val = val;
*     this.left = this.right = this.next = null;
* }
*/

/**
 * @param {TreeLinkNode} root
 * @return {void} Do not return anything, modify tree in-place instead.
 */
var connect = function (root) {
    if (root == null)
        return;
    let stack = [];
    stack.push(root);
    while (stack.length > 0) {
        let size = stack.length;
        for (let i = 0; i < size; i++) {
            //shift:Removes the first element from an array and returns it.
            let node = stack.shift();
            if (i < size - 1)//还没到达最右边的
                node.next = stack[0];
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }
}