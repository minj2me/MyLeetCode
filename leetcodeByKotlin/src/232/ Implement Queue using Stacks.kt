package LeetCode_232

import java.util.*

/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/description/
 *
 * Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
 * */
class MyQueue() {

    /** Initialize your data structure here. */
    val stack = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        stack.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        val firstElement = stack.get(0)
        stack.removeAt(0)
        return firstElement
    }

    /** Get the front element. */
    fun peek(): Int {
        return stack.get(0)
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return stack.isEmpty()
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */