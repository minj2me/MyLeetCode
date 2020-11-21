/**
 * 477. Total Hamming Distance
 * https://leetcode.com/problems/total-hamming-distance/description/
 * https://www.cnblogs.com/grandyang/p/6208062.html
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:

Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 */
/**
 * @param {number[]} nums
 * @return {number}
 */
var totalHammingDistance = function (nums) {
    let res = 0, len = nums.length;
    for (let bit = 0; bit < 32; bit++) {
        let cnt = 0
        for (let i = 0; i < nums.length; i++) {
            let n = nums[i];
            //console.log("1<<"+bit+"&"+n+": "+((1<<bit)&n));
            if (n & (1 << bit))
                cnt++;
        }
        res += cnt * (len - cnt);
    }
    //console.log(res);
    return res;
}; 