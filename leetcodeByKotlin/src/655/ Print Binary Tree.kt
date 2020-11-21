package LeetCode_655

/**
 * 655. Print Binary Tree
 * https://leetcode.com/problems/print-binary-tree/description/
 * Example 1:
Input:
  1
 /
2
Output:
[["", "1", ""],
["2", "", ""]]
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution: recursion, Time:O(width * height), Space:O(width * height)
    * 1. get the height of tree, get width by height,
    * 2. recursion to fill array level by level
    * */
    fun printTree(root: TreeNode?): List<List<String>> {
        //get height and width
        val h = getHeight(root)
        //because the number of node in each level is: 2*h-1
        val w = (1 shl h) - 1//2^h-1, (2 power h) -1
        //print by h and w
        val result = ArrayList<ArrayList<String>>()
        //init and fill space in list
        for (i in 0 until h) {
            val list = ArrayList<String>()
            for (j in 0 until w) {
                list.add("")
            }
            result.add(list)
        }
        fill(root, result, 0, 0, w - 1)
        return result
    }

    private fun fill(node: TreeNode?, result: ArrayList<ArrayList<String>>, height: Int, l: Int, r: Int) {
        if (node == null) {
            return
        }
        val mid = (l + r) / 2
        result[height][mid] = node.`val`.toString()
        fill(node.left, result, height + 1, l, mid - 1)
        fill(node.right, result, height + 1, mid + 1, r)
    }

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1
    }
}