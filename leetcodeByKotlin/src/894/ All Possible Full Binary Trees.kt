package LeetCode_894

/**
 * 894. All Possible Full Binary Trees
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 *
 * full binary tree is a binary tree where each node has exactly 0 or 2 children
 *
 * 一个深度为h,节点数个数为2^h-1的二叉树为满二叉树；
 * .节点为一定为奇数
 * .所有的节点是叶节点或度为2的节点
 * .每个二叉树的左右子树也是完全二叉树
 *
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun allPossibleFBT(N: Int): List<TreeNode?> {
        val result = ArrayList<TreeNode>()
        if (N == 1) {
            result.add(TreeNode(0))
        } else {
            for (i in 1 until N step 2) {
                //编历左右子树需要一个二重loop
                // N-1 这个偶数拆分成任意两个奇数之和
                val left = allPossibleFBT(i)
                val right = allPossibleFBT(N - i - 1)
                for (l in left) {
                    for (r in right) {
                        val cur = TreeNode(0)
                        cur.left = l
                        cur.right = r
                        result.add(cur)
                    }
                }
            }
        }
        return result
    }
}