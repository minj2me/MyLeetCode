package `LeetCode_112`

import java.util.*

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
 * Given a binary tree and a sum,
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
5
/ \
4   8
/   / \
11  13  4
/  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * */
class Solution {
    /*
    * Time:O(n), Space:O(n)
    * */
    fun hasPathSum(root_: TreeNode?, sum: Int): Boolean {
        //recursive
        /*var sum_ = sum
        if (root == null)
            return false
        sum_ -= root.`val`
        if (root.left==null && root.right==null && sum_==0)
            return true
        else
            return hasPathSum(root.left,sum_) || hasPathSum(root.right,sum_)*/

        //traversal
        var root = root_
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (!stack.isEmpty()) {
            root = stack.pop()
            if (root == null) {
                continue
            }
            if (root.left == null && root.right == null) {
                //if is leaf
                if (root.`val` == sum) {
                    return true
                }
            }
            //child's val add up it parent's val
            if (root.left != null) {
                root!!.left!!.`val` += root.`val`
                stack.push(root.left)
            }
            if (root.right != null) {
                root!!.right!!.`val` += root.`val`
                stack.push(root.right)
            }
        }
        return false
    }

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}