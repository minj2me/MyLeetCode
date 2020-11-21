package LeetCode_593

/**
 * 593. Valid Square
 * https://leetcode.com/problems/valid-square/
 *
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
The coordinate (x,y) of a point is represented by an integer array with two integers.
Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True

Note:
1. All the input integers are in the range [-10000, 10000].
2. A valid square has four equal sides with positive length and four equal angles (90-degree angles).
3. Input points have no order.
 * */
class Solution {
    /*
    * solution: HashSet + Geometry, check if Square by:
    * 1. if length of 4 slides are same and the length!=0
     *2. if length of 2 diagonals are same and the length!=0
     *Time complexity: O(1), Space complexity: O(1)
    * */
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        //set for save distance for two point
        val set = HashSet<Int>()
        val arrays = Array(4) { IntArray(2) }
        arrays[0] = p1
        arrays[1] = p2
        arrays[2] = p3
        arrays[3] = p4
        for (i in arrays.indices) {
            for (j in 0 until i) {
                set.add(distance(arrays[i], arrays[j]))
            }
        }
        return set.size == 2 && !set.contains(0)
    }

    /**
     * return the distance of two point by formula: (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2),
     * */
    private fun distance(array1: IntArray, array2: IntArray): Int {
        val x1 = array1[0]
        val y1 = array1[1]
        val x2 = array2[0]
        val y2 = array2[2]
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
    }

}