/**
 * 31. Next Permutation
 *https://leetcode.com/problems/next-permutation/description/
 https://www.programcreek.com/2014/06/leetcode-next-permutation-java/

 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function (nums) {
    //1.scan from right to left, find out the first number named p less than prev one
    //2.scan from right to left, find out the first number name q greater than p
    //3.swap p and q
    //4.reverse elements [p+1, nums.length]
    let p = 0, q = 0;
    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            p = i;
            break;
        }
    }
    for (let i = nums.length - 1; i > p; i--) {
        if (nums[i] > nums[p]) {
            q = i
            break;
        }
    }
    // console.log("p:"+p);
    // console.log("q:"+q);
    if (p == 0 && q == 0) {
        reverse(nums, 0, nums.length - 1);
        return;
    }
    let temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
    reverse(nums, p + 1, nums.length - 1);
};
var reverse = function (nums, left, right) {
    while (left < right) {
        let temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
    //console.log(nums);
};