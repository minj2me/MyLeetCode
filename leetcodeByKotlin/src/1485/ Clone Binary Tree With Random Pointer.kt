package LeetCode_1485

/**
 * 1485. Clone Binary Tree With Random Pointer
 * (Prime)
 * A binary tree is given such that each node contains an additional random pointer which could point to any node in the tree or null.
Return a deep copy of the tree.
The tree is represented in the same input/output way as normal binary trees where each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point to any node.
You will be given the tree in class Node and you should return the cloned tree in class NodeCopy.
NodeCopy class is just a clone of Node class with the same attributes and constructors.
 * */
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var random: Node? = null
}

class Solution {
    /*
    * solution: DFS, Time complexity:O(n), Space complexity:O(n)
    * */

    val map = HashMap<Node, Node>()

    fun copyRandomBinaryTree(root: Node?): Node? {
        if (root == null) {
            return null
        }
        return copy(root)
    }

    private fun copy(root: Node?): Node? {
        if (root == null) {
            return null
        }
        if (map.containsKey(root)) {
            return map.get(root)
        }
        val copyNode = Node(root.`val`)
        map.put(root, copyNode)
        copyNode.left = copy(root.left)
        copyNode.right = copy(root.right)
        copyNode.random = copy(root.random)
        return copyNode
    }
}