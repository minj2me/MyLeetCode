/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
    let result = [];
    if (digits == null || digits == "")
        return result;
    let map = new Map();
    map.set(1, "");
    map.set(2, ["a", "b", "c"]);
    map.set(3, ["d", "e", "f"]);
    map.set(4, ["g", "h", "i"]);
    map.set(5, ["j", "k", "l"]);
    map.set(6, ["m", "o", "n"]);
    map.set(7, ["p", "q", "r", "s"]);
    map.set(8, ["t", "u", "v"]);
    map.set(9, ["w", "x", "y", "z"]);
    let cur = [];
    //let cur = new Map();
    letterCombinationsDFS(digits, map, 0, cur, result);
    //console.log(result);
    return result;
};
var letterCombinationsDFS = function (digits, map, index, cur, result) {
    if (index == digits.length) {
        result.push(cur);
        return;
    }
    let codeArray = map.get(parseInt(digits.charAt(index)));
    //console.log("====codeArray:"+codeArray);
    for (let i = 0; i < codeArray.length; i++) {
        //console.log("index:"+index);
        //console.log("cur["+index+"] = "+codeArray[i]);
        cur[index] = codeArray[i];
        letterCombinationsDFS(digits, map, index + 1, cur.concat(), result);

    }
};