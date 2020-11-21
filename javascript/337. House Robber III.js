/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/description/
 * https://www.cnblogs.com/grandyang/p/5275096.html
 * https://www.programcreek.com/2015/03/leetcode-house-robber-iii-java/
 * 
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." 
 * Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var rob = function (root) {
    if (root == null)
        return 0;
    let result = helper(root);
    return Math.max(result[0], result[1]);
};

var helper = function (root) {
    let result = new Array(2).fill(0);
    if (root == null) {
        return result;
    }
    let left = helper(root.left);
    let right = helper(root.right);
    // result[0] is when root is selected, result[1] is when not. 
    result[0] = root.val + left[1] + right[1];
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return result;
}