package LeetCode_1022

import java.util.*

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
 * 参考十进制转二进制
 * https://baike.baidu.com/item/%E5%8D%81%E8%BF%9B%E5%88%B6%E8%BD%AC%E4%BA%8C%E8%BF%9B%E5%88%B6
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var result = 0
        val stack = Stack<TreeNode>()
        stack.push(root)
        while (stack.size > 0) {
            val node = stack.pop()
            if (node.left == null && node.right == null) {
                result += node.`val`
            }
            if (node.left != null) {
                node.left!!.`val` += (node.`val` shl 1)//左移n位==value*2的n次方
                stack.push(node.left)
            }
            if (node.right != null) {
                node.right!!.`val` += (node.`val` shl 1)//左移1位
                stack.push(node.right)
            }
        }
        return result
    }
}