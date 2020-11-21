package LeetCode_1206

import java.util.*

/**
 * 1206. Design Skiplist
 * https://leetcode.com/problems/design-skiplist/
 * See more about Skiplist : https://en.wikipedia.org/wiki/Skip_list
 *
 * Design a Skiplist without using any built-in libraries.
A Skiplist is a data structure that takes O(log(n)) time to add, erase and search.
Comparing with treap and red-black tree which has the same function and performance,
the code length of Skiplist can be comparatively short and the idea behind Skiplists are just simple linked lists.
For example: we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it.
You can see there are many layers in the Skiplist. Each layer is a sorted linked list.
With the help of the top layers, add , erase and search can be faster than O(n).
It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).
To be specific, your design should include these functions:
1. bool search(int target) : Return whether the target exists in the Skiplist or not.
2. void add(int num): Insert a value into the SkipList.
3. bool erase(int num): Remove a value in the Skiplist.
If num does not exist in the Skiplist, do nothing and return false.
If there exists multiple num values, removing any one of them is fine.

Note that duplicates may exist in the Skiplist, your code needs to handle this situation.

Example:
Skiplist skiplist = new Skiplist();
skiplist.add(1);
skiplist.add(2);
skiplist.add(3);
skiplist.search(0);   // return false.
skiplist.add(4);
skiplist.search(1);   // return true.
skiplist.erase(0);    // return false, 0 is not in skiplist.
skiplist.erase(1);    // return true.
skiplist.search(1);   // return false, 1 has already been erased.

Constraints:
1. 0 <= num, target <= 20000
2. At most 50000 calls will be made to search, add, and erase.
 * */
class Node(var `val`: Int) {
    var right: Node? = null
    var down: Node? = null
}

class Skiplist() {
    /*
    * Skiplist is a data struct that supports the following operations:
    * 1. Add: O(logn) avg, O(n) worst case;
    * 2. Search: O(logn) avg, O(n) worst case;
    * 3. Delete: O(logn) avg, O(n) worst case;
    * Space complexity: O(logn) avg, O(n) worst case;
    *
    * Skiplist has multiple levels,
    * each levels is a Sorted Linked List with jump links from current level to the next
    * level of the elements with the same value.
    *
    * The last level has every elements, each level up contains a subset of the elements in the
    * below level.
    * */

    var head: Node? = null

    init {
        //Dummy head
        head = Node(-1)
    }

    /**
     * Search(T): start from the top-left head:
     * 1. find the greatest node N in current layer that has value <= T;
     * 2. if N.val == T: return true else go to next layer;
     * 3. repeat step 1,2 until current nodes become null;
     * */
    fun search(target: Int): Boolean {
        var node = head
        while (node != null) {
            //move to right in current level
            while (node!!.right != null && node.right!!.`val` < target) {
                node = node.right
            }
            if (node.right != null && node.right!!.`val` == target) {
                return true
            }
            //move to next level
            node = node.down
        }
        return false
    }

    /**
     * Add(T): start from the top-left head:
     * 1. for each level i, find and collect the largest node Ns, N.val < T;
     * 2. go to the next level;
     * 3. Repeat 1,2 until to the bottom;
     * 4. from the bottom to top, insert the element right after Ni with probability
     *  of 1/2:
     *  level 1: 1/2
     *  level d-2: 0.25
     *  level d-1: 0.5
     *  level d  : 1
     * 5. connect new elements between layers;
     *
     * Why 1/2?
     * Each level has half size of the next level, total space is n+n/2+n/4+... = 2n = O(n)
     * */
    fun add(num: Int) {
        val nodes = LinkedList<Node>()
        var node = head
        while (node != null) {
            //move to right in current level
            while (node!!.right != null && node.right!!.`val` < num) {
                node = node.right
            }
            nodes.offer(node)
            //move the next level
            node = node.down
        }
        var nodesCount = nodes.size
        var insert = true
        while (insert && nodes.isNotEmpty()) {
            node = nodes.pop()
            val newNode = Node(num)
            newNode.right = node.right
            newNode.down = null
            node.right = newNode
            nodesCount--
            insert = nodesCount!=0
        }
        /*
        * create a new level with dummy head
        * right = null
        * down = current head
        * */
        if (insert) {
            head = Node(-1)
            head!!.right = null
            head!!.down = head
        }
    }

    /**
     * erase(T): start from top-left head:
     * 1. find the greatest node N in current layer that has value < T;
     * 2. if N.next.val == T then N.next = N.next.next;
     * 3. go to the next layer;
     * 4. repeat steps 1-3 until current nodes becoms null;
     * */
    fun erase(num: Int): Boolean {
        var node = head
        var found = false
        while (node != null) {
            //move to right in current level
            while (node!!.right != null && node.right!!.`val` < num) {
                node = node.right
            }
            //find the target node
            if (node.right != null && node.right!!.`val` == num) {
                //delete node by skipping
                node.right = node.right!!.right
                found = true
            }
            //move to the next level
            node = node.down
        }
        return found
    }

}
/**
 * Your Skiplist object will be instantiated and called as such:
 * var obj = Skiplist()
 * var param_1 = obj.search(target)
 * obj.add(num)
 * var param_3 = obj.erase(num)
 */