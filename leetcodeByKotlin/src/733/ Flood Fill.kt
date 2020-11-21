package LeetCode_733

import java.util.*

/**
 * 733. Flood Fill
 * https://leetcode.com/problems/flood-fill/
 * An image is represented by a 2-D array of integers,
 * each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.

Example 1:
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
 * */
class Solution {
    /*
    * solution: BFS, Time complexity:O(mn), Space complexity:O(mn)
    * */
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        if (image == null || image.isEmpty()) {
            return image
        }
        val startingColor = image[sr][sc]
        if (startingColor == newColor) {
            return image
        }
        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(Pair(sr, sc))
        //set sr,sc as newColor
        image[sr][sc] = newColor
        val directions = intArrayOf(0, 1, 0, -1, 0)
        while (queue.isNotEmpty()) {
            val cur = queue.pop()
            //loop for 4 directions
            for (d in 0 until 4) {
                val newX = cur.first + directions[d]
                val newY = cur.second + directions[d + 1]
                //check boundary, and if new position color not same as starting color, skip it
                if (newX < 0 || newY < 0 || newX >= image.size || newY >= image[0].size || image[newX][newY] != startingColor) {
                    continue
                }
                //set current x,y as newColor
                image[newX][newY] = newColor
                queue.offer(Pair(newX, newY))
            }
        }
        return image
    }
}