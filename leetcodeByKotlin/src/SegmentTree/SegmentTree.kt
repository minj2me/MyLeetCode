package Algorithm.SegmentTree

class SegmentTree {

    fun build(nums: IntArray?, start: Int, end: Int): TreeNode? {
        if (nums == null) {
            return null
        }
        if (start == end) {
            return TreeNode(start, end, nums!![start])
        }
        val currentNode = TreeNode(start, end)
        val mid = (start + end) / 2
        currentNode.left = build(nums, start, mid)
        currentNode.right = build(nums, mid + 1, end)
        val leftSum = currentNode.left?.sum ?: 0
        val rightSum = currentNode.right?.sum ?: 0
        currentNode.sum = leftSum + rightSum
        return currentNode
    }

    fun update(node: TreeNode?, i: Int, value: Int) {
        if (node == null) {
            return
        }
        if (node.start == i && node.end == i) {
            node.sum = value
            return
        }
        val mid = (node.start + node.end) / 2
        if (i <= mid) {
            update(node.left, i, value)
        } else {
            update(node.right, i, value)
        }
        val leftSum = node.left?.sum ?: 0
        val rightSum = node.right?.sum ?: 0
        node.sum = leftSum + rightSum
    }

    fun rangeQueue(node: TreeNode?, i: Int, j: Int): Int {
        if (node == null) {
            return 0
        }
        if (i == node.start && j == node.end) {
            return node.sum
        }
        val mid = (node.start + node.end) / 2
        if (j<= mid) {
            return rangeQueue(node.left, i, j)
        } else if (i > mid) {
            return rangeQueue(node.right, i, j)
        } else {
            return rangeQueue(node.left, i, mid) + rangeQueue(node.right, mid + 1, j)
        }
    }
}