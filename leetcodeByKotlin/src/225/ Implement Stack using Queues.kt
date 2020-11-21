package LeetCode_225

import java.util.*

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * Implement the following operations of a stack using queues.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Example:
MyStack stack = new MyStack();
stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
 * */
class MyStack() {
    /*
    * solution: push into Queue, then reverse all element
    * */
    /** Initialize your data structure here. */
    val queue = LinkedList<Int>()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue.push(x)
        for (i in queue.indices) {
            queue.push(queue.pop())
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        //pop out the last element after reversed
        return queue.pop()
    }

    /** Get the top element. */
    fun top(): Int {
        return queue.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queue.isEmpty()
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */