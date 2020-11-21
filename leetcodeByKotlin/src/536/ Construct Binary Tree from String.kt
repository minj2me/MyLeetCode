package LeetCode_536

import java.util.*

/**
 * 536. Construct Binary Tree from String
 * (Prime)
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree.
It contains an integer followed by zero, one or two pairs of parenthesis.
The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the left child node of the parent first if it exists.
Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:
     4
   /  \
  2    6
 / \  /
3  1 5
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".
 * */
class TreeNode(var value: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class Solution {
    /*
    * solution: Stack with pre-order (root->left->right) traversal,the top of stack should be current root
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun str2Tree(s: String): TreeNode?{
        if (s==null || s.isEmpty()){
            return null
        }
        val stack = Stack<TreeNode>()
        for (i in s.indices){
            val c = s[i]
            if (c in '0'..'9' || c=='-'){
                var start = i
                //keep to find out the whole digit number
                while (i+1<s.length && (s[i+1] in '0'..'9')){
                    start++
                }
                //create current node by get the number above
                val curValue = s.substring(start,i+1).toInt()
                val curNode = TreeNode(curValue)
                if (stack.isNotEmpty()){
                    //curNode is the child node of top node
                    val top = stack.peek()
                    if (top.left == null){
                        top.left = curNode
                    } else {
                        top.right = curNode
                    }
                }
                stack.push(curNode)
            } else if (c==')') {
                //mean current side had handle finish
                stack.pop()
            }
        }
        //print the result
        traversal(stack.peek())
        return stack.peek()
    }

    //print by pre-order
    private fun traversal(root: TreeNode?) {
        if (root == null) return
        print(root.value)
        print(",")
        traversal(root.left)
        traversal(root.right)
    }
}