/**
 * Lock by Leetcode
 * 
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 * 
 * https://www.cnblogs.com/grandyang/p/9615871.html
 *  
 *  4
   / \
  2   5
 / \
1   3		
return 1<->2<->3<->4<->5
 */

let tree = {
    val: 4,
    left: { val: 2, left: { val: 1 }, right: { val: 3 } },
    right: { val: 5, left: { val: 6 } }
};

var BSTToDoubleLinkList = function (root) {
    //inorder left->root->right
    if (root == null)
        return null;
    let stack = [];
    let headNode = null;
    let prevNode = null;
    while (root != null || stack.length > 0) {
        if (root != null) {
            stack.push(root);
            root = root.left
        } else {
            root = stack.pop();
            //console.log("root.val:"+root.val);
            if (headNode == null)
                headNode = root;
            if (prevNode != null) {
                //P->Current and P<-Current
                prevNode.right = root;//set prve's next point to current node
                root.left = prevNode;//set current node.left point to prev
            }
            //move the pointer the next node
            prevNode = root;
            //scan next tree node
            root = root.right;
        }
    }
    headNode.left = prevNode;
    prevNode.right = headNode;
    return headNode;
}
