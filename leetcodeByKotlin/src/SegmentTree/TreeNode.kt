package Algorithm.SegmentTree

class TreeNode constructor(start: Int, end: Int, sum: Int = 0) {
    var start = 0
    var end = 0
    var sum = 0
    var left:TreeNode?=null
    var right:TreeNode?=null

    init {
        this.start = start
        this.end = end
        this.sum = sum
    }
}