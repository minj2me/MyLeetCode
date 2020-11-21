/**
 * 273. Integer to English Words
 * https://leetcode.com/problems/integer-to-english-words/description/
 * 
 * https://www.programcreek.com/2014/05/leetcode-integer-to-english-words-java/
 * 
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"

 */
/**
 * @param {number} num
 * @return {string}
 */
/**
 * @param {number} num
 * @return {string}
 */
var numberToWords = function (num) {
    //Runtime: 72 ms
    //时间复杂度: O(n)；空间复杂度: O(1)
    let map = new Map();
    let str = "";
    fillWord(map);
    if (num == 0)
        return map.get(0);
    if (num >= 1000000000) {
        let extra = num / 1000000000;
        //extra = Math.floor(extra);
        str += convert(extra, map) + " Billion";//10亿
        num = num % 1000000000;//get new num after exchanged
    }
    if (num >= 1000000) {
        let extra = num / 1000000;
        //console.log("Million extra:"+extra);
        str += convert(extra, map) + " Million";
        num = num % 1000000;
    }
    if (num >= 1000) {
        let extra = num / 1000;
        //extra = Math.floor(extra);
        //console.log("Thousand extra:"+extra);
        str += convert(extra, map) + " Thousand";
        num = num % 1000;
    }
    if (num > 0)
        str += convert(num, map)

    return str.trim();
};

var convert = function (num, map) {
    let str = "";
    num = Math.floor(num);
    //console.log("num:"+num);
    if (num >= 100) {
        let numHundrea = num / 100;
        numHundrea = Math.floor(numHundrea);
        //console.log("numHundrea:" + numHundrea);
        str += " " + map.get(numHundrea) + " Hundred";
        num = num % 100;
    }
    if (num > 0) {
        if (num > 0 && num <= 20)
            str += " " + map.get(num);
        else {
            let numTen = num / 10;
            numTen = Math.floor(numTen);
            str += " " + map.get(numTen * 10);
            let numOne = num % 10;
            numOne = Math.floor(numOne);
            if (numOne > 0)
                str += " " + map.get(numOne);
        }
    }
    return str;
}

var fillWord = function (map) {
    map.set(0, "Zero");
    map.set(1, "One");
    map.set(2, "Two");
    map.set(3, "Three");
    map.set(4, "Four");
    map.set(5, "Five");
    map.set(6, "Six");
    map.set(7, "Seven");
    map.set(8, "Eight");
    map.set(9, "Nine");
    map.set(10, "Ten");
    map.set(11, "Eleven");
    map.set(12, "Twelve");//twelve
    map.set(13, "Thirteen");//thirteen
    map.set(14, "Fourteen");//fourteen
    map.set(15, "Fifteen");//fiveteen
    map.set(16, "Sixteen");//sixteen
    map.set(17, "Seventeen");//seventeen
    map.set(18, "Eighteen");//eighteen
    map.set(19, "Nineteen");//nineteen
    map.set(20, "Twenty");//twenty
    map.set(30, "Thirty");//thirty
    map.set(40, "Forty");//forty
    map.set(50, "Fifty");//fifty
    map.set(60, "Sixty");
    map.set(70, "Seventy");
    map.set(80, "Eighty");
    map.set(90, "Ninety");
};