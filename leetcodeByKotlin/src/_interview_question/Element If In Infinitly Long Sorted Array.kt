package _interview_question

/**
 * Check if a given target element is found in the infinite long sorted array.
 * */
class Solution8 {
    /**
     * solution: binary search
     * 1. find proper bound
     * 2. apply binary search
     * */
    fun checkElement(nums: IntArray, target: Int): Int {
        var l = 0
        var h = 1
        var value = nums[0]
        //because nums is infinite size, so there is not index out of bound checking
        while (value < target) {
            l = h//store previous h to improve the time complexity in binarySearch
            //check that h*2 not exceeds length of array to prevent OutOfBoundsException
            if (h * 2 < nums.size-1) {
                h *= 2
            } else {
                h = nums.size - 1
            }
            //update the value
            value = nums[h]
        }
        return binarySearch(nums,l,h,target)
    }

    private fun binarySearch(nums: IntArray, left: Int, right: Int, target: Int): Int {
        if (right >= left) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                //search in left side
                return binarySearch(nums, left, mid - 1, target)
            } else {
                return binarySearch(nums, mid + 1, right, target)
            }
        }
        return -1
    }
}
