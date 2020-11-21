/**
 * 282. Expression Add Operators
 * https://leetcode.com/problems/expression-add-operators/description/
 * https://www.cnblogs.com/grandyang/p/4814506.html
 * 
 * Given a string that contains only digits 0-9 and a target value, 
 * return all possibilities to add operators +, -, or * between the digits so they evaluate to the target value.

Examples: 

"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
/**
 * @param {string} num
 * @param {number} target
 * @return {string[]}
 */
var addOperators = function (num, target) {
    var result = new Array();
    help(num, target, "", 0, 0, result);
    //console.log("result:"+result);
    return result;
};
var help = function (num, target, temp, current, last, result) {
    if (current == target && num.length == 0) {
        //console.log("temp:"+temp);
        //result+=temp+"|";
        result.push(temp);
        return;
    }
    for (let i = 1; i <= num.length; i++) {
        let currentStr = num.substring(0, i);
        if (currentStr.length > 1 && currentStr.charAt(0) == "0")
            return;
        let currentNum = parseFloat(currentStr);
        // console.log("currentStr:"+currentStr);
        let next = num.substring(i);
        // console.log("next:"+next);
        if (temp == "") {
            help(next, target, currentStr, currentNum, currentNum, result);
        } else {
            help(next, target, temp + "*" + currentNum, (current - last) + last * currentNum, last * currentNum, result);
            help(next, target, temp + "+" + currentNum, current + currentNum, currentNum, result);
            help(next, target, temp + "-" + currentNum, current - currentNum, -currentNum, result);
        }
    }
}