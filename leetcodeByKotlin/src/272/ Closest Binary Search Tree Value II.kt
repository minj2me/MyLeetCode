package LeetCode_272

import java.util.*
import kotlin.collections.ArrayList

/**
 * 272. Closest Binary Search Tree Value II
 * (Prime)
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Example:
Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
    4
   / \
  2   5
 / \
1   3
Output: [4,3]
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: use Stack to scan BST via in-order and compare the closest value,
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun closestKValues(root_: TreeNode?, target: Double, k: Int): List<Int> {
        //inorder
        val result = ArrayList<Int>(k)
        var root = root_
        val stack = Stack<TreeNode>()
        while (root != null || stack.isNotEmpty()) {
            if (root != null) {
                stack.add(root)
                root = root.left!!
            } else {
                root = stack.pop()
                //if result size less than k, just insert it
                if (result.size < k) {
                    result.add(root.`val`)
                } else if (Math.abs(target - root.`val`) < Math.abs(target - result.get(0))) {
                    //else if result size large than k
                    //need compare the diff_1 and diff_2:
                    //diff_1: the diff of target and current val;
                    //diff_2: the diff of target and the result head;
                    //if diff_1 < diff_2, just mean diff_1 was the closest, insert it and remove the head
                    result.remove(0)
                    result.add(root.`val`)
                }
                root = root.right!!
            }
        }
        return result
    }
}