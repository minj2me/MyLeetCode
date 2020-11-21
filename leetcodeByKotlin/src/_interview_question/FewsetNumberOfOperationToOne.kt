package _interview_question

import java.util.*

/**
 * The question is to find the fewest number of operations needed to get to 1.
available operations:
- add 1
- subtract 1
- divide by 2

Example 1:
input: 15, output: 5,
because: 15->16->8->4->2->1

Example 2:
input: 10, output: 4,
because: 10->5->4->3->2->1

Have any constraints?
 * */
class HelpNode(var value: Double) {
    var step: Int = 0
}

class Solution10 {
    /*
      solution:bfs, Time complexity:O(3^n), Space complexity:O(n)
    * */
    fun getToOne(num: Int): Int {
        val queue = LinkedList<HelpNode>()
        val node = HelpNode(num.toDouble())
        queue.offer(node)
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            if (cur.value == 1.0) {
                return cur.step
            }
            val add = cur.value + 1
            val subtract = cur.value - 1
            val divide = cur.value / 2//because divide, so we need double to keep correct
            //println("divide:${divide}")

            val addNode = HelpNode(add)
            addNode.step = cur.step + 1
            queue.offer(addNode)

            val subtractNode = HelpNode(subtract)
            subtractNode.step = cur.step + 1
            queue.offer(subtractNode)

            val divideNode = HelpNode(divide)
            divideNode.step = cur.step + 1
            queue.offer(divideNode)
        }
        return -1
    }
}