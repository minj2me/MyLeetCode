/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/
 * 
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function (p, q) {
    if (q == null && p == null)
        return true;
    // if (q != null && p == null || q == null && p != null)
    //     return false;
    // if (q.val != p.val)
    //     return false;
    // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    let str1 = inOrderToStr(p);
    let str2 = inOrderToStr(q);
    return str1==str2;
};

var inOrderToStr = function (root) {
    if (root==null)
        return "";
    let stack=[];
    let str="";
    while (root!=null || stack.length>0){
        if (root!=null){
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            str+=root.val;
            root = root.right;
            //console.log(root);
            //distinguish 1,2 and 1,null,2
            if (root==null)
               str+="#";
        }
    }
    return str;
}