/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * 
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
 */
/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
    let size = s.length;
    let res = 0, currentRes = 0, num = 0;
    let op = '+';
    for (let i = 0; i < size; i++) {
        let c = s.charAt(i);
        if (c >= '0' && c <= '9') {
            c = c - '0';
            num = num * 10 + c;//handle full of number situation
            //num=c;
        }
        if (c == '+' || c == '-' || c == '*' || c == '/' || i == size - 1) {
            switch (op) {
                case '+':
                    currentRes += num;
                    break;
                case '-':
                    currentRes -= num;
                    break;
                case '*':
                    currentRes *= num;
                    break;
                case '/':
                    currentRes /= num;
                    currentRes = parseInt(currentRes);
                    break;
            }
            if (c == '+' || c == '-' || i == size - 1) {
                res += currentRes;
                currentRes = 0;
            }
            op = c;
            num = 0;
        }
    }
    //console.log(res);
    return res;
};