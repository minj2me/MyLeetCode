package LeetCode_1411

/**
 * 1411. Number of Ways to Paint N × 3 Grid
 * https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/description/
 *
 * You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colours: Red, Yellow or Green while making sure that no two adjacent cells have the same colour (i.e no two cells that share vertical or horizontal sides have the same colour).
You are given n the number of rows of the grid.
Return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 12

Constraints:
n == grid.length
grid[i].length == 3
1 <= n <= 5000
 * */
class Solution {
    //0:red, 1:yellow, 2:green, all possible for n==1
    private val colorsForOne = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 0, 1),
        intArrayOf(2, 0, 1),
        intArrayOf(0, 1, 2),
        intArrayOf(1, 0, 2),
        intArrayOf(2, 0, 2),
        intArrayOf(0, 2, 0),
        intArrayOf(1, 2, 0),
        intArrayOf(2, 1, 0),
        intArrayOf(0, 2, 1),
        intArrayOf(1, 2, 1),
        intArrayOf(2, 1, 2)
    )

    private val mod = 1000000007

    fun numOfWays(n: Int): Int {
        val map = HashMap<String, Int>()
        val initArray = intArrayOf(-1, -1, -1)
        val result = dfs(n, 0, initArray, map)
        println(result)
        return result
    }

    /**
     * dfs + memorization: Time complexity:O(n*l*l), Space complexity:O(n), l is length of colorsForOne
     * */
    private fun dfs(n: Int, index: Int, curColor: IntArray, map: HashMap<String, Int>): Int {
        if (n == index) {
            return 1
        }
        val key = curColor.toString()+"_"+index
        if (map.contains(key)){
            return map.get(key)!!
        }
        var result = 0
        for (nextColor in colorsForOne) {
            //if current column color is equal to previous column, skip it
            if (curColor[0] == nextColor[0] || curColor[1] == nextColor[1] || curColor[2] == nextColor[2]) {
                continue
            }
            //because with memorization, so each sub-problem need O(l) (upper bound) time to solve
            //then we have l sub-problems,l is length of colorsForOne
            result += dfs(n, index + 1, nextColor, map)
            result %= mod
        }
        map.put(key,result)
        return result
    }
}