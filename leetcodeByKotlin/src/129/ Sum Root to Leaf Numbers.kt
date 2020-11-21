package LeetCode_129

import java.util.*

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
1
/ \
2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
 * */
//如何打印root到leaf的path?!!
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sumNumbers(root_: TreeNode?): Int {
        if (root_ == null) {
            return 0
        }
        var result = 0
        var root = root_
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            root = stack.pop()
            if (root.left == null && root.right == null) {
                result += root.`val`
            }
            if (root.left != null) {
                root.left!!.`val` += root.`val` * 10
                stack.push(root.left)
            }
            if (root.right != null) {
                root.right!!.`val` += root.`val` * 10
                stack.push(root.right)
            }
        }
        return result
    }
}