/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * https://www.cnblogs.com/grandyang/p/4606920.html
 * 这道题让我们移除链表倒数第N个节点，限定n一定是有效的，即n不会大于链表中的元素总数。
 * 还有题目要求我们一次遍历解决问题，那么就得想些比较巧妙的方法了。
 * 比如我们首先要考虑的时，如何找到倒数第N个节点，由于只允许一次遍历，
 * 所以我们不能用一次完整的遍历来统计链表中元素的个数，而是遍历到对应位置就应该移除了。
 * 那么我们需要用两个指针来帮助我们解题，pre和cur指针。
 * 首先cur指针先向前走N步，如果此时cur指向空，说明N为链表的长度，则需要移除的为首元素，
 * 那么此时我们返回head->next即可，如果cur存在，我们再继续往下走，此时pre指针也跟着走，
 * 直到cur为最后一个元素时停止，此时pre指向要移除元素的前一个元素，我们再修改指针跳过需要移除的元素即可
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function (head, n) {
    //56 ms
    if (head == null) return null;
    if (head.next == null) return null;
    let pre = head, cur = head;
    for (let i = 0; i < n; i++)
        cur = cur.next;
    if (cur == null){
        //如果此时cur指向空，说明N为链表的长度，则需要移除的是首元素
        return head.next;
    }
    while (cur.next) {
        cur = cur.next;
        pre = pre.next;
    }
    //console.log(head);head in here is not change
    pre.next = pre.next.next;
    //console.log(head);but in here is had change.!!!why?!!
    return head;
}