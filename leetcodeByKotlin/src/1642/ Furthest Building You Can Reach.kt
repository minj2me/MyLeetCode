package LeetCode_1642

/**
 * 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 *
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
While moving from building i to building i+1 (0-indexed),
1. If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
2. If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 * */
class Solution {
    /*
    * solution: PriorityQueue to save the diff of building height,
    * */
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        return 0
    }
}