var inorderPredecessor = function (root, p) {
    let stack = [];
    let index = 0, pIndex = 0;
    let array = [];
    while (root != null || stack.length > 0) {
        if (root != null) {
            stack.push(root);
            root = root.left;
        } else {
            root = stack.pop();
            if (root.val == p)
                pIndex = index;
            index++;
            array.push(root);
            root = root.right;
        }
    }
    return array[pIndex - 1];
}