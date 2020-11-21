package `LeetCode_96`

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * https://www.cnblogs.com/grandyang/p/4299608.html
 * 卡特兰数
 * 令h(0)=1,h(1)=1，catalan数满足递推式 [2]  ：
h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)*h(0) (n>=2)
例如：h(2)=h(0)*h(1)+h(1)*h(0)=1*1+1*1=2
h(3)=h(0)*h(2)+h(1)*h(1)+h(2)*h(0)=1*2+1*1+2*1=5
 * https://baike.baidu.com/item/%E5%8D%A1%E7%89%B9%E5%85%B0%E6%95%B0
 *
 * Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 * */
class Solution {
    fun numTrees(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            for (j in 0..(i - 1)) {
                dp[i] += dp[j] * dp[i - j - 1]
            }
        }
        return dp[n]
    }
}