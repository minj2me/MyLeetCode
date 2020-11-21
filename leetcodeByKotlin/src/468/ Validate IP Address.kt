package LeetCode_468

/**
 * 468. Validate IP Address
 * https://leetcode.com/problems/validate-ip-address/description/
 *
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":").
For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Example 1:
Input: IP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".

Example 2:
Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
 * */
class Solution {
    /*
    * solution: check each group if match for ip4 and ip6, Time:O(n), Space:(1)
    * */
    val hexdigits = "0123456789abcdefABCDEF"

    fun validIPAddress(IP: String): String {
        if (isIP4(IP)) {
            return "IPv4"
        }
        if (isIP6(IP)) {
            return "IPv6"
        }
        return "Neither"
    }

    private fun isIP4(str: String): Boolean {
        //ip4 have 4 group
        val group = str.split(".")
        if (group.size != 4) {
            return false
        }
        for (g in group) {
            if (g.isEmpty()) {
                return false
            }
            if (g[0] == '0' && g.length > 1) {
                return false
            }
            if (g.isNotEmpty() && g.length >= 4) {
                return false
            }
            //for example: 127, sum up is:127
            var sum = 0
            for (c in g) {
                if (!c.isDigit()) {
                    return false
                }
                sum *= 10
                sum += (c - '0')
            }
            //because number in ip address is 1-255
            if (sum < 0 || sum > 255) {
                return false
            }
        }
        return true
    }

    private fun isIP6(str: String): Boolean {
        //ip6 have 8 group
        val group = str.split(":")
        if (group.size != 8) {
            return false
        }
        for (g in group) {
            if (g.isEmpty() || g.length > 4) {
                return false
            }
            //hex only
            if (!isHexDigits(g)) {
                return false
            }
        }
        return true
    }

    private fun isHexDigits(str: String): Boolean {
        for (c in str) {
            if (hexdigits.indexOf(c) == -1) {
                return false
            }
        }
        return true
    }
}