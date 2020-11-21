/**
 * 68. Text Justification
 * https://leetcode.com/problems/text-justification/description/
 * https://www.cnblogs.com/grandyang/p/4350381.html
 * fixing!!!
 * 
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully
 *  (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. 
If the number of spaces on a line do not divide evenly between words, 
the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed ßmaxWidth.
The input array words contains at least one word.

Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 */
/**
 * @param {string[]} words
 * @param {number} maxWidth
 * @return {string[]}
 */
/**
 * @param {string[]} words
 * @param {number} maxWidth
 * @return {string[]}
 */
var fullJustify = function (words, maxWidth) {
    let result = [];
    let len = words.length;
    let i = 0, pointer = 0;
    let str = "";
    let array1 = [];

    let totalStringCount = getStringCount(words);
    while (len > i) {
        //console.log(i);
        str += words[i] + " ";
        if (str.length > maxWidth) {
            //console.log("1:" + str);
            //console.log("i:"+i);
            let start = pointer, end = i;
            array1 = words.slice(start, end);
            result.push(array1);
            //console.log(array1);
            str = "";
            pointer = i;
            //console.log("pointer:"+pointer);
            i--;
        }
        i++;
    }
    let count2 = getStringCount(array1);
    if (count2 < totalStringCount) {
        result.push(words.slice(pointer, len));
    }
    //console.log(result);
    return setResultArray(result, maxWidth);
};
var getStringCount = function (array) {
    let string = "";
    for (let i = 0; i < array.length; i++) {
        string += array[i];
    }
    return string.length;
};
var setResultArray = function (array, maxWidth) {
    let result = [];
    for (let i = 0; i < array.length; i++) {
        let subArray = array[i];
        let string = "";
        for (let i = 0; i < subArray.length; i++) {
            string += subArray[i] + " ";
        }
        //console.log(string);
        let len = subArray.length;
        let needSpaceCount = maxWidth - len;
        let eachSpaceCount = Math.floor(needSpaceCount / subArray.length);

        if (i == (array.length - 1)) {
            let space = "";
            for (let j = 0; j < eachSpaceCount; j++)
                space += " ";
            result.push(string + space);
        } else {
            let string2 = "";
            for (let i = 0; i < subArray.length; i++) {
                let len = subArray[i].length;
                let needSpaceCount = maxWidth - len;
                let eachSpaceCount = needSpaceCount / len - 1;
                if (eachSpaceCount <= 0)
                    eachSpaceCount = 1;
                console.log("eachSpaceCount:" + eachSpaceCount);
                let space = "";
                for (let j = 0; j < eachSpaceCount; j++)
                    space += " ";
                string2 += subArray[i] + (i == (subArray.length - 1) && subArray.length > 1 ? "" : space);
                // if (i == (subArray.length - 1)) {
                //     for (let j = 0; j < eachSpaceCount; j++)
                //         space += " ";
                //     result.push(subArray[i] + space);
                // } else {

                // }
            }
            result.push(string2);
        }
    }
    //console.log(result);
    return result;
};