package LeetCode_1649

/**
 * 1649. Create Sorted Array through Instructions
 * https://leetcode.com/problems/create-sorted-array-through-instructions/
 *
 * Given an integer array instructions, you are asked to create a sorted array from the elements in instructions.
 * You start with an empty container nums.
 * For each element from left to right in instructions, insert it into nums.
 * The cost of each insertion is the minimum of the following:
1. The number of elements currently in nums that are strictly less than instructions[i].
2. The number of elements currently in nums that are strictly greater than instructions[i].
For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1)
(elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].
Return the total cost to insert all elements from instructions into nums.
Since the answer may be large, return it modulo 10^9 + 7

Example 1:
Input: instructions = [1,5,6,2]
Output: 1
Explanation: Begin with nums = [].
Insert 1 with cost min(0, 0) = 0, now nums = [1].
Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
The total cost is 0 + 0 + 0 + 1 = 1.

Constraints:
1. 1 <= instructions.length <= 10^5
2. 1 <= instructions[i] <= 10^5
 * */
class Solution {
    /*
    * solution: Binary Indexed Tree, can efficiently update elements and calculate prefix sum in a table of numbers.
    * Time:O(mlogn), Space:O(m),
    * m: maximum value in instructions,
    * n: the number of instructions
    * */
    fun createSortedArray(instructions: IntArray): Int {
        val size = 1e5.toInt() + 10
        val mod = (1e9 + 7).toInt()
        var result = 0

        val binaryIndexedTree = BinaryIndexedTree(size)

        for (i in instructions.indices) {
            val instruction = instructions[i]
            val smaller = binaryIndexedTree.query(instruction - 1)//O(logm)
            val same = binaryIndexedTree.query(instruction) - smaller//O(logm)
            val bigger = i - smaller - same
            result = (result + Math.min(smaller, bigger)) % mod
            binaryIndexedTree.update(instruction, 1)//O(logm)
        }
        return result
    }
}

class BinaryIndexedTree constructor(n: Int) {
    private var sums: IntArray? = null
    private var n = 0

    init {
        this.n = n
        sums = IntArray(n)
    }

    /**
     * add num into position idx,
     * Time:log(n)
     * */
    fun update(idx: Int, num: Int) {
        var i = idx
        val numsSize = sums!!.size
        while (i < numsSize) {
            sums!![i] += num
            i += lowestBit(i)
        }
    }

    /**
     * return prefix sum from 0 to idx,
     * Time:log(n)
     * */
    fun query(idx: Int): Int {
        var i = idx
        var sum = 0
        while (i > 0) {
            sum += sums!![i]
            i -= lowestBit(i)
        }
        return sum
    }

    private fun lowestBit(i: Int): Int {
        return i and (-i)
    }
}