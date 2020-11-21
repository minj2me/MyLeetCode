package LeetCode_721

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 721. Accounts Merge
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * Given a list accounts, each element accounts[i] is a list of strings,
 * where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
Now, we would like to merge these accounts.
Two accounts definitely belong to the same person if there is some email that is common to both accounts.
Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
A person can have any number of accounts initially, but all of their accounts definitely have the same name.
After merging the accounts, return the accounts in the following format:
the first element of each account is the name, and the rest of the elements are emails in sorted order.
The accounts themselves can be returned in any order.

Example 1:
Input:
accounts = [
["John", "johnsmith@mail.com", "john00@mail.com"],
["John", "johnnybravo@mail.com"],
["John", "johnsmith@mail.com", "john_newyork@mail.com"],
["Mary", "mary@mail.com"]
]
Output:
[
["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]
]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

Note:
The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
 * */
class Solution {
    /*
    * solution:BFS, Time complexity:O(m*n), Space complexity:O(m*n)
    * */
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val result = ArrayList<ArrayList<String>>()
        val graph = HashMap<String, ArrayList<String>>()
        //create graph
        //key is email, value is name
        val emailToName = HashMap<String, String>()
        for (account in accounts) {
            for (i in 1 until account.size) {
                //create mapping for email to name
                emailToName.put(account[i], account[0])

                //create connect of first email with all email
                if (!graph.contains(account[1])) {
                    graph.put(account[1], ArrayList())
                }
                graph.get(account[1])!!.add(account[i])

                if (!graph.contains(account[i])) {
                    graph.put(account[i], ArrayList())
                }
                graph.get(account[i])!!.add(account[1])
            }
        }
        //println(emailToName)
        //println(graph)
        val visited = HashMap<String, Boolean>()
        for (g in graph) {
            if (visited.contains(g.key)) {
                continue
            }
            val temp = ArrayList<String>()
            //push name as first string
            temp.add(emailToName[g.key]!!)
            val queue = LinkedList<String>()
            queue.offer(g.key)
            visited.put(g.key, true)
            //do bfs via queue
            while (queue.isNotEmpty()) {
                val cur = queue.poll()
                temp.add(cur)
                //println("temp.add($cur)")
                for (email in graph[cur]!!) {
                    if (!visited.contains(email)) {
                        visited.put(email, true)
                        queue.offer(email)
                    }
                }
            }
            temp.sort()
            result.add(temp)
        }
        //println(result)
        return result
    }
}