/**
 * 652. Find Duplicate Subtrees
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 * Given a binary tree, return all duplicate subtrees. 
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode[]}
 */
var findDuplicateSubtrees = function (root) {
    let res = [];
    let map = new Map();
    serializationHelp(root, map, res)
    //console.log(res);
    return res;
};

var serializationHelp = function (root, map, res) {
    if (root == null)
        return "#";
    let key = root.val + "," + serializationHelp(root.left, map, res) + "," + serializationHelp(root.right, map, res);
    if (map.has(key)) {
        map.set(key, map.get(key) + 1);
        if (map.get(key) == 2)
            res.push(root);
    } else {
        map.set(key, 1);
    }
    return key;
}