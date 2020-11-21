/**
 * Lock by Leetcode
 * 
 * 408. Valid Word Abbreviation
 * https://www.lintcode.com/problem/valid-word-abbreviation/description
 * https://www.cnblogs.com/grandyang/p/5930369.html
 * 
 * Description
Given a non-empty string word and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string word. 
Any other string is not a valid abbreviation of word.

Example 1:

Given s = "internationalization", abbr = "i12iz4n":
Return true.

Example 2:

Given s = "apple", abbr = "a2e":
Return false.
 */

/**
* @param word: a non-empty string
* @param abbr: an abbreviation
* @return: true if string matches with the given abbr or false
*/
const validWordAbbreviation = function (word, abbr) {
    let i = 0, j = 0;
    let wordLen = word.length, abbrLen = abbr.length;
    while (i < wordLen && j < abbrLen) {
        if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
            if (abbr.charAt(j) == '0')
                return false;
            let val = 0;
            while (j < abbrLen && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                //如果是连续的数字，处理进位
                val = val * 10 + (abbr.charAt(j++) - '0');
            }
            //console.log(val);
            i += val;
        } else {
            if (word.charAt(i++) != abbr.charAt(j++))
                return false;
        }
    }
    return i == wordLen && j == abbrLen;
}
