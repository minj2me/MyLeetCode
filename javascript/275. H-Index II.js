/**
 * 275. H-Index II
 * https://leetcode.com/problems/h-index-ii/description/
 * https://www.cnblogs.com/grandyang/p/4782695.html
 */
/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function (citations) {
    let len = citations.length, left = 0, right = len - 1;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        if (citations[mid] == len - mid)
            return len - mid;
        else if (citations[mid] > len - mid)
            right = mid - 1;
        else
            left = mid + 1;
    }
    return len - left;
};