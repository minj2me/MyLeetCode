package LeetCode_549

/**
 * 549. Binary Tree Longest Consecutive Sequence II
 * (Locked by Leetcode)
 * https://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii/description
 *
Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
Especially, this path can be either increasing or decreasing.
For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

Example 1:
Input:
 1
/ \
2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].


Example 2:
Input:
2
/ \
1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Result {
    var node: TreeNode? = null
    var increasing = 0
    var decreasing = 0
}

class Solution {
    /**
     * solution:post-order, left->right->root, because can do it child-Parent-child
     * Time complexity: O(n^2), Space complexity:O(n)
     * */
    private var max: Int = 0

    fun longestConsecutive2(root: TreeNode?): Int {
        traverse(root)
        return max
    }

    fun traverse(node: TreeNode?): Result? {
        //do it post-order,left->right->root
        if (node == null) {
            return null
        }
        val left = traverse(node.left)
        val right = traverse(node.right)
        val cur = Result()
        cur.increasing = 1
        cur.decreasing = 1

        if (left != null) {
            if (node.`val` - left.node!!.`val` == 1) {
                cur.increasing = Math.max(cur.increasing, left.increasing + 1)
            } else if (node.`val` - left.node!!.`val` == -1) {
                cur.decreasing = Math.max(cur.decreasing, left.decreasing + 1)
            }
        }

        if (right != null) {
            if (node.`val` - right.node!!.`val` == 1) {
                cur.increasing = Math.max(cur.increasing, right.increasing + 1)
            } else if (node.`val` - right.node!!.`val` == -1) {
                cur.decreasing = Math.max(cur.decreasing, right.decreasing + 1)
            }
        }

        max = Math.max(max, cur.increasing + cur.decreasing - 1)

        return cur
    }
}