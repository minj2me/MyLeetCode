/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/description/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
    //console.log(s);
    //use stack
    //Runtime: 1464 ms!!!!
    let stack = [];
    //console.log(stack.length);
    //console.log(s.length);
    //如果是左括号时入stack,否则出stacks
    for (let i = 0; i < s.length; i++) {
        //console.log(s[i]);
        if (s[i] == '(' || s[i] == '{' || s[i] == '[')
            stack.push(s[i]);
        else {
            //如果({[都没进来
            if (stack.length == 0) {
                return false;
            }
            let lastIndex = stack.length - 1;
            //not match
            if (s[i] != ')' && stack[lastIndex] == '(') {
                return false;
            }
            if (s[i] != '}' && stack[lastIndex] == '{') {
                return false;
            }
            if (s[i] != ']' && stack[lastIndex] == '[') {
                return false;
            }
            stack.pop();
        }
    }
    //console.log(stack);
    console.log(stack.length);
    return stack.lenth == 0;
};