/**
 * 450. Delete Node in a BST
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 * https://www.cnblogs.com/grandyang/p/6228252.html
 * 
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:
1.Search for a node to remove.
2.If the node is found, delete the node.
Note: Time complexity should be O(height of tree).
 */
/**
 * @param {TreeNode} root
 * @param {number} key
 * @return {TreeNode}
 */
var deleteNode = function (root, key) {
    // let stack = [], map = new Map();
    // while (root != null || stack.length > 0) {
    //     if (root != null) {
    //         stack.push(root);
    //         root = root.left;
    //     } else {
    //         root = stack.pop();
    //         //arr.push(root.val);
    //         map.set(root.val, root.val);
    //         root = root.right;
    //     }
    // }
    // map.delete(key);
    // let arr = [];
    // for (let m of map) {
    //     arr.push(m[0]);
    // }
    // return bstHelp(arr,0,arr.length)

    //solution 2
    if (root.val == key) {
        if (root.right == null)
            return root.left;
        else {
            let cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            //swap val of root and cur
            let temp = root.val;
            root.val = cur.val;
            cur.val = temp;
        }
    }
    root.left = deleteNode(root.left, key);
    root.right = deleteNode(root.right, key);
    return root
};
//array to bst
var bstHelp = function (nums, left, right) {
    if (left > right)
        return null;
    let mid = parseInt((left + right) / 2);
    let node = new TreeNode(nums[mid]);
    node.left = bstHelp(nums, left, mid - 1);
    node.right = bstHelp(nums, mid + 1, right);
    return node;
};

