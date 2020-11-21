package LeetCode_663

import LeetCode_814.TreeNode
import java.util.*

/**
 * 663. Equal Tree Partition
 * (Prime)
 * https://www.lintcode.com/problem/equal-tree-partition/description
 *
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.

Example 1:
Input:
5
/ \
10 10
/  \
2   3
Output: True

Explanation:
5
/
10
Sum: 15

10
/  \
2    3
Sum: 15
 * */
class Solution {
    /*
    * solution: recursion,
    * use HashSet to record the sum of every subtree
    * Time complexity:O(n), Space complexity:O(n)
    * */

    //private val stack = Stack<Int>()

    fun checkEqualTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        /*val sum = sum(root)
        val total = stack.pop()
        if (total % 2 == 0) {
            for (item in stack) {
                if (item == total / 2) {
                    return true
                }
            }
        }*/
        val set = HashSet<Int>()
        val sum = sum(root.left, set) + sum(root.right, set) + root.`val`
        return sum % 2 == 0 && set.contains(sum / 2)
    }

    private fun sum(root: TreeNode?, set: HashSet<Int>): Int {
        if (root == null) {
            return 0
        }
        //val sum = sum(root.left) + sum(root.right) + root.`val`
        //stack.push(sum)
        //return stack.peek()
        val sum = sum(root.left, set) + sum(root.right, set) + root.`val`
        set.add(sum)
        return sum
    }
}