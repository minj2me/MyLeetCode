package LeetCode_624

import java.util.*

/**
 * lock by Leetcode
 * https://www.lintcode.com/problem/maximum-distance-in-arrays/description
 *
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the difference between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum difference.

Example
Example1

Input: [[1,2,3], [4,5], [1,2,3]]
Output: 4
Explanation:
One way to reach the maximum difference 4 is to pick 1 in the first or third array and pick 5 in the second array.


//定义二维数组
val arrays = Array(3) {IntArray(3)}
//Input: [[1,2,3], [4,5], [1,2,3]]
val array1 = IntArray(3)
array1[0]=1
array1[1]=2
array1[2]=3
val array2= IntArray(3)
array2[0]=4
array2[1]=0
array2[2]=5
val array3 = IntArray(3)
array3[0]=1
array3[1]=2
array3[2]=3

arrays[0] = array1
arrays[1] = array2
arrays[2] = array3
println("maxDiff:"+solution.maxDiff(arrays))
 * */
class Solution {
    fun maxDiff(arrs: Array<IntArray>): Int {
        val size = arrs.size
        if (size == 0)
            return 0
        val min = PriorityQueue<Pair>()
        val max = PriorityQueue<Pair>()
        for (i in arrs.indices) {
            val pForMin = Pair(-arrs[i][0], i)
            println(pForMin.first)
            println(",")
            min.offer(pForMin)
            val pForMax = Pair(arrs[i][arrs.size - 1], i)
            println(pForMax.first)
            max.offer(pForMax)
            println("====")
        }
        val a1 = max.poll()
        val b1 = min.poll()
        if (a1.second != b1.second)//check index
            return a1.first + b1.first////如果最大的数字和最小的数字不在一个数组，那么直接返回二者的绝对差即可
        //如果在的话，那么要返回第二大数字和最小数字绝对差跟最大数字和第二小数字绝对差中的较大值
        return Math.max(a1.first + min.peek().first, max.peek().first + b1.first)
    }
}

