/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/description/
 * https://www.cnblogs.com/grandyang/p/4781203.html
 */
/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function (citations) {
    citations.sort(function (a, b) { return b - a });
    //console.log(citations);
    for (let i = 0; i < citations.length; i++) {
        if (citations[i] <= i)
            return i;
    }
    return citations.length;
};