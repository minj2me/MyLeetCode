package LeetCode_398

import java.util.*

/**
 * 398. Random Pick Index
 * https://leetcode.com/problems/random-pick-index/description/
 *
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:
int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);
 * */
class Solution(nums: IntArray) {
    /*
    solution 1: kotlin method,
    solution 2: Reservoir Sampling,
    for example input: {1,2,3,3,3}
    * return Iterable of IndexedValue with value,index like this:
    * 1=[0],2=[1],3=[2, 3, 4], then get random in values
    * */
    var array: IntArray? = null
    val random = Random()

    init {
        array = nums
    }

    private val numWithIndex = nums.withIndex().groupBy({ it.value }, { it.index })

    fun pick(target: Int): Int {
        //return numWithIndex[target]?.random() ?: error("$target not found")
        var result = 0
        //keep saving the random range
        var count = 0
        for (i in array!!.indices) {
            if (array!![i] != target) {
                continue
            }
            //count increase before pass into nextInt
            if (random.nextInt(++count) == 0) {
                result = i
            }
        }
        return result
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.pick(target)
 */