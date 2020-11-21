package LeetCode_528

import java.util.*

/**
 * 528. Random Pick with Weight
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i(0-indexed),
 * write a function pickIndex which randomly picks an index in proportion to its weight.
For example, given an input list of values w = [2, 8], when we pick up a number out of it,
the chance is that 8 times out of 10 we should pick the number 1 as the answer since it's the second element of the array (w[1] = 8).

Example 1:
Input
["Solution","pickIndex"]
[[[1]],[]]
Output
[null,0]
Explanation
Solution solution = new Solution([1]);
solution.pickIndex(); //return 0. Since there is only one single element on the array the only option is to return the first element.

Constraints:
1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
 * */

class Solution(w: IntArray) {
    /*
    * solution: cumulative sum of array + Binary Search, Time complexity:O(n + logn), Space complexity:O(n)
    * for example: [1,3], so the probability of appearance of 1 is 1/4, 3 is 3/4
    * */

    var sumArray: IntArray? = null

    init {
        sumArray = IntArray(w.size)
        var sum = 0
        for (i in w.indices) {
            sum += w[i]
            sumArray!![i] = sum
        }
        //sumArray!!.forEach { print("$it,") }
    }

    fun pickIndex(): Int {
        val x = Random().nextInt(sumArray!![sumArray!!.lastIndex])
        println("x:$x")
        var left = 0
        var right = sumArray!!.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            println("sumArray!![$mid]:${sumArray!![mid]}")
            if (sumArray!![mid] <= x) {
                //search in right hand side
                left = mid + 1
            } else {
                right = mid
            }
            println("left:$left")
            println("right:$right")
        }
        //find out the index of first one that larger than x
        println("result:$right")
        return right
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */