/**
 * Your BSTIterator will be called like this:
 * var i = new BSTIterator(root), a = [];
 * while (i.hasNext()) a.push(i.next());
 * 
 * array methods
 *    //reverse() 颠倒数组中元素的顺序。
   //pop() 方法用于删除并返回数组的最后一个元素。
   //shift() 删除并返回数组的第一个元素。
   //unshift() 向数组的开头添加一个或更多元素，并返回新的长度。
   //concat() 连接两个或更多的数组，并返回结果。
*/
/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * @constructor
 * @param {TreeNode} root - root of the binary search tree
 */

let array = [];
var BSTIterator = function (root) {
    if (root != null && root.val != null) {
        //use recursive //!!!104ms
        //addNodeByInOrder(root);
        //use letrative : !!76 ms
        array = addNodeByLterative(root);
    }
};

function addNodeByInOrder(node) {
    if (node != null) {
        addNodeByInOrder(node.left);
        //console.log(node.show() + " ");
        array.push(node);
        addNodeByInOrder(node.right);
    }
}

/**
 * 以中序处理node
 * @param {*} node 
 */
function addNodeByLterative(node) {
    /**
    for example:
    tree:
        2
      /   \
     3     1
    / \    /
   6   7  8
    
    insert process:
    help push:2
help push:3
help push:6
array push:6
array push:3
help push:7
array push:7
array push:2
help push:1
help push:8
array push:8
array push:1
    */
    let help = [];
    while (node != null || help.length > 0) {
        if (node != null) {
            help.push(node);
            node = node.left;
        } else {
            node = help.pop();//pop方法用于删除并返回数组的最后一个元素。
            array.push(node);
            node = node.right;
        }
    }

}

/**
 * @this BSTIterator
 * @returns {boolean} - whether we have a next smallest number
 */
BSTIterator.prototype.hasNext = function () {
    return array.length > 0;
    //return node!=null;
};
/**
 * @this BSTIterator
 * @returns {number} - the next smallest number
 */
BSTIterator.prototype.next = function () {
    let node = array.shift();
    if (node != null)
        return node.val;
};