package _interview_question

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class LongestPatFromRootToLeaf {

    private var result = 0

    fun solution12(root: TreeNode): Int {
        help(root, ArrayList())
        return result
    }

    private fun help(root: TreeNode?, cur:ArrayList<TreeNode>) {
        if (root == null) {
            return
        }
        cur.add(root)
        if (root.left == null && root.right == null) {
            result = Math.max(result, cur.size-1)
            return
        }
        if (root.left != null) {
            help(root.left, cur)
            cur.removeAt(cur.lastIndex)
        }
        if (root.right != null) {
            help(root.right, cur)
            cur.removeAt(cur.lastIndex)
        }
    }
}