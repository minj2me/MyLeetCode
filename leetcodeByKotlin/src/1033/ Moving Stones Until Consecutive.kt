package LeetCode_1033

/**
 * 1033. Moving Stones Until Consecutive
 * https://leetcode.com/problems/moving-stones-until-consecutive/
 *
 * Three stones are on a number line at positions a, b, and c.
Each turn, you pick up a stone at an endpoint (ie., either the lowest or highest position stone), and move it to an unoccupied position between those endpoints.
Formally, let's say the stones are currently at positions x, y, z with x < y < z.
You pick up the stone at either position x or position z, and move that stone to an integer position k, with x < k < z and k != y.
The game ends when you cannot make any more moves, ie.
the stones are in consecutive positions.
When the game ends, what is the minimum and maximum number of moves that you could have made?
Return the answer as an length 2 array: answer = [minimum_moves, maximum_moves]

Example 1:
Input: a = 1, b = 2, c = 5
Output: [1,2]
Explanation: Move the stone from 5 to 3, or move the stone from 5 to 4 to 3.
 * */
class Solution {
    /*
    * solution: sort and calculate the minimum and maximum moves,
    * Time complexity:O(nlogn), Space complexity:O(1)
    * */
    fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
        var minimumMove = 0
        var maximumMove = 0
        val array = intArrayOf(a, b, c)
        array.sort()
        //if each num differs by 1, mean minimumMove is 0
        if (array[1] - array[0] == 1 && array[2] - array[1] == 1) {
            minimumMove = 0
        } else if (array[1] - array[0] <= 2 || array[2] - array[1] <= 2) {
            //if each num differs by 2, mean minimumMove is 0
            minimumMove = 1
        } else {
            minimumMove = 2
        }
        //the maximum move is: two endpoint stone move one space each time, -2 because jump over b
        maximumMove = array[2] - array[0] - 2

        return intArrayOf(minimumMove, maximumMove)
    }
}