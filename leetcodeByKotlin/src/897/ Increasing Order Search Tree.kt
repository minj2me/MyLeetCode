package `LeetCode_897`

import java.util.*

/**
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

5
/ \
3   6
/ \   \
2   4   8
/       / \
1       7  9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

1
\
2
\
3
\
4
\
5
\
6
\
7
\
8
\
9
 * */
class Solution {

    class TreeNode(var value_: Int = 0) {
        var left: TreeNode? = null;
        var right: TreeNode? = null
        var value = value_;
    }

    //fun increasingBST(root: TreeNode?): TreeNode? {
    fun increasingBST(): TreeNode? {
        var root = TreeNode(2);
        root.left = TreeNode(1);
        root.right = TreeNode(3);
        val stack = Stack<TreeNode>();
        //var node = root;
        //val valArray = IntArray(10);
        var valString = "";
        var index = 0;
        while (stack.isNotEmpty() || root.value != -1) {
            if (root.value != -1) {
                stack.push(root)
                //result = <表达式1> ?: <表达式2>
                //如果表达式1为null，则返回表达式2的内容，否则返回表达式1
                val leftNode = root.left;
                //println("leftNode:" + leftNode)
                if (leftNode != null)
                    root = leftNode
                else
                    root = TreeNode(-1)
            } else {
                root = stack.pop();
                valString += root.value.toString() + ","
                //valArray.set(index,root.value);
                index++;
                //val rightNode = root.right!!;
                val rightNode = root.right;
                //println("rightNode:" + rightNode)
                //root = rightNode!!;
                if (rightNode != null)
                    root = rightNode
                else
                    root = TreeNode(-1)
            }
        }
        valString = valString.substring(0,valString.length-1)
        val valArray = valString.split(",");
        val node = TreeNode(valArray[0].toInt());
        helper(valArray, node, 1);
        return node;
    }

    fun helper(valArray: List<String>, root: TreeNode, index: Int) {
        if (valArray.size==index)
            return
        val node = TreeNode(valArray[index].toInt())
        root.right = node
        helper(valArray, node, index+1)
    }
}