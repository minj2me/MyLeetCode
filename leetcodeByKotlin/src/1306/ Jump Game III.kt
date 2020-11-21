package LeetCode_1306

import java.util.*

/**
 * 1306. Jump Game III
 * https://leetcode.com/problems/jump-game-iii/description/
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i,
 * you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
 * */
class Solution {
    //try bfs
    fun canReach(arr: IntArray, start: Int): Boolean {
        if (arr == null || arr.size == 0) {
            return false
        }
        val N = arr.size
        val visited = BooleanArray(N)
        val queue = LinkedList<Int>()
        queue.add(start)
        visited[start] = true
        while (queue.isNotEmpty()) {
            val currentInt = queue.poll()
            if (arr[currentInt] == 0) {
                return true
            }
            //do some expand
            //you can jump to i + arr[i] or i - arr[i]
            val needAddIndex = currentInt - arr[currentInt]
            val needAddIndex2 = currentInt + arr[currentInt]
            if (needAddIndex >= 0 && !visited[needAddIndex]) {
                visited[needAddIndex] = true
                queue.add(needAddIndex)
            }
            if (needAddIndex2 < N && !visited[needAddIndex2]) {
                visited[needAddIndex2] = true
                queue.add(needAddIndex2)
            }
        }
        return false
    }

    /*
    BFS pseudocode
    * queue.push(start)
    * step = 0
    * while (queue.isNotEmpty()){
    *   step++
    *   size = queue.size
    *   //scan current level
    *   while (size-->0){
    *       node = queue.pop()
    *       //从node开始扩展
    *       new_nodes = expand(node)
    *       if (goal in new_nodes){
    *           return step++
    *       }
    *       queue.append(new_nodes)
    *   }
    * }
    * return NOT_FOUND
    * */
}