package LeetCode_163

/**
 * 163. Missing Ranges
 * (Prime)
 *Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper],
 * return its missing ranges.
Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
 * */
class Solution {
    /*
    * solution: Two pointer, lower_ and upper_, keep checking lower_ and update it if need;
    * Time complexity:O(n), Space complexity:O(1)
    * */
    fun getRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
        val result = ArrayList<String>()
        //use long to avoid stack overflow
        var lower_ = lower.toLong()
        val upper_ = upper.toLong()

        //keep checking lower
        for (num in nums) {
            if (num.toLong() == lower_) {
                //increasing the lower
                lower_++
            } else if (lower_ < num) {
                //for example: lower_ is 2, num is 3
                if (lower_ + 1 == num.toLong()) {
                    result.add(lower_.toString())
                } else {
                    //for example: lower_ is 4, num is 50
                    result.add("$lower_->${num - 1}")
                }
                //update lower
                lower_ = num.toLong() + 1
            }
        }

        //check the upper
        if (lower_ == upper_) {
            result.add(lower_.toString())
        } else {
            result.add("$lower_->$upper_")
        }

        return result
    }
}