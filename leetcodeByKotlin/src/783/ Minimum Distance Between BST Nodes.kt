package LeetCode_783

import java.util.*

class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun minDiffInBST(root_: TreeNode?): Int {
        var root = root_
        val stack = Stack<TreeNode>()
        var lastVal = -1
        var diff = Int.MAX_VALUE
        //inorder
        while (stack.size > 0 || root != null) {
            if (root != null) {
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                if (lastVal != -1) {
                    //当lastVal付了root.val后
                    diff = Math.min(diff, root.`val` - lastVal)
                }
                lastVal = root.`val`
                root = root.right
            }
        }
        return diff
    }
}
