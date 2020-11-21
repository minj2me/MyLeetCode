package LeetCode_993

/**
 * 993. Cousins in Binary Tree
 * https://leetcode.com/problems/cousins-in-binary-tree/description/
 * two nodes in the binary tree are the cousins if they have same depth,but have different parents.
 */

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean? {
        //if have same depth and is not sibling, they are cousins
        return getDepth(root, x) == getDepth(root, y) && !isSibling(root, x, y)
    }

    fun getDepth(root: TreeNode?, value: Int): Int {
        val queue = LinkedList<TreeNode>()
        var depth = 0
        queue.offer(root)
        while (queue.size > 0) {
            depth++
            val size = queue.size
            for (i in size - 1 downTo 0) {
                val node = queue.poll()
                if (node.`val` == value) {
                    return depth
                }
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        return -1
    }

    /**
     * 判断x和y在root中是否为兄弟
     * */
    fun isSibling(root: TreeNode?, x: Int, y: Int): Boolean {
        val queue = LinkedList<TreeNode>()
        var depth = 0
        queue.offer(root)
        while (queue.size > 0) {
            depth++
            val size = queue.size
            for (i in size - 1 downTo 0) {
                val node = queue.poll()
                if (node.left != null && node.right != null) {
                    if (node.left!!.`val` == x && node.right!!.`val` == y ||
                        node.right!!.`val` == x && node.left!!.`val` == y
                    ) {
                        return true
                    }
                }
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        return false
    }
}