package LeetCode_914

/**
 * 914. X of a Kind in a Deck of Cards
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
 *
 * In a deck of cards, each card has an integer written on it.
Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards,
where:
Each group has exactly X cards.
All the cards in each group have the same integer.

Example 1:
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:
Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.

Constraints:
1 <= deck.length <= 10^4
0 <= deck[i] < 10^4
 * */
class Solution {
    /*
    * solution: HashMap, calculate each deck of group, then check if can has exactly X cards
    * Time complexity:O(n), Space complexity:O(n)
    * */
    fun hasGroupsSizeX(deck: IntArray): Boolean {
        if (deck == null || deck.isEmpty()) {
            return false
        }
        val map = HashMap<Int, Int>()
        for (item in deck) {
            map.put(item, map.getOrDefault(item, 0) + 1)
        }
        var countInGroup = Int.MAX_VALUE
        for (item in map) {
            countInGroup = Math.min(countInGroup, item.value)
        }
        //if each group cannot exactly 2 cards, return false
        if (countInGroup < 2) {
            return false
        }
        //keep check if each card has save group size
        for (i in 2..countInGroup) {
            var can = true
            for (item in map) {
                //check if they all can divisible by i, if can, mean all have same group size
                if (item.value % i != 0) {
                    can = false
                    break
                }
            }
            if (can) {
                return true
            }
        }
        return false
    }
}