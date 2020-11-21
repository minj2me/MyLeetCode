package LeetCode_230
import java.util.*
/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
Example 1:
Input: root = [3,1,4,null,2], k = 1
  3
 / \
1   4
 \
  2
Output: 1

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?

Constraints:
1. The number of elements of the BST is between 1 to 10^4.
2. You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * */
class TreeNode(var `val`: Int){
    var left: TreeNode?=null
    var right: TreeNode?=null
}
class Solution {
    /*
    * solution: traverse tree via inorder and check the index, because its sorted after inorder
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun kthSmallest(root_: TreeNode?, k: Int): Int {
        var root = root_
        val stack = Stack<TreeNode>()
        var count = 0
        //inorder to find result
        while (stack.isNotEmpty() || root!=null){
            if (root!=null){
                stack.push(root)
                root = root.left
            } else {
                root = stack.pop()
                count++
                if (count==k){
                    return root.`val`
                }
                root = root.right
            }
        }
        return 0
    }
}