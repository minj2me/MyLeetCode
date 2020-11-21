/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 * https://www.cnblogs.com/grandyang/p/4091064.html
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

let array = null, array2 = null;
/**
 * initialize your data structure here.
 */
var MinStack = function () {
    array = new Array();
    //array2 for handle minnum
    array2 = new Array();
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
    array.unshift(x);//insert x into top
    if (array2.length == 0)
        array2.unshift(x);
    else {
        let top = array2[0];
        if (x<=top)
            array2.unshift(x);
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
    //array.shift();
    if (array[0] == array2[0])
        array2.shift();
    array.shift();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
    return array[0];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
    return array2[0];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */