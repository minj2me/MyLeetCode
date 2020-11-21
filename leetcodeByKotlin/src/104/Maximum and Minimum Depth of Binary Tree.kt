package LeetCode_104

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        /*var leftDepth = 1
        var rightDepth = 1
        if (root.left != null) {
            leftDepth += maxDepth(root.left)
        }
        if (root.right != null) {
            rightDepth += maxDepth(root.right)
        }
        return Math.max(leftDepth, rightDepth)*/
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }

    fun maxDepth2(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var depth = 0
        //val stack = Stack<TreeNode>()
        //LinkedList实现了Queue接口，可以用作队列使用
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.size > 0) {
            depth++
            val size = queue.size
            for (i in size - 1 downTo 0) {
                val node = queue.poll()
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        println(depth)
        return depth
    }

    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var depth = 0
        //LinkedList实现了Queue接口，可以用作队列使用
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        while (queue.size > 0) {
            depth++
            val size = queue.size
            for (i in size - 1 downTo 0) {
                val node = queue.poll()
                //if found out the first leaf, return the depth
                //leaf is a node that with no children
                if (node.left == null && node.right == null) {
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
}