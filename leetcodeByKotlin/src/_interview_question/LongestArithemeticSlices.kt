package _interview_question

/**
 * we have 2 arrays in sorted order, no duplicates.
we need find the max continuous length AP [arithmetic prog] in the first array by adding 0 or more elements from the second array
example,
A= [4,8,13]
B=[0,9,12]
ANSWER = 4, because: [0,4,8,12]
 * */
class Solution15 {
    /*
    * solution: merge two sorted array and find out longest arithmetic slices,
    * Time complexity:O(n^3), Space complexity:O(n)
    * */
    fun longestArithemeticSlices(nums1: IntArray, nums2: IntArray): Int {
        //merge two sorted array
        val n = nums1.size + nums2.size
        val array = IntArray(n)
        var i = 0
        var j = 0
        var index = 0
        while (i < nums1.size && j < nums2.size) {
            if (nums1[i] < nums2[j]) {
                array[index++] = nums1[i]
                i++
            } else {
                array[index++] = nums2[j]
                j++
            }
        }
        while (i < nums1.size) {
            array[index++] = nums1[i]
            i++
        }
        while (j < nums2.size) {
            array[index++] = nums2[j]
            j++
        }
        //find out longest arithmetic
        var max = 0
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val diff = array[j] - array[i]
                //for example: 1,2,3,4, A[j]=2, diff=1, so next should be 2+1
                var next = array[j] + diff
                //because has number 1,2, so current length is 2
                var currentMax = 2
                for (k in j + 1 until n) {
                    if (array[k] == next) {
                        currentMax++
                        next = array[k] + diff
                    }
                    max = Math.max(currentMax,max)
                }
            }
        }
        return max
    }
}