package LeetCode_307

import Algorithm.SegmentTree.SegmentTree
import Algorithm.SegmentTree.TreeNode

/**
 * 307. Range Sum Query - Mutable
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 * */
class NumArray(nums: IntArray) {
    //method one
    //var data: IntArray? = null
    var segmentTree: SegmentTree? = null
    var root: TreeNode? = null

    init {
        //this.data = nums
        segmentTree = SegmentTree()
        root = segmentTree?.build(nums, 0, nums.size - 1)
    }

    /*fun update(i: Int, `val`: Int) {
        if (data != null) {
            data!![i] = `val`
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        var sum = 0
        if (data != null) {
            for (index in i until j+1) {
                sum += data!![index]
            }
        }
        return sum
    }*/

    //method two, Segment Tree
    fun update(i: Int, `val`: Int) {
        segmentTree?.update(root, i, `val`)
    }

    fun sumRange(i: Int, j: Int): Int {
        return segmentTree?.rangeQueue(root, i, j)!!
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(i,`val`)
 * var param_2 = obj.sumRange(i,j)
 */