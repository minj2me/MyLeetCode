package LeetCode_508

/**
 * 508. Most Frequent Subtree Sum
   https://leetcode.com/problems/most-frequent-subtree-sum/
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
Examples 1
Input:
  5
/  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.

Examples 2
Input:
  5
/  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * */
class TreeNode(var `val`: Int){
    var left: TreeNode?=null
    var right: TreeNode?=null
}
class Solution {
    /*
    * solution: DFS + HashMap, dfs to get the sum of subtree, then use HashMap to mapping the sum and it's number of appearance,
    * Time:O(n), Space:O(n)
    * */
    val map = HashMap<Int,Int>()
    //most frequent of sum-tree sum
    var maxCount = 0
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        if (root == null){
            return intArrayOf()
        }
        getSum(root)
        val list = ArrayList<Int>()
        for (item in map){
            if (item.value == maxCount){
                list.add(item.key)
            }
        }
        return list.toIntArray()
    }

    private fun getSum(root:TreeNode?):Int{
        if (root == null){
            return 0
        }
        val sum = getSum(root.left) + getSum(root.right) + root.`val`
        //increasing frequency of this sum
        map.put(sum, map.getOrDefault(sum,0) + 1)
        //update the most frequency
        maxCount = Math.max(maxCount, map.get(sum)!!)
        return sum
    }
}