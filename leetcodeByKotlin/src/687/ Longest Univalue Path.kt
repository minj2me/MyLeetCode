package LeetCode_687

/**
 * 687. Longest Univalue Path(最长的相同值路经)
 * https://leetcode.com/problems/longest-univalue-path/description/
 * https://www.youtube.com/watch?v=yX1hVhcHcH8
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * Time:O(n), Space:O(n)
    * */
    var result = 0
    fun longestUnivaluePath(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        helper(root)
        return result
    }

    private fun helper(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        //求出单边的univaluePath
        val l = helper(root.left)
        val r = helper(root.right)
        var pl = 0
        var pr = 0
        if (root.left != null && root.`val` == root.left?.`val`) {
            pl = l + 1
        }
        if (root.right != null && root.`val` == root.right?.`val`) {
            pr = r + 1
        }
        result = Math.max(result, pl + pr)
        //返回单边最大的
        return Math.max(pl, pr)
    }
}