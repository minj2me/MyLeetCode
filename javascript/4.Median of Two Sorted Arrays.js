/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 
 * Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

 */
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    //1.merge two array
    let newArray = [];
    let length = nums1.length + nums2.length;
    let num1Index = 0, num2Index = 0, index = 0;
    while (index < length) {
        //console.log(index);
        // console.log("num2Index:"+num2Index);
        let isArr1Depleted = num1Index >= nums1.length;
        let isArr2Depleted = num2Index >= nums2.length;

        if (!isArr1Depleted && (isArr2Depleted || (nums1[num1Index] < nums2[num2Index]))) {
            newArray[index] = nums1[num1Index];
            num1Index++;
        } else {
            newArray[index] = nums2[num2Index];
            num2Index++;
        }
        index++;
    }
    //2.find out middle 2 number
    if (newArray.length % 2 == 0) {
        let midIndex = Math.floor(newArray.length / 2);
        let midIndex2 = midIndex - 1;
        let value1 = newArray[midIndex];
        let value2 = newArray[midIndex2];
        //console.log(mid);
        console.log((value1 + value2) / 2);
        return (value1 + value2) / 2;
    } else {
        let midIndex = Math.floor(newArray.length / 2);
        console.log(newArray[midIndex]);
        return newArray[midIndex];
    }
};