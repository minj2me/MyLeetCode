package LeetCode_654

/**
 * 654. Maximum Binary Tree
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
1. The root is the maximum number in the array.
2. The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
3. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:
  6
/  \
3    5
\  /
2 0
\
1
Note:
The size of the given array will be in the range [1,1000].
 * */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    /*
    * solution:recursion, find out the maximum element as a root, then create tree
    * Time: O(n^2), Space: O(n)
    * */
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return help(nums, 0, nums.size-1)
    }

    private fun help(nums: IntArray, left: Int, right: Int): TreeNode? {
        //if array is null
        if (left > right) {
            return null
        }
        //find out the index of maximum num in range left..right
        var mid = left
        for (i in left..right){
            if (nums[i] > nums[mid]){
                //update the index by the large number
                mid = i
            }
        }
        //create root by maximum num in range left..right
        val root = TreeNode(nums[mid])
        root.left = help(nums, left, mid-1)
        root.right = help(nums, mid+1, right)
        return root
    }
}