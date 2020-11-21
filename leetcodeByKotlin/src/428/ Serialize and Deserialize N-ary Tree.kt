package LeetCode_428

import java.util.*
import kotlin.collections.ArrayList

/**
 * 428. Serialize and Deserialize N-ary Tree
 * (Prime)
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize an N-ary tree.
An N-ary tree is a rooted tree in which each node has no more than N children.
There is no restriction on how your serialization/deserialization algorithm should work.
You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * */
class TreeNode(var `val`: Int) {
    var children: ArrayList<TreeNode?>? = null
}

class Codec {
    /*
       * solution:
       * 1. serialize: dfs + StringBuilder
       * 2. deserialize, dfs + queue
       * */
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val sb = StringBuilder()
        dfs(root, sb)
        return sb.toString()
    }

    private fun dfs(treeNode: TreeNode?, sb: StringBuilder) {
        if (treeNode == null) {
            sb.append("#").append(",")
            return
        }
        sb.append(treeNode.`val`).append(",").append(if (treeNode.children == null) 0 else treeNode.children!!.size)
        if (treeNode.children != null) {
            for (item in treeNode.children!!) {
                sb.append(",")
                dfs(item, sb)
            }
        }
    }

    fun deserialize(data: String): TreeNode? {
        if (data == "") {
            return null
        }
        val array = data.split(",")
        val queue = LinkedList<String>()
        queue.addAll(array)
        return buildTree(queue)
    }

    private fun buildTree(queue: LinkedList<String>): TreeNode? {
        val cur = queue.pop()
        if (cur == "#") {
            return null
        }
        //because append val then append size in dfs, so the first is val and the second is the size
        val node = TreeNode(cur.toInt())
        val size = queue.pop().toInt()
        node.children = ArrayList(size)
        for (i in 0 until size) {
            node.children?.add(buildTree(queue))
        }
        return node
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));