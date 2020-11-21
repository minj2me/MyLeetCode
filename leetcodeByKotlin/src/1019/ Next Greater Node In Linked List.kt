package LeetCode_1019

/**
 *1019. Next Greater Node In Linked List
https://leetcode.com/problems/next-greater-node-in-linked-list/description/

Example 1:
Input: [2,1,5]
Output: [5,5,0]

Example 2:
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]

Example 3:
Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
 * */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private fun printNode(head: ListNode?) {
        var head_ = head
        while (head_ != null) {
            print(head_.`val`)
            if (head_.next != null) {
                print("->")
            }
            head_ = head_!!.next
        }
        println("")
    }

    fun nextLargerNodes(head: ListNode?): IntArray {
        //printNode(head_)
        var head_ = head
        val result = ArrayList<Int>()
        val temp = ArrayList<Int>()
        while (head_ != null) {
            temp.add(head_.`val`)
            head_ = head_!!.next
        }
        ////4,3,2,5,1,8,10
        for (i in 0 until temp.size) {
            println("i:$i")
            if (i == (temp.size - 1)) {
                result.add(0)
                break
            }
            if (temp[i] < temp[i + 1]) {
                result.add(temp[i + 1])
            } else {
                //find the next greater until to the end
                val newTemp = temp.subList(i, temp.size)
                for (item in newTemp) {
                    println("newItem:$newTemp")
                }
                val newMax = help(temp[i], newTemp)//find the first one which greater that temp[i]
                if (temp[i] < newMax!!) {
                    result.add(newMax)
                } else {
                    result.add(0)
                }
            }
        }
        for (item in result) {
            println(item)
        }
        return result.toIntArray()
    }

    private fun help(value: Int, list: MutableList<Int>): Int {
        for (item in list) {
            if (item > value)
                return item
        }
        return Int.MIN_VALUE
    }
}