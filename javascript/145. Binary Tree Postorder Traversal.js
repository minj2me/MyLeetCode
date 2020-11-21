/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * @param {TreeNode} root
 * @return {number[]}
 * Postorder: 左->右->根
 */
var postorderTraversal = function (root) {
    let stack = [], result = [];
    //postOrder
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            result.push(root.val);
            root = root.right;//push right node
        }
        root = stack.shift();
        root = root.left;
    }
    ///end 

    //52ms
    //postorderTraversalHelp(root,result);
    return result;
};

 ///inOrder,左->根->右
 while (stack.length > 0 || root != null) {
    if (root != null) {
        stack.push(root);
        root = root.left;//
    } else {
        root = stack.pop();//pop方法用于删除并返回数组的最后一个元素。
        result.push(root);//只有inOrder才在这里push
        root = root.right;
    }
}
//end

//preOrder,根->左->右
while (stack.length>0 || root!=null){
    while (root!=null){
        stack.push(root);
        result.push(root.val);
        root = root.left;
    }
    root = stack.pop();
    root = root.right;
}


var postorderTraversalHelp = function (root, result) {
    if (root != null) {
        postorderTraversalHelp(root.left, result);//左
        postorderTraversalHelp(root.right, result);//右
        result.push(root.val);//根
    }
};


