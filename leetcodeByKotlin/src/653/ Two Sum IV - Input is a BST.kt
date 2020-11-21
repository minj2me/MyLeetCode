package LeetCode_653

/**
 * 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: in-order + TwoSum, Time complexity:O(n), Space complexity:O(n)
    * */
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val list = ArrayList<Int>()
        inOrder(root, list)
        //two sum, Time:O(n), Space:O(n)
        //key:num, value:index
        val map = HashMap<Int, Int>()
        for (i in list.indices) {
            val needToFind = k - list.get(i)
            if (map.contains(needToFind)) {
                return true
            }
            map.put(list[i], i)
        }
        return false
    }

    //save the sorted element in list, Time:O(n), Space:O(logn)
    private fun inOrder(root: TreeNode?, list: ArrayList<Int>) {
        if (root == null) {
            return
        }
        inOrder(root.left, list)
        list.add(root.`val`)
        inOrder(root.right, list)
    }
}