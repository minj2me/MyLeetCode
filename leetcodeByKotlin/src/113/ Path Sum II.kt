package LeetCode_113

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/description/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
Note: A leaf is a node with no children.
Example:
Given the below binary tree and sum = 22,
5
/  \
4    8
/   /  \
11  13   4
/ \     / \
7 2    5   1

Return:
[
[5,4,11,2],
[5,8,4,5]
]
 * */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * Time:O(n), Space:O(n)
    * */
    val result = ArrayList<List<Int>>()
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        if (root == null) {
            return result
        }
        dfsWithList(root, ArrayList(), 0, sum)
        return result
    }

    private fun dfsWithList(root: TreeNode?, list: ArrayList<Int>, currentSum: Int, target: Int) {
        if (root == null) {
            return
        }
        list.add(root.`val`)
        if (root.left == null && root.right == null) {
            if (currentSum + root.`val` == target) {
                result.add(ArrayList<Int>(list))
            }
        }
        dfsWithList(root.left, list, currentSum + root.`val`, target)
        dfsWithList(root.right, list, currentSum + root.`val`, target)
        //because is backtracking, so need reset the list for next result
        list.removeAt(list.size - 1)
    }

    private fun dfs(root: TreeNode?, array: IntArray, pathLen_: Int, sum: Int) {
        if (root == null) {
            return
        }
        var pathLen = pathLen_
        array[pathLen] = root.`val`
        pathLen++
        if (root.left == null && root.right == null) {
            //if arrived the leaf node, check the sum
            var curSum = 0
            //because need clear array for each path after used, so new other one
            var tempArray = IntArray(pathLen)
            for (i in 0 until pathLen) {
                curSum += array[i]
                tempArray.set(i, array[i])
            }
            if (curSum == sum) {
                result.add(tempArray.toList())
            }
        } else {
            dfs(root.left, array, pathLen, sum)
            dfs(root.right, array, pathLen, sum)
        }
    }

    private fun getHeight(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1
    }
}