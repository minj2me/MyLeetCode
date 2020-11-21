package LeetCode_277

/**
 * 277. Find the Celebrity
 * (Prime)
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one.
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
You are given a helper function bool knows(a, b) which tells you whether A knows B.
Implement a function int findCelebrity(n).
There will be exactly one celebrity if he/she is in the party.
Return the celebrity's label if there is a celebrity in the party.
If there is no celebrity, return -1.
 * */
class Solution {
    /*
    * solution: compare two times, Time complexity:O(n), Space complexity:O(1)
    * */
    fun findCelebrity(peoples: IntArray): Int {
        var result = 0
        //check the first time, fount out some one maybe a celebrity
        for (people in peoples) {
            //if a knows b (now result is a, people is b), so update people to result, result maybe a celerity
            //because just one people is celebrity
            if (knows(result, people)) {
                result = people
            }
        }

        for (people in peoples) {
            //if some one knows the people or people didn't him, he is not a celebrity
            if (people != result && (knows(result, people) || !knows(people, result))) {
                return -1
            }
        }

        return result
    }

    //whether a knows b
    private fun knows(a: Int, b: Int): Boolean {
        return false
    }
}