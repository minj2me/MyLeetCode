/**
 * 297. Serialize and Deserialize Binary Tree
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree 
structure.
The encoded string should be as compact as possible.

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
    let stack = [], res = "";
    //preorder,root->left->right
    while (root != null || stack.length > 0) {
        while (root != null) {
            stack.push(root);
            res += root.val + ",";
            root = root.left;
            if (root == null)
                res += "#,";
        }
        root = stack.pop();
        root = root.right;
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
    return deserializeHelper(array);

    //trying iterator
    // let val = array.shift();
    // let stack=[];
    // let t = new TreeNode(val);
    // stack.push(t);
    // while (stack.length>0){
    //     let node = stack.pop();
    //     let val = array.shift();
    //     //console.log("val1:"+val);
    //     if (val!="#"){
    //         let cur = new TreeNode(val);
    //         stack.push(cur);
    //         node.left = cur;
    //     } 
    //     val = array.shift();
    //      if (val!="#"){
    //         let cur = new TreeNode(val);
    //         stack.push(cur);
    //         node.right = cur;
    //     } 
    // }
    // return t;
};

var deserializeHelper = function (array) {
    let val = array.shift();
    if (val == "#")
        return null;
    let node = new TreeNode(val);
    node.left = deserializeHelper(array);
    node.right = deserializeHelper(array);
    return node;
}

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */