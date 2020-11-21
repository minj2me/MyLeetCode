package LeetCode_360

/**
 * 360. Sort Transformed Array
 * (Prime)
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a quadratic function of the form f(x) = ax^2 + bx + c to each element x in the array.
The returned array must be in sorted order.
Expected time complexity: O(n)

Example 1:
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]

Example 2:
Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]
 * */
class Solution {
    /*
    * solution 1: minHeap, put into head after calculate, Time complexity:O(nlogn), Space complexity:O(n);
    * solution 2: math, parabola, which has minimum\maximum in the middle if a!=0; or is a line if a==0;
    * 1. 当a>0，说明两端的值比中间的值大，那么此时我们从结果res后往前填数，用两个指针分别指向nums数组的开头和结尾，指向的两个数就是抛物线两端的数，
    * 将它们之中较大的数先存入res的末尾，然后指针向中间移，重复比较过程，直到把res都填满。
      2. 当a<0，说明两端的值比中间的小，那么我们从res的前面往后填，用两个指针分别指向nums数组的开头和结尾，指向的两个数就是抛物线两端的数，
      将它们之中较小的数先存入res的开头，然后指针向中间移，重复比较过程，直到把res都填满。
      3. 当a=0，函数是单调递增或递减的，那么从前往后填和从后往前填都可以，我们可以将这种情况和a>0合并。
    * */
    fun sortTransformedArray(nums: IntArray, a: Int, b: Int, c: Int): IntArray {
        //solution 2
        val len = nums.size
        val result = IntArray(len)
        var left = 0
        var right = len-1
        var pos1 = 0
        var pos2 = len-1
        while (left <= right) {
            val first = calculate(nums[left], a, b, c)
            val second = calculate(nums[right], a, b, c)
            if (a >= 0) {
                //minimum\maximum in the middle
                //put the large one in the end of result and move the pointer
                if (first > second) {
                    result[pos2--] = first
                    left++
                } else {
                    result[pos2--] = second
                    right--
                }
            } else {
                //is a line, the element in head or end is less then middle,
                //put the small one in first and move the pointer
                if (first < second) {
                    result[pos1++] = first
                    left++
                } else {
                    result[pos1++] = second
                    right--
                }
            }
        }
        return result
    }

    private fun calculate(x: Int, a: Int, b: Int, c: Int): Int {
        return a * x * x + b * x + c
    }
}