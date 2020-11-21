/**
 * 654. Maximum Binary Tree
 * https://leetcode.com/problems/maximum-binary-tree/description/
 * https://www.cnblogs.com/grandyang/p/7513099.html
 * 
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var constructMaximumBinaryTree = function (nums) {
    let left = 0, right = nums.length - 1;
    btHelper(nums, left, right);
};
var btHelper = function (nums, left, right) {
    if (left > right)
        return 0;
    let mid = left;
    //find out the large one for node'val
    for (let i = left; i <= right; i++) {
        if (nums[i] > nums[mid])
            mid = i;
    }
    let node = new TreeNode(nums[mid]);
    node.left = btHelper(nums, left, mid - 1);
    node.right = btHelper(nums, rgiht, mid + 1);
    return node;
}