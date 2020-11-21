package LeetCode_1275

/**
 * 1275. Find Winner on a Tic Tac Toe Game
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/
 *
 * Example 1:
Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"

Constraints:
1 <= moves.length <= 9
moves[i].length == 2
0 <= moves[i][j] <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.
 * */
class Solution {
    fun tictactoe(moves: Array<IntArray>): String {
        val n = 3
        val rows = IntArray(n)
        val cols = IntArray(n)
        var dia1 = 0
        var dia2 = 0
        //A is 1
        var player = 1

        for (move in moves) {
            val x = move[0]
            val y = move[1]
            rows[x] += player
            cols[y] += player
            //diagonal from top left to right bottom
            if (x == y) {
                dia1 += player
            }
            //diagonal from top right to left bottom
            if (x == n - y - 1) {
                dia2 += player
            }
            //change player every turn
            player *= -1
        }

        for (i in 0 until n) {
            if (rows[i] == n || cols[i] == n || dia1 == n || dia2 == n) {
                return "A"
            }
            if (rows[i] == -n || cols[i] == -n || dia1 == -n || dia2 == -n) {
                return "B"
            }
        }

        if (moves.size < n * n) {
            return "Pending"
        } else {
            return "Drawing"
        }
    }
}