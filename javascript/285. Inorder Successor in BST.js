/**
 * Lock by Leetcode
 * 285. Inorder Successor in BST
 * https://www.lintcode.com/problem/inorder-successor-in-bst/description
 * 
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

Challenge
O(h), where h is the height of the BST.
 */

/*
    * @param root: The root of the BST.
    * @param p: You need find the successor node of p.
    * @return: Successor of p.
    */
var inorderSuccessor = function (root, p) {
    let stack = [];
    //let lastNode=null;
    let appeared = false;
    //inorder 
    while (root != null || stack.length > 0) {
        if (root != null) {
            stack.push(root);
            root = root.left
        } else {
            root = stack.pop();
            //console.log(root.val);
            //arr.push(root.val);
            if (appeared)
                return root;
            if (p == root)//找到p了，下一个node就是要返回的 
                appeared = true;
            root = root.right;
        }
    }
    //console.log(arr);
    return null;
}