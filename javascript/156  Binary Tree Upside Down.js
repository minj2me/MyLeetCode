/**
 * lock by Leetcode
 * 156. Binary Tree Upside Down
 * https://www.lintcode.com/problem/binary-tree-upside-down/description
 * https://www.cnblogs.com/grandyang/p/5172838.html
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
 * Return the new root.

Example
Given a binary tree {1,2,3,4,5}

    1
   / \
  2   3
 / \
4   5
return the root of the binary tree {4,5,2,#,#,3,1}.

   4
  / \
 5   2
    / \
   3   1  
 */
/**
 * @param root: the root of binary tree
 * @return: new root
 */
const upsideDownBinaryTree = function (root) {
    // Recursion
    // if (root == null || root.left == null)
    //     return root;
    // let left = root.left;
    // let right = root.right;
    // let result = upsideDownBinaryTree(left);
    // left.left = right;
    // left.right = root;
    // root.left = null;
    // root.right = null;
    // return result;

    //iterative
    //从上往下开始翻转，直至翻转到最左子节点
    let cur = root, pre = null, next = null, temp = null;
    while (cur != null) {
        next = cur.left;
        cur.left = temp;
        temp = cur.right;
        cur.right = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}