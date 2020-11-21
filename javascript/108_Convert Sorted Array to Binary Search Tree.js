/**
 108. Convert Sorted Array to Binary Search Tree
 *https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 
 这道题是要将有序数组转为二叉搜索树，所谓二叉搜索树，是一种始终满足左<根<右的特性，
 如果将二叉搜索树按中序遍历的话，得到的就是一个有序数组了。
 那么反过来，我们可以得知，根节点应该是有序数组的中间点，从中间点分开为左右两个有序数组，
 在分别找出其中间点作为原中间点的左右两个子节点，这不就是是二分查找法的核心思想么。
 所以这道题考的就是二分查找法，
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function (nums) {
    if (nums == null || nums.length == 0)
        return null;
    return sortedArrayToBST_(nums, 0, nums.length - 1);
};

var sortedArrayToBST = function (nums, left, right) {
    if (left > right)
        return null;
    let mid = Math.floor((left + right) / 2);
    let node = new TreeNode(nums[mid]);
    //forexample [1,2,3]
    node.left = sortedArrayToBST_(nums, left, mid - 1);
    node.right = sortedArrayToBST_(nums, mid + 1, right);
    return node;
};

// var buildBST = function (root, node) {
//     if (node.val < root.val) {
//         if (root.left == null)
//             root.left = node;
//         else
//             buildBST(root.left, node);
//     } else if (node.val > root.val) {
//         if (root.right == null)
//             root.right = node;
//         else
//             buildBST(root.right, node);
//     }
//     //if equal, do nothing
// };