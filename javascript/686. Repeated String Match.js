/**
 * 686. Repeated String Match
 * https://leetcode.com/problems/repeated-string-match/description/
 * https://www.cnblogs.com/grandyang/p/7631434.html
 * 
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 */
/**
 * @param {string} A
 * @param {string} B
 * @return {number}
 */
var repeatedStringMatch = function (A, B) {
    let count = 1;
    let t = A;
    while (t.length < B.length) {
        t += A;
        count++;
    }
    if (t.indexOf(B) != -1)
        return count;
    t += A;
    return t.indexOf(B) != -1 ? count + 1 : -1;
};