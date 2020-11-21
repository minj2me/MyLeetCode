/**
 * 449. Serialize and Deserialize BST
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 * 
 * Time Complexity: serialize, O(n). deserialize, O(n). Space: O(n).
 */
/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
    if (root == null)
        return "";
    let stack = [];
    let res = "";
    //preorder, root->left->right
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            res += root.val + ",";
            root = root.left;
            //handle null
            if (root == null)
                res += "#,";
        }
        root = stack.pop();
        root = root.right;
        //handle null
        if (root == null)
            res += "#,";
    }
    return res.substring(0, res.length - 1);
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
    if (data == "")
        return null;
    let array = data.split(",");
    return bstHelper(array);
};

var bstHelper = function (array) {
    let val = array.shift();
    //console.log(val);
    if (val == "#")
        return null;
    let node = new TreeNode(val);
    node.left = bstHelper(array);
    node.right = bstHelper(array);
    return node;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */