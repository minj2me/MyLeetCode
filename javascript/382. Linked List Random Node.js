/**
 * 382. Linked List Random Node
 * https://leetcode.com/problems/linked-list-random-node/description/
 * https://www.cnblogs.com/yaoyudadudu/p/9237333.html
 * 
 * Given a singly linked list, return a random node's value from the linked list. 
 * Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
 */

let current = null;

/**
 * @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
 * @param {ListNode} head
 */
var Solution = function (head) {
    current = head;
};

/**
 * Returns a random node's value.
 * @return {number}
 */
Solution.prototype.getRandom = function () {
    let res = current.val;
    let cur = current.next;
    let i = 2;//why is 2???
    while (cur != null) {
        let ran = Math.floor(Math.random() * Math.pow(2, 31));
        if (ran % i == 0)
            res = cur.val;
        i++;
        cur = cur.next
    }
    return res;
};

/** 
 * Your Solution object will be instantiated and called as such:
 * var obj = Object.create(Solution).createNew(head)
 * var param_1 = obj.getRandom()
 */