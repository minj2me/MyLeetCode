package LeetCode_118

import java.util.*

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/description/
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * Example:
Input: 5
Output:
[
    [1],
   [1,1],
  [1,2,1],
 [1,3,3,1],
[1,4,6,4,1]
]
 * */
class Solution {
    /*
    * Time complexity:O(n^2), Space complexity:O(n)
    * */
    fun generate(numRows: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        for (i in 0 until numRows){
            val row = ArrayList<Int>()
            for(j in 0 until i+1){
                if (j==0 || j==i){
                    //insert 1 into head and tail
                    row.add(1)
                } else {
                    //the value of current position is from it's top left + top right
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1))
                }
            }
            result.add(row)
        }
        return result
    }
}