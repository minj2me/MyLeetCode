package LeetCode_257

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 * Given a binary tree, return all root-to-leaf paths.
Note: A leaf is a node with no children.
Example:
Input:
   1
  / \
 2   3
  \
   5
Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * */
class TreeNode(var `val`:Int){
    var left:TreeNode?=null
    var right:TreeNode?=null
}
class Solution {
    /*
    * solution: recursion, Time complexity:O(n), Space complexity:O(n)
    * */
    private val list = ArrayList<String>()

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val path = ""
        help(root, list, path)
        return list
    }

    private fun help(root: TreeNode?, list:ArrayList<String>, path_: String){
        if (root == null){
            return
        }
        val path = "$path_->${root.`val`}"
        if (root.left == null && root.right == null){
            //is leaf,add path without "->" in head of path
            //for example: path:->1->2->5, just insert 1->2->5 into list
            list.add(path.substring(2))
            return
        }
        if (root.left != null){
            help(root.left, list, path)
        }
        if (root.right != null){
            help(root.right, list, path)
        }
    }
}