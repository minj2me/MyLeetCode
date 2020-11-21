package LeetCode_863

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 863. All Nodes Distance K in Binary Tree
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.The answer can be returned in any order.

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
Output: [7,4,1]
Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note:
1.The given tree is non-empty.
2.Each node in the tree has unique values 0 <= node.val <= 500.
3.The target node is a node in the tree.
4.0 <= K <= 1000.
 * */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: DFS+BFS, Time complexity:O(n), Space complexity:O(n);
    * build the undirected graph by DFS , and BFS to find out all the node that are exact K step from target
    * */
    val graph = HashMap<TreeNode, ArrayList<TreeNode>>()

    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        //dfs to create graph
        buildGraph(null, root)

        val result = ArrayList<Int>()
        val visited = HashSet<Int>()
        var level = 0
        val queue = LinkedList<TreeNode>()
        //start from target
        queue.offer(target)
        visited.add(target!!.`val`)
        while (queue.isNotEmpty() && level <= K) {
            val size = queue.size
            for (i in 0 until size) {
                //check each node
                val node = queue.poll()
                if (level == K) {
                    result.add(node.`val`)
                }
                val list = graph.get(node)
                if (list != null) {
                    for (n in list) {
                        //because has unique values
                        if (visited.contains(n.`val`)) {
                            continue
                        }
                        visited.add(n.`val`)
                        queue.offer(n)
                    }
                }
            }
            level++
        }
        return result
    }

    /**
     * Create an Adjacency List that know which node are relate to whom
     * */
    private fun buildGraph(parent: TreeNode?, child: TreeNode?) {
        if (parent != null) {
            if (!graph.containsKey(parent)) {
                graph.put(parent, ArrayList())
            }
            if (child != null) {
                graph.get(parent)?.add(child)
            }
        }
        if (child != null) {
            if (!graph.containsKey(child)) {
                graph.put(child, ArrayList())
            }
            if (parent != null) {
                graph.get(child)?.add(parent)
            }
            if (child.left != null) {
                buildGraph(child, child.left)
            }
            if (child.right != null) {
                buildGraph(child, child.right)
            }
        }
    }
}