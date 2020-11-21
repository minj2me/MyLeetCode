package LeetCode_155

import java.util.*

/**
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 *
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
class MinStack() {

    /** initialize your data structure here. */
    //use two stack, the first is saving regular, the second is saving the min

    val stack = Stack<Int>()
    val stackMin = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (stackMin.isEmpty() || stackMin.peek() >= x) {
            stackMin.push(x)
        }
    }

    fun pop() {
        //val x = stack.pop() as Int
        if (stack.pop() == stackMin.peek()) {
            stackMin.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return stackMin.peek()
    }

}

/**
 * push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it.
If you find more than one maximum elements, only remove the top-most one.
 * */
class MaxStack() {
    val stack = Stack<Int>()
    val stackMax = Stack<Int>()

    fun push(x: Int) {
        stack.push(x)
        if (stackMax.isEmpty() || x >= stackMax.peek()) {
            stackMax.push(x)
        }
    }

    fun pop() {
        //当s2的栈顶元素和s1的栈顶元素相同时，我们要移除s2的栈顶元素，因为一个数字不在s1中了，就不能在s2中。
        //然后取出s1的栈顶元素，并移除s1，返回即可。
        if (stack.pop() == stackMax.peek()) {
            stackMax.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun peekMax(): Int {
        return stackMax.peek()
    }

    /*
    *  maxStack.push(5)
            maxStack.push(5)
            maxStack.push(1)
            maxStack.push(2)
            maxStack.push(3)
            maxStack.push(5)
   在popMax()函数中，先将s2的栈顶元素保存到一个变量mx中，然后我们要在s1中删除这个元素，
   由于栈无法直接定位元素，所以我们用一个临时栈t，将s1的出栈元素保存到临时栈t中，
   当s1的栈顶元素和s2的栈顶元素相同时退出while循环，
   此时我们在s1中找到了s2的栈顶元素，
   分别将s1和s2的栈顶元素移除，然后要做的是将临时栈t中的元素加回s1中
    * */
    fun popMax(): Int {
        val max = stackMax.peek()
        //need to delete the same value(max) in stack also
        val temp = Stack<Int>()
        //loop to until found out the same
        while (stack.peek() != stackMax.peek()) {
            val value = stack.pop()
            temp.push(value)

        }
        stackMax.pop()
        stack.pop()
        //set back the stack
        while (temp.isNotEmpty()) {
            val value = temp.pop()
            stack.push(value)
            //println("stack.push($value)")
        }
        return max
    }

    fun popMax_(): Int {
        val max = stackMax.peek()
        var sameMax = 0
        var index = 0
        while (index != stack.size) {
            //println(stack.get(index))
            if (max == stack.get(index)) {
                sameMax = max
                break
            }
            index++
        }
        stack.remove(sameMax)
        print(stack)
        return max
    }

    private fun print(stack: Stack<Int>) {
        var index = 0
        while (index != stack.size) {
            println(stack.get(index))
            index++
        }
    }
}
