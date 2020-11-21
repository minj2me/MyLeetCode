package LeetCode_1472

import java.util.*

/**
 * 1472. Design Browser History
 * https://leetcode.com/problems/design-browser-history/description/
 *
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 *
Implement the BrowserHistory class:
1. BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
2. void visit(string url) Visits url from the current page. It clears up all the forward history.
3. string back(int steps) Move steps back in history.
    If you can only return x steps in the history and steps > x, you will return only x steps.
    Return the current url after moving back in history at most steps.
4. string forward(int steps) Move steps forward in history.
    If you can only forward x steps in the history and steps > x, you will forward only x steps.
    Return the current url after forwarding in history at most steps.
 * */
class BrowserHistory(homepage: String) {
    /*
    * solution: two stack to save back and forward, and keep currentUrl
    * */
    val stackBack = Stack<String>()
    val stackForward = Stack<String>()
    var currentUrl = ""

    init {
        currentUrl = homepage
    }

    fun visit(url: String) {
        //clears up all the forward history
        stackForward.clear()
        stackBack.add(currentUrl)
        currentUrl = url
    }

    fun back(steps: Int): String {
        var steps_ = steps
        while (steps_ > 0 && stackBack.isNotEmpty()){
            //add current to forward
            stackForward.add(currentUrl)
            currentUrl = stackBack.pop()
            steps_--
        }
        return currentUrl
    }

    fun forward(steps: Int): String {
        var steps_ = steps
        while (steps_ > 0 && stackForward.isNotEmpty()){
            //add current to back
            stackBack.add(currentUrl)
            currentUrl = stackForward.pop()
            steps_--
        }
        return currentUrl
    }
}
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */