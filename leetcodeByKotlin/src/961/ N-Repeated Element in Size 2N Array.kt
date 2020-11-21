package LeetCode_961

/**
 * 961. N-Repeated Element in Size 2N Array
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/
 *
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
Return the element repeated N times.

Example 1:
Input: [1,2,3,3]
Output: 3
 * */
class Solution {
    fun repeatedNTimes(A: IntArray): Int {
        /*val n = A.size/2
        val map = HashMap<Int,Int>()
        for (i in A){
            map.put(i, map.getOrDefault(i,0)+1)
        }
        for (m in map){
            if (m.value==n){
                return m.key
            }
        }*/

        //because exactly one of these elements is repeated N times
        val array = IntArray(10000)
        for (num in A){
            array[num]++
            if (array[num]>1){
                return num
            }
        }
        return 0
    }
}