package `133`

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/description/
 * */

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class Solution {
    //bfs+hashmap
    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return node
        }
        val queue = LinkedList<Node>()
        queue.offer(node)
        val clone = Node(node.`val`)
        val map = HashMap<Node, Node>()
        map.put(node, clone)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            for (neighbor in cur.neighbors) {
                if (!map.contains(neighbor)) {
                    map.put(neighbor!!, Node(neighbor.`val`))
                    queue.offer(neighbor)
                }
                //然后将 neighbor 结点在 HashMap 中的映射结点加入到克隆结点的 neighbors 数组中
                map.get(cur)?.neighbors?.add(map.get(neighbor))
            }
        }
        return clone
    }
}