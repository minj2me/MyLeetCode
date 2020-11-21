package LeetCode_297

import java.util.*

/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example:
You may serialize the following tree:
 1
/ \
2   3
/ \
4   5
as "[1,2,3,null,null,4,5]"
 * */

//Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Codec() {
    /*
    * solution:
    * 1. serialize: pre-order
    * 2. deserialize, dfs+queue
    * */
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val sb = StringBuilder()
        preorder(root, sb)
        return sb.toString()
    }

    private fun preorder(root: TreeNode?, sb: StringBuilder) {
        //preorder,root->left->right
        if (root == null) {
            sb.append("#").append(",")
            return
        }
        sb.append(root.`val`).append(",")
        preorder(root.left, sb)
        preorder(root.right, sb)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data == "") {
            return null
        }
        val queue = LinkedList<String>()
        queue.addAll(data.split(","))
        return buildTree(queue)
    }

    private fun buildTree(queue: LinkedList<String>): TreeNode? {
        val cur = queue.poll()
        if (cur == "#") {
            return null
        }
        val node = TreeNode(cur.toInt())
        node.left = buildTree(queue)
        node.right = buildTree(queue)
        return node
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var data = obj.encode(longUrl)
 * var ans = obj.decode(data)
 */