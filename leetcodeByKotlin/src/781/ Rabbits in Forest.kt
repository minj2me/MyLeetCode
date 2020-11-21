package LeetCode_781

/**
 * 781. Rabbits in Forest
 * https://leetcode.com/problems/rabbits-in-forest/
 *
 * In a forest, each rabbit has some color.
 * Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them.
 * Those answers are placed in an array.
Return the minimum number of rabbits that could be in the forest.
 * */
class Solution {
    fun numRabbits(answers: IntArray): Int {
        /*var res = 0
        val map = HashMap<Int, Int>()
        for (answer in answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1)
        }
        for (n in map.keys) {
            val count = map.get(n)!!
            val group = count / (n + 1)
            res += if (count % (n + 1) != 0) (group + 1) * (n + 1) else group * (n + 1)
        }
        return res*/

        var total = 0
        if (answers.size == 0)
            return total
        val count = HashMap<Int, Int>()
        for (answer in answers) {
            if (count.containsKey(answer)) {
                var a = count.get(answer)!!
                if (a <= answer)
                    count.put(answer, a + 1)
                else {
                    total += answer + 1
                    count.put(answer, 1)
                }
            } else {
                total += answer + 1
                count.put(answer, 1)
            }
        }
        return total
    }
}