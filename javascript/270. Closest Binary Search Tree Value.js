/**
 * Lock by leetcode
 * 
 * 270. Closest Binary Search Tree Value
 */
/**
 * @param root: the given BST
 * @param target: the given target
 * @return: the value in the BST that is closest to the target
 */
const closestValue = function (root, target) {
    let stack = [], diff = 0, min = Math.pow(2, 31), res = 0;
    while (root != null || stack.length > 0) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            diff = Math.abs(target - root.val);
            if (diff < min) {
                min = diff;
                res = root.val;
            }
            root = root.right;
        }
    }
    return res;
}
