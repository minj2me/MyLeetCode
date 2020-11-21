/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = null;
 *      this.right = null;
 * }
 */

let root = {
    val: 1,
    left: {
        val: 2,
        left: { val: 4, right: null }, right: { val: 5 }
    },
    right: {
        val: 3, right: {
            val: 6
        }
    }
};
/**
 * 深度优先遍历,dfs
 * 该算法先将当前结点的孩子全部遍历结束，在遍历同一级的节点
 * https://www.jianshu.com/p/b4d8085e84bd
 */
var deepFirstSearchTree = function (node) {
    let stack = [];
    stack.push(node);
    //console.log(node);
    while (stack.length > 0) {
        let node = stack.pop();
        if (node != null)
            string += node.val + "->";
        if (node.right != null)
            stack.push(node.right);
        if (node.left != null)
            stack.push(node.left);
    }
    console.log(string);
}

/**
 * 广度优先遍历,bfs
 * 广度优先遍历，先依次遍历兄弟节点，然后便利兄弟节点下的子节点
 * https://www.jianshu.com/p/b4d8085e84bd
 */
var breadthFristSearchTree = function (node) {
    let stack = [];
    stack.push(node);
    //console.log(node);
    while (stack.length > 0) {
        let node = stack.shift();
        if (node != null)
            string += node.val + "->";
        if (node.left != null)
            stack.push(node.left);
        if (node.right != null)
            stack.push(node.right);
    }
    console.log(string);
}

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    //bsf
    //56 ms
    let result = [];
    if (root == null) return result;
    let stack = [];
    stack.push(root);
    while (stack.length > 0) {
        let oneLevel = [];
        let size = stack.length;
        //console.log("size:"+size);
        for (let i = 0; i < size; i++) {
            let node = stack.shift();
            oneLevel.push(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        // /console.log(oneLevel);
        result.push(oneLevel);
    }
    //console.log(result);
    return result;
};

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function (root) {
    //56 ms
    let stack = [], result = [];
    if (root == null) return result;
    stack.push(root);
    while (stack.length > 0) {
        let oneLevel = [];
        let size = stack.length;
        for (let i = 0; i < size; i++) {
            let node = null
            node = stack.shift();
            if (node != null) {
                oneLevel.push(node.val);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
            }
        }
        //https://www.cnblogs.com/grandyang/p/4297009.html
        //其实每一层同样操作，然后在偶数层翻转一下
        if (result.length % 2 == 0) {
            oneLevel.reverse();
        }
        result.push(oneLevel);
    }
    return result;
};

/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function (root) {
    if (root == null)
        return 0;
    let deepLeft = 1, deepRight = 1;
    if (root.left != null)
        deepLeft += maxDepth(root.left);
    if (root.right != null)
        deepRight += maxDepth(root.right);
    // console.log(deepLeft);
    // console.log(deepRight);
    return Math.max(deepLeft, deepRight);
};

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function (root) {
    if (root == null)
        return true;
    if (root.left == null && root.right == null)
        return true;
    let leftDeep = maxDepth(root.left);
    let rightDeep = maxDepth(root.right);
    if (Math.abs(leftDeep - rightDeep) > 1)
        return false;
    //determine left tree and right tree wether avl tree
    return isBalanced(root.left) && isBalanced(root.right);
};

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function (root) {
    if (root == null) return true;
    let array = [];
    this.addInArrayByInOrder(root, array);
    //console.log(array);
    let len = array.length;
    for (let i = 0; i < len - 1; i++) {
        if (array[i] >= array[i + 1])
            return false;
    }
    return true;
};

//inorder will return sorted list, small to big
var addInArrayByInOrder = function (node, arr) {
    if (node.left != null)
        addInArrayByInOrder(node.left, arr)
    if (node != null)
        arr.push(node.val);
    if (node.right != null)
        addInArrayByInOrder(node.right, arr)
}

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function (root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    //invert the right
    let right = invertTree(root.right);
    return isSameTree(root.left, right);
};

/**
 * check two tree is the same
 */
var isSameTree = function (root1, root2) {
    if (root1 == null && root2 == null)
        return true;
    if (root1 == null && root2 != null || root1 != null && root2 == null)
        return false;
    if (root1.val != root2.val)
        return false;
    return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
}

/**
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
 * @param {*} root 
 */
var invertTree = function (root) {
    // 80 ms
    //if (root == null) return null;
    // let left = root.left;
    // let right = root.right;
    // root.right = invertTree(left);
    // root.left = invertTree(right);
    // return root;


    /**
    * array methods
    *  //reverse() 颠倒数组中元素的顺序。
   //pop() 方法用于删除并返回数组的最后一个元素。
   //shift() 删除并返回数组的第一个元素。
   //unshift() 向数组的开头添加一个或更多元素，并返回新的长度。
   //concat() 连接两个或更多的数组，并返回结果。
    */
    if (root == null) return null;
    let array = new Array();
    array.push(root);
    //76ms
    while (array.length > 0) {
        let node = array.shift();
        let temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null)
            array.push(node.left);
        if (node.right != null)
            array.push(node.right);
    }
    console.log(root);
}


var buildBST = function (root, node) {
    if (node.val < root.val) {
        if (root.left == null)
            root.left = node;
        else
            buildBST(root.left, node);
    } else if (node.val > root.val) {
        if (root.right == null)
            root.right = node;
        else
            buildBST(root.right, node);
    }
    //if equal, do nothing
};


/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/description/
 * Input:
   1
 /   \
2     3
 \
  5
Output: ["1->2->5", "1->3"]
Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
    let result = [], path = "";
    //64 ms
    binaryTreePathsHelp(root, path, result);
    console.log(result);
};
//dfs
var binaryTreePathsHelp = function (node, path, result) {
    if (node == null)
        return;
    //recursive
    path = path + "->" + node.val;
    if (node.left == null && node.right == null) {
        result.push(path.substring(2));
        return;
    }
    if (node.right != null)
        binaryTreePathsHelp(node.right, path, result);
    if (node.left != null)
        binaryTreePathsHelp(node.left, path, result);

    //try Iterative
};


/**
 * 94. Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * Inorder：左->根->右
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function (root) {
    let stack = [], result = [];
    //by stack
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            root = root.left;//push left node
        }
        root = stack.pop();
        result.push(root.val);//save left first
        root = root.right;
    }
    //52ms by recursive
    //inorderTraversalHelp(root,result);
    return result;
};
var inorderTraversalHelp = function (root, result) {
    if (root != null) {
        inorderTraversalHelp(root.left, result);//左
        result.push(root.val);//根
        inorderTraversalHelp(root.right, result);//右
    }
}

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * @param {TreeNode} root
 * @return {number[]}
 * Preorder: 根-左-右
 */
var preorderTraversal = function (root) {
    //52 ms
    let stack = [], result = [];
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            result.push(root.val);//save root first
            root = root.left;//push left node
        }
        root = stack.pop();
        root = root.right;
    }
    return result;
};

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 * @param {TreeNode} root
 * @return {number[]}
 * Postorder: 左->右->根
 */
var postorderTraversal = function (root) {
    let stack = [], result = [];
    while (stack.length > 0 || root != null) {
        while (root != null) {
            stack.push(root);
            result.push(root.val);
            root = root.right;//push right node
        }
        root = stack.shift();
        root = root.left;
    }
    //52ms
    //postorderTraversalHelp(root,result);
    return result;
};
var postorderTraversalHelp = function (root, result) {
    if (root != null) {
        postorderTraversalHelp(root.left, result);//左
        postorderTraversalHelp(root.right, result);//右
        result.push(root.val);//根
    }
};


