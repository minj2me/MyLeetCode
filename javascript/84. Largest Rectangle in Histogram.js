/**
 * 84. Largest Rectangle in Histogram
https://leetcode.com/problems/largest-rectangle-in-histogram/description/
http://www.cnblogs.com/grandyang/p/4322653.html

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.
 

Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

/**
* @param {number[]} heights
* @return {number}
*/
var largestRectangleArea = function (heights) {
    let result = 0;
    for (let i = 0; i < heights.length; i++) {
        if (heights[i] < heights[i + 1])
            continue;
        let minH = heights[i];
        for (let j = i; j >= 0; j--) {
            //取出short一点的值来计算
            minH = Math.min(minH, heights[j]);
            //长方型面积=长*宽,minH为长,
            let area = minH * (i - j + 1);
            result = Math.max(result, area);
        }
    }
    return result;
};