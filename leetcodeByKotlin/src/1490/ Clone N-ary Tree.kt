package LeetCode_1490

/**
 * 1490. Clone N-ary Tree
 * (Prime)
 * Given a root of an N-ary tree, return a deep copy (clone) of the tree.
Each node in the n-ary tree contains a val (int) and a list (List[Node]) of its children.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
Follow up: Can your solution work for the graph problem?
 * */
class Node(var `val`: Int) {
    var children: List<Node>? = null
}

class Solution {
    fun cloneTree(root: Node?): Node? {
        if (root == null) {
            return null
        }
        val copy = Node(root.`val`)
        val children = ArrayList<Node>()
        for (child in root.children!!) {
            val childClone = cloneTree(child)
            if (childClone != null) {
                children.add(childClone)
            }
        }
        copy.children = children
        return copy
    }
}