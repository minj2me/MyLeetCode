package LeetCode_898

/**
 * 898. Bitwise ORs of Subarrays
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/description/
 * Input: [1,1,2]
Output: 3
Explanation:
The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.
 * */
class Solution {
    fun subarrayBitwiseORs(A: IntArray): Int {
        val set = HashSet<Int>()

        //1.brute force, Time Complexity O(n*n*n), Space Complexity O(1) TLE
        /*for (i in 0 .. A.size){
            for (j in i+1 .. A.size){
                val subArray = A.toList().subList(i,j)
                println("subArray:${subArray.toString()}")
                var currentResult =0
                for (k in 0 until subArray.size){
                    currentResult = currentResult or subArray[k]
                    set.add(currentResult)
                }
            }
        }*/

        //2. with memorized, Time Complexity O(NlogK), Space Complexity O(NlogK),K is maximum size of array
        var current = HashSet<Int>()
        //current.add(0)
        for (item in A){
            val next = HashSet<Int>()
            //println("next.add($item)")
            next.add(item)
            for (curItem in current){
                next.add(curItem or item)
            }
            //println("item:$item")
            //current2.add(item)
            set.addAll(next)
            current = next
        }

        println(set.toString())
        return set.size
    }
}