/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/description/
 * 
 * 我们能想到的方法就是算一个候选值的平方，然后和x比较大小，为了缩短查找时间，我们采用二分搜索法来找平方根
 */
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function (x) {
    if (x <= 1)
        return x;
    let left = 0, right = x;
    while (left + 1 < right) {
        //let mid = left + (right - left) / 2;
        let mid = left + parseInt((right - left) / 2);
        //console.log("mid:"+mid);
        if (mid * mid <= x)
            left = mid;
        else
            right = mid;
    }
    // console.log("left:"+left);
    // console.log("right:"+right);
    return left;
};