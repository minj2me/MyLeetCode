package LeetCode_249

/**
 * 249. Group Shifted Strings
 * (Prime)
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:
Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output:
[
["abc","bcd","xyz"],
["az","ba"],
["acef"],
["a","z"]
]
 * */
class Solution {
    /*
    * solution: HashMap, save list of string with same key
    * n: size fo array
    * l: length of string
    * Time complexity:O(n*l), Space complexity:O(n)
    * */
    fun groupStrings(strings: Array<String>): List<List<String>> {
        val result = ArrayList<ArrayList<String>>()
        //key: the string that each letter has same ascii offset
        //value: ArrayList, contains string with same key
        val map = HashMap<String, ArrayList<String>>()
        for (string in strings) {
            //use first char for the offset
            var key = ""
            val offset = string[0] - 'a'
            for (c in string) {
                var char = c - offset
                //if char not a letter, need add 26,let change to letter
                //for example: ` to z
                if (char < 'a') {
                    char += 26
                }
                key += char
            }
            if (!map.contains(key)) {
                map.put(key, ArrayList())
            }
            map.get(key)!!.add(string)
        }
        for (item in map) {
            result.add(item.value)
        }
        return result
    }
}