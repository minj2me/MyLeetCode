/**
 * 99. Recover Binary Search Tree
https://leetcode.com/problems/recover-binary-search-tree/description/

https://www.cnblogs.com/grandyang/p/4298069.html

 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
 */

/**
* @param {TreeNode} root
* @return {void} Do not return anything, modify root in-place instead.
* Time: O(n)
* 用中序遍历树，并将所有节点存到一个array，把所有节点值存到另一个array，
* 然后对存节点值的一维向量排序，在将排好的数组按顺序赋给节点
*/
var recoverTree = function (root) {
    let arrayForNode = [], arrayForValue = [];
    inorder(root, arrayForNode, arrayForValue);
    arrayForValue.sort(function (a, b) { return a - b });
    //console.log(arrayForValue);
    for (let i = 0; i < arrayForNode.length; i++)
        arrayForNode[i].val = arrayForValue[i];
    //console.log(arrayForNode);
    //return arrayForNode;
};

var inorder = function (root, arrayForNode, arrayForValue) {
    let helper = [];
    while (root != null || helper.length > 0) {
        if (root != null) {
            helper.push(root);
            root = root.left;
        } else {
            root = helper.pop();
            arrayForNode.push(root);
            arrayForValue.push(root.val);
            root = root.right;
        }
    }
};