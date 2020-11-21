package LeetCode_678

/**
 * 678. Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/description/
 *
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
 * */
class Solution {
    fun checkValidString(s: String): Boolean {
        if (s == "") {
            return true
        }
        /*
        * 我们把星号都当成左括号，此时用经典的验证括号的方法，即遇左括号计数器加1，遇右括号则自减1，如果中间某个时刻计数器小于0了，直接返回false。
        * 如果最终计数器等于0了，我们直接返回true，
        * 因为此时我们把星号都当作了左括号，可以跟所有的右括号抵消。
        * 而此时就算计数器大于0了，我们暂时不能返回false，
        * 因为有可能多余的左括号是星号变的，星号也可以表示空，所以有可能不多，我们还需要反向q一下，哦不，是反向遍历一下，
        * 这时我们将所有的星号当作右括号，遇右括号计数器加1，遇左括号则自减1，如果中间某个时刻计数器小于0了，直接返回false。
        * 遍历结束后直接返回true，这是为啥呢？
        * 此时计数器有两种情况，要么为0，要么大于0。为0不用说，肯定是true，
        * 为啥大于0也是true呢？因为之前正向遍历的时候，我们的左括号多了，我们之前说过了，多余的左括号可能是星号变的，也可能是本身就多的左括号。
        * 本身就多的左括号这种情况会在反向遍历时被检测出来，如果没有检测出来，说明多余的左括号一定是星号变的。
        * 而这些星号在反向遍历时又变做了右括号，最终导致了右括号有剩余，所以当这些星号都当作空的时候，左右括号都是对应的，即是合法的。
        * 你可能会有疑问，右括号本身不会多么，其实不会的，如果多的话，会在正向遍历中被检测出来
        * */
        //soluton 1: two pointer, left and right
        val l = s.length
        var left = 0
        var right = 0
        //scan left to right
        for (i in 0 until l) {
            if (s[i] == '(' || s[i] == '*') {
                left++
            } else {
                left--
            }
            if (left < 0) {
                return false
            }
        }
        //此时计数器有两种情况，要么为0，要么大于0。为0不用说，肯定是true，
        if (left == 0) {
            return true
        }
        //而此时就算计数器大于0了，我们暂时不能返回false
        //scan right to left
        //因为有可能多余的左括号是星号变的，星号也可以表示空，所以有可能不多，我们还需要反向遍历一下
        for (i in l - 1 downTo 0) {
            //这时我们将所有的星号当作右括号，遇右括号计数器加1，遇左括号则自减1，如果中间某个时刻计数器小于0了，直接返回false。
            if (s[i] == ')' || s[i] == '*') {
                right++
            } else {
                right--
            }
            if (right < 0) {
                return false
            }
        }
        return true

        //solution 2: DP, Button-Up

    }
}