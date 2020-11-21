/**
 * Lock by Leetcode
 * 
 * 277. Find the Celebrity
 * https://www.lintcode.com/problem/find-the-celebrity/description
 * http://www.cnblogs.com/Dylan-Java-NYC/p/5343739.html
 */
var findCelebrity = function (n) {
    let celebrity = 0;
    for (let i = 0; i < n; i++) {
        if (knows(celebrity, i)) {
            celebrity = i;
        }
    }
    for (let i = 0; i < n; i++) {
        if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity)))
            return -1;
    }
    return celebrity;
}