package LeetCode_278

/**
 * 278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version.
You should minimize the number of calls to the API.

Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:
Input: n = 1, bad = 1
Output: 1

Constraints:
1. 1 <= bad <= n <= 2^31 - 1
 * */

open class VersionControl {
    open fun firstBadVersion(n: Int): Int {
        return 0
    }

    fun isBadVersion(n: Int): Boolean {
        return true
    }
}

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 0
        var right = n - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (isBadVersion(mid)) {
                //because we have to find the first one, so set the right bound now, and the left is the answer
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}