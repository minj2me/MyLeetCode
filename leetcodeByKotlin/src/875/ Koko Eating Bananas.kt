package LeetCode_875

/**
 * 875. Koko Eating Bananas
 * https://leetcode.com/problems/koko-eating-bananas/description/
 *
 * Koko loves to eat bananas. There are N piles of bananas, the i-th pile has piles[i] bananas.
 * The guards have gone and will come back in H hours. Koko can decide her bananas-per-hour eating speed of K.
 * Each hour, she chooses some pile of bananas, and eats K bananas from that pile.
 * If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
Return the minimum integer K such that she can eat all the bananas within H hours.

Example 1:
Input: piles = [3,6,7,11], H = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], H = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], H = 6
Output: 23

Constraints:
1. 1 <= piles.length <= 10^4
2. piles.length <= H <= 10^9
3. 1 <= piles[i] <= 10^9
 * */
class Solution {
    /*
    * Solution 1:keep tracking to check the speed if can finish, Time complexity:O(n), Space complexity:O(1)
    * Solution 2:Binary Search,
    * https://leetcode.com/problems/koko-eating-bananas/discuss/764687/Simple-Java-solution-for-slow-learners-like-myself
    * https://just4once.gitbooks.io/leetcode-notes/content/leetcode/binary-search/875-koko-eating-bananas.html
    * */
    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var sum = 0L
        for (pile in piles) {
            sum += pile
        }
        var speed = (sum - 1) / H + 1L
        while (true) {
            if (canFinish(piles, H, speed)) {
                return speed.toInt()
            } else {
                speed++
            }
        }
    }

    private fun canFinish(piles: IntArray, H: Int, speed: Long): Boolean {
        //speed is how many pile can eat per hour
        var hour = 0L
        for (pile in piles) {
            hour += (pile - 1) / speed + 1
        }
        return hour <= H
    }
}