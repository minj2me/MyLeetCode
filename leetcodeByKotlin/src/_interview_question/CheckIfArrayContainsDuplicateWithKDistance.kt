package _interview_question

/**
 * Check if a given array contains duplicate elements within k distance from each other.
 * Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array.
 * Write a function that returns true if array contains duplicates within k distance.
 *
 * Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
 * */
class Solution11 {
    /*
    * solution 1: Time complexity:O(n*k), Space complexity:O(1)
    * solution 2: HashSet, Time complexity:O(n), Space complexity:O(n)
    * */
    fun checkDuplicate(nums: IntArray, k: Int): Boolean {
        /*for (i in nums.indices){
            for (j in i+1 until nums.size){
                if (nums[i]==nums[j]){
                    println("i:$i")
                    println("j:$j")
                    if (j-i<=k){
                        return true
                    }
                }
            }
        }
        return false*/

        val set = HashSet<Int>()
        for (i in nums.indices) {
            if (set.contains(nums[i])) {
                return true
            }
            set.add(nums[i])
            //remove the k+1 distance item
            if (i >= k) {
                set.remove(nums[i - k])
            }
        }
        return false
    }
}