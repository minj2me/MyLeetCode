package LeetCode_606

import LeetCode_1382.TreeNode

/**
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
The null node needs to be represented by empty parenthesis pair "()".
And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship
between the string and the original binary tree.
Example 1:
Input: Binary tree: [1,2,3,4]
     1
   /   \
  2     3
 /
4
Output: "1(2(4))(3)"
Explanation: Originallay it needs to be "1(2(4)())(3()())",
but you need to omit all the unnecessary empty parenthesis pairs.
And it will be "1(2(4))(3)".
 * */
class Solution {
    /*
    * Time complexity:O(n), Space complexity:O(logn)
    * */
    fun tree2str(t: TreeNode?): String {
        if (t == null) {
            return ""
        }
        //pre-order mode: root->left->right
        val s = t.`val`.toString()
        val l = tree2str(t.left)
        val r = tree2str(t.right)

        if (t.left == null && t.right == null) {
            return s
        }
        if (t.right == null) {
            return s + "($l)"
        }
        return s + "($l)($r)"
    }
}