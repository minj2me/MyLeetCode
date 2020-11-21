/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {

};

/**
 * https://wenda.so.com/q/1385712848065729?src=130
 * Count the number of prime numbers less than a non-negative number, n.
 * Input: 10
    Output: 4
    Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * @param {*} n 
 */
var countPrimes = function (n) {
    let primes = [];
    for (let i = 2; i < n; i++)
        primes[i] = true;
    for (let i = 2; i < n; i++) {
        if (primes[i]) {
            //例如 2，3，5，7 是质数(素数)，而 4，6，8，9 则不是，
            // 将i的2倍、3倍、4倍...都标记为非素数
            for (j = i * 2; j < n; j = j + i) {
                primes[j] = false;
            }
        }
    }
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (primes[i])
            count++;
    }
    console.log(count);
    return count
}

/**
 * determine the num if Primes
 * @param {*} num 
 */
var isPrimes = function (num) {
    if (num <= 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;
    for (let i = 2; i < num; i++) {
        //console.log(num % i);
        if (num % i == 0)
            return false;
    }
    return true;
}

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/description/
 * @param {number} n
 * @return {boolean}
 * 1     2       4         8         16 　　....
    1    10    100    1000    10000　....
    那么我们很容易看出来2的次方数的二进制都只有一个1，剩下的都是0
https://www.cnblogs.com/grandyang/p/4623394.html
 * //n右移一位: n/2;
      //n左移一位: n*2;
       按位与运算将两个运算分量的对应位按位遵照以下规则进行计算：
     0 & 0 = 0, 0 & 1 = 0, 1 & 0 = 0, 1 & 1 = 1
      //n&1: 如n=3,3的二进制表示为00000011,所以 3&1=1
 */
var isPowerOfTwo = function (n) {
    let ret = 0;
    while (n > 0) {
        ret += (n & 1);
        n = n >> 1;//n除2
    }
    console.log(ret);
    return ret == 1;
};

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/description/
 * @param {number} n
 * @return {boolean}
 * 最直接的方法就是不停地除以3，看最后的余数是否为1，要注意考虑输入是负数和0的情况
 */
var isPowerOfThree = function (n) {
    while (n && n % 3 == 0) {
        n = n / 3;
        //console.log(n);
    }
    return n == 1;
};

/**
 * 342. Power of Four
 * https://leetcode.com/problems/power-of-four/description/
 * @param {number} num
 * @return {boolean}
 * 最直接的方法就是不停地除以4，看最后的余数是否为1，要注意考虑输入是负数和0的情况
 */
var isPowerOfFour = function(num) {
    while (num && num % 4 == 0) {
        num = num / 4;
    }
    return num == 1;
};