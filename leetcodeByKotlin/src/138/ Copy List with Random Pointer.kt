package LeetCode_138

/**
 * 138. Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 * */

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    /*
    * solution 1:HashMap, Time complexity:O(n), Space complexity:O(n)
    * */
    fun copyRandomList(node: Node?): Node? {
        val map = HashMap<Node, Node>()
        //handle node copy
        var cur = node
        while (cur != null) {
            map.put(cur, Node(cur.`val`))
            cur = cur.next
        }
        //handler node's next and random
        var curNode = node
        while (curNode != null) {
            map.get(curNode)?.next = map.get(curNode.next!!)
            map.get(curNode)?.random = map.get(curNode.random!!)
            curNode = curNode.next
        }
        return map.get(node!!)
    }
}