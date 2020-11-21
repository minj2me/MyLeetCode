package LeetCode_1161

import java.util.*
import kotlin.collections.HashMap

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        var level = 0
        var max = 0
        val map = HashMap<Int, Int>()
        val stack = Stack<TreeNode>()
        stack.add(root)
        while (!stack.isEmpty()) {
            level++
            var oneLevelSum = 0
            val size = stack.size
            for (i in 0 until size) {
                val node = stack.get(0)
                stack.removeAt(0)
                oneLevelSum += node.`val`
                if (node.left != null) {
                    stack.add(node.left)
                }
                if (node.right != null) {
                    stack.add(node.right)
                }
            }
            map.put(oneLevelSum, level)
            max = Math.max(max, oneLevelSum)
        }
        for (key in map.keys) {
            if (key == max) {
                level = map.get(key)!!
                break
            }
        }
        return level
    }
}