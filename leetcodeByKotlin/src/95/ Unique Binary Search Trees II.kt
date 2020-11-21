package LeetCode_95

/**
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * https://zxi.mytechroad.com/blog/uncategorized/leetcode-95-unique-binary-search-trees-ii/
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:
Input: 3
Output:
[
[1,null,3,2],
[3,2,null,1],
[3,1,null,null,2],
[2,1,3],
[1,null,2,null,3]
]
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: Recursion, Time complexity:O(3^n), Space complexity:O(3^n)
    * left sub tree can be generated in the same way for n_l = l..i-1
    * left sub tree can be generated in the same way for n_r = i+1..n
    * */

    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) {
            return ArrayList<TreeNode>()
        }
        return genTree(1, n)
    }

    private fun genTree(left: Int, right: Int): List<TreeNode?> {
        val result = ArrayList<TreeNode?>()
        if (left > right) {
            result.add(null)
            return result
        }
        for (i in left until right) {
            for (leftTree in genTree(left, i - 1)) {
                for (rightTree in genTree(i + 1, right)) {
                    val root = TreeNode(i)
                    root.left = leftTree
                    root.right = rightTree
                    result.add(root)
                }
            }
        }
        return result
    }
}