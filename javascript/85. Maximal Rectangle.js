/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/description/
 * https://www.cnblogs.com/grandyang/p/4322667.html
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
 */
/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function (matrix) {
    //1.get the rectangle
    //2.caculate the largest one of rectangle
    let result = 0;
    //1.get the rectangle
    //2.caculate the largest one of rectangle
    for (let i = 0; i < matrix.length; i++) {
        let heights = [];
        for (let j = 0; j < matrix[i].length; j++) {
            heights[j] = getHeight(i, j, matrix);
        }
        /**
         * old one:
         *  ["1", "0", "1", "0", "0"],
          ["1", "0", "1", "1", "1"],
          ["1", "1", "1", "1", "1"],
          ["1", "0", "0", "1", "0"]
         *new one: console.log(heights);
         *(5) [1, 0, 1, 0, 0]
          (5) [2, 0, 2, 1, 1]
          (5) [3, 1, 3, 2, 2]
          (5) [4, 0, 0, 3, 0]
         */
        result = Math.max(largestRectangle(heights), result);
    }
    return result;
};

var getHeight = function (line, column, matrix) {
    if (matrix[line][column] == '0')
        return 0;
    let height = 1;
    for (let i = line - 1; i >= 0; i--) {
        if (matrix[i][column] == '0')
            break;
        height++;
    }
    return height;
};

var largestRectangle = function (heights) {
    let result = 0;
    for (let i = 0; i < heights.length; i++) {
        if (heights[i] < heights[i + 1])
            continue;
        let minH = heights[i];
        for (let j = i; j >= 0; j--) {
            minH = Math.min(minH, heights[j]);
            //长方型面积=长*宽,minH为长,
            let area = minH * (i - j + 1);
            result = Math.max(result, area);
        }
    }
    //console.log(result);
    return result;
}