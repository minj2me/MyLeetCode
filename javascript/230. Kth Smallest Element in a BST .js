/**
 * 230. Kth Smallest Element in a BST
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
https://www.cnblogs.com/grandyang/p/4620012.html

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function (root, k) {
    //inorder, left->root->right, inorder will sort bst

    // let stack=[],arr=[];
    // while (root!=null || stack.length>0){
    //     if (root!=null){
    //         stack.push(root);
    //         root = root.left;
    //     } else {
    //         root = stack.pop();
    //         arr.push(root.val);
    //         root = root.right;
    //     }
    // }
    // return arr[k-1];

    let stack = [], count = 0;
    while (root != null || stack.length > 0) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            count++;
            if (k == count)
                return root.val;
            root = root.right;
        }
    }
    return 0;
};