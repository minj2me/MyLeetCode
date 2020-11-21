/**
 * 745. Prefix and Suffix Search
 * https://leetcode.com/problems/prefix-and-suffix-search/description/
 * 
 * Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). 
It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
 */

//let map = new Map();
let input = [];

/**
 * @param {string[]} words
 */
var WordFilter = function (words) {
    /*let prefixArr = [];
    let suffixArr = [];
    for (let k = 0; k < words.length; k++) {
        let word = words[k];
        //add all prefix
        for (let i = 0; i <= word.length; i++) {
            //forexample: a, ap,app
            prefixArr.push(word.substring(0, i));
        }
        //add all suffix
        for (let i = word.length; i >= 0; i--) {
            suffixArr.push(word.substring(i));
        }

        for (let pre of prefixArr) {
            for (let suf of suffixArr) {
                let key = pre + "|" + suf;
                if (map.get(key) == null || map.get(key) == undefined)
                    map.set(key, k);
                // }else {
                //    map.set(key, Math.max(map.get(key), k));
                // }
            }
        }
    }*/
    input = words;
};

/** 
 * @param {string} prefix 
 * @param {string} suffix
 * @return {number}
 */
WordFilter.prototype.f = function (prefix, suffix) {
    // if (map.has(prefix + "|" + suffix))
    //     return map.get(prefix + "|" + suffix);
    // return -1;

    for (let i = 0; i < input.length; i++) {
        if (input[i].startsWith(prefix) && input[i].endsWith(suffix))
            return i;
    }
    return -1;
};

/** 
 * Your WordFilter object will be instantiated and called as such:
 * var obj = Object.create(WordFilter).createNew(words)
 * var param_1 = obj.f(prefix,suffix)
 */