//https://www.jb51.net/article/40269.htm
//gm g=global, m=multiLine ， 大致上方法就是这样的，可以实现替换全部指定字串
String.prototype.replaceAll = function (s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
}


//Predict the output of the following program 
//https://codelab.interviewbit.com/dashboard/?s_id=149591
var Predict = function () {
    let A = [
    /*0行*/[1, 2, 3, 4],
    /*1行*/[5, 6, 7, 8],
    /*2行*/[9, 10, 11, 12]];
    let m = A.length
    //console.log("A.length:" + m);
    let n = A[0].length
    //console.log("A[0].length:" + n);
    let B = []
    for (let i = 0; i < m; i++) {
        B.push(new Array(n));
        for (let j = 0; j < n; j++) {
            console.log("A[" + i + "][" + j + "]:" + A[i][j]);
            console.log("n - 1 - j:" + (n - 1 - j));
            B[i][n - 1 - j] = A[i][j]
        }
    }
    /**
     [4, 3, 2, 1]
     [8, 7, 6, 5]
     [12, 11, 10, 9]
     * 
     */
    //console.log(B);
    for (let i = 0; i < B.length; i++) {
        for (let j = 0; j < B[i].length; j++)
            //4 3 2 1 8 7 6 5 12 11 10 9 
            console.log(B[i][j] + " ");
    }
    return B
}

//Given nums = [1,1,2]
var removeDuplicates = function (nums) {
    let unique_array = [];
    for (let i = 0; i < nums.length; i++) {
        if (unique_array.indexOf(nums[i]) == -1)
            unique_array.push(nums[i]);
    }
    return unique_array;
},

/**
 * Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
var rotateArray = function (nums, k) {
    //reverse() 颠倒数组中元素的顺序。
    //pop() 方法用于删除并返回数组的最后一个元素。
    //shift() 删除并返回数组的第一个元素。
    //unshift() 向数组的开头添加一个或更多元素，并返回新的长度。
    //concat() 连接两个或更多的数组，并返回结果。

    //96 ms
    // if (k <= 0) {
    //     nums = nums;
    //     console.log(nums);
    //     return;
    // }
    // let len = nums == null ? 0 : nums.length;
    // if (len < k && len < 3) {
    //     for (let i = 0; i < k; i++)
    //         nums.push(nums.shift());
    // } else {
    //     for (let i = 0; i < k; i++)
    //         nums.unshift(nums.pop());
    // }
    // console.log(nums);

    //124 ms
    // var step = k % nums.length;
    // for (var i = 0; i < step; i++) {
    //     var value = nums.pop();
    //     nums.unshift(value);
    // }

    //96 ms
    let size = nums.length;
    if (size < 1)
        return;
    let step = k % size;
    //console.log(step);
    for (let i = 0; i < step; i++) {
        let temp = nums.pop();
        nums.unshift(temp);
    }
    //console.log(nums);
},

////Given an array of integers, return true if the array contains any duplicates.
var containsDuplicate = function (nums) {
    let hasDuplicate = false;
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j])
                hasDuplicate = true;
        }
    }
    console.log(hasDuplicate);
    return hasDuplicate;
},

//异或运算，两个相同的数，异或的结果是0，一直异或最后剩下的就是结果
var singleNumber = function (nums) {
    var res = 0;
    for (var i = 0; i < nums.length; i++) {
        res = res ^ nums[i];
    }
    console.log(res);
    return res;
},

//实现一个函数，输入一个正数，输出该数二进制表示中1的个数。
/**
 * 这里用到了这样一个知识点：把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0 。
 *  那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
总结：把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把整数的二进制表示中的最右边一个1变成0 。
 */
var getOneCount = function (n) {
    let num = 0;
    while (n) {
        n &= (n - 1);
        num++;
    }
    return num;
},

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
   *  Given two arrays, write a function to compute their intersection.
    Example:
    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]. 
   */
var intersect = function (nums1, nums2) {
    //sort first
    nums1.sort(function (a, b) { return a - b });
    nums2.sort(function (a, b) { return a - b });
    let index1 = 0, index2 = 0, map = new Map(), result = [];
    while (index1 < nums1.length && index2 < nums2.length) {
        if (nums1[index1] < nums2[index2]) {
            index1++;
        } else if (nums1[index1] > nums2[index2]) {
            index2++;
        } else {
            //found
            //if (result.indexOf(nums2[index2]==-1))
            // result.push(nums2[index2]);
            if (map.get(nums2[index2]) == undefined)
                map.set(nums2[index2], nums2[index2])
            index1++;
            index2++;
        }
    }
    //console.log(map);
    for (let m of map) {
        result.push(m[0]);
        //let key = m[0];
        //let valueObj = m[1];//the object saved in map
    }
    return result;
    //console.log("result:" + result.sort(function (a, b) { return a - b }));
},

/**
 * 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* @param {number[]} nums
* @return {void} Do not return anything, modify nums in-place instead.
*/
var moveZeroes = function (nums) {
    //124ms
    // let zeroArray = [], result = [], numsLength = nums.length;
    // let index = 0, foundZero = false;
    // for (; index < numsLength; index++) {
    //     if (foundZero)
    //         index = 0;//找到0就从头来过
    //     if (nums[index] == 0) {
    //         //splice中第一个参数是删除的起始索引,第二个参数是删除元素的个数。
    //         nums.splice(index, 1);//delete zero in nums array,这种nums长度会变的，影响了外层的loop的结果
    //         //delete nums[i];//这种方式数组长度不变,此时arnumsr[i]变为undefined了
    //         zeroArray.push(0);
    //         //index = 0;
    //         foundZero = true;
    //     } else
    //         foundZero = false;
    // }//end for
    // //result = nums.concat(zeroArray);
    // for (let i = 0; i < zeroArray.length; i++) {
    //     nums.push(zeroArray[i]);
    // }
    // console.log(result);

    //64ms
    // var indexArr = [], i;
    // for(i = 0; i < nums.length; i++){
    //      if(nums[i] === 0){
    //          indexArr.push(i);
    //     }
    // }
    // for(i = indexArr.length - 1; i >= 0; i--){
    //     nums.splice(indexArr[i], 1);
    // }
    // for(i = 0; i < indexArr.length; i++){
    //     nums.push(0);
    // }

    //64 ms
    let s = 0;
    for (let e = 0; e < nums.length; e++) {
        if (nums[e] == 0)
            continue;
        nums[s++] = nums[e];
        //console.log(nums[e]);
    }
    //before is [0,1,0,3,12], nums is [ 1, 3, 12, 3, 12 ] now
    for (; s < nums.length; s++)
        nums[s] = 0;

    console.log(nums);
},

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]} indexs
 */
var twoSum = function (nums, target) {
    //192 ms
    // for (let i = 0; i < nums.length; i++) {
    //     for (let j = i + 1; j < nums.length; j++) {
    //         if (nums[i] + nums[j] == target) {
    //             return [i, j];
    //         }
    //     }
    // }

    //92 ms
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let needToFind = target - nums[i];
        if (map.has(needToFind)) {
            return [map.get(needToFind), i];
        }
        map.set(nums[i], i);
    }
    return "not found";
},

/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function (s) {
    return s.split("").reverse().join("");
};

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    let num = 0;
    let s = x.toString();
    console.log(s);
    if (x > 0) {
        num = parseInt(s.split("").reverse().join(""));
    } else {
        num = 0 - (parseInt(s.split("").reverse().join("")));
    }
    //int: -2147483648～2147483647
    //Math.pow(2, 31) = 2147483647;
    //溢出的整数时
    //pow(x,y)方法可返回 x 的 y 次幂的值。
    if (num > Math.pow(2, 31) || -num > Math.pow(2, 31)) {
        num = 0;
    }
    console.log(num);
    return num;
};

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function (s) {
    var map = new Map();
    for (var i = 0; i < s.length; i++) {
        let key = s[i];
        let valueObj = {};
        if (map.get(key) == undefined) {
            //如果没添加过的，value设为1
            valueObj.value = 1;
            valueObj.index = i;
            map.set(key, valueObj);
        } else {
            //如果存在的，将value++后再保存
            let valueObj = map.get(key);
            valueObj.value++;
            map.set(key, valueObj);
        }
    }
    let result = -1;
    for (let m of map) {
        //let key = m[0];
        let valueObj = m[1];//the object saved in map
        if (valueObj.value == 1) {
            //表示无重复的value,再把它的index返回
            result = valueObj.index;
            break;
        }
    }
    console.log("result:" + result);
    return result;
};

/**
 * 判断两个string在排序后是相同的
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Input: s = "anagram", t = "nagaram"
Output: true
Input: s = "rat", t = "car"
Output: false
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    //116 ms
    if (s == "" && t == "")
        return true;
    let sLength = s.length;
    let tLength = t.length;
    if (sLength != tLength)
        return false;

    let sNumArray = [], tNumArray = [];
    for (let i = 0; i < sLength; i++) {
        //console.log(s[i].charCodeAt());
        sNumArray.push(s[i].charCodeAt());
        tNumArray.push(t[i].charCodeAt());
    }
    sNumArray.sort(function (a, b) { return a - b })
    // console.log(sNumArray.sort(function (a, b) { return a - b }));

    // for (let i = 0; i < tLength; i++) {
    //   tNumArray.push(t[i].charCodeAt());
    // }
    tNumArray.sort(function (a, b) { return a - b })
    // console.log(tNumArray.sort(function (a, b) { return a - b }));

    let sNumArrayStr, tNumArrayStr;
    sNumArrayStr = sNumArray.join();
    tNumArrayStr = tNumArray.join();
    // console.log(sNumArrayStr);
    // console.log(tNumArrayStr);
    return sNumArrayStr == tNumArrayStr;
};

/**
 * Valid Panlindrome
 * @param {*} s 
 */
var isPalindrome = function (s) {
    if (s == "") return true;
    var low = s.replace(/\W/g, '').toLowerCase();//去掉所有标点符号并转到小写
    console.log(low);//amanaplanacanalpanama
    //112ms,两个指针scan
    let left = 0, right = low.length - 1;
    while (left < right) {
        if (low[left] != low[right])
            return false;
        left++;
        right--;
    }
    return true;
};

/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @param {*} haystack 
 * @param {*} needle 
 */
var strStr = function (haystack, needle) {
    //56 ms
    if (needle === "")
        return 0;
    let result = -1, needleLength = needle.length;
    for (let index = 0; index < haystack.length; index++) {
        //如找到入口
        if (haystack[index] == needle[0]) {
            //substring(start,stop)
            //http://www.w3school.com.cn/jsref/jsref_substring.asp
            //从haystack取出跟needle同长度的string进行对比

            //use js.substring was 56 ms！！！
            //let key = haystack.substring(index, index + needleLength);

            //implement substring, below substring need 7s!!!!
            let key = "";
            let l = index;
            let stop = index + needleLength;
            while (l < stop) {
                key += haystack.charAt(l);
                l++;
            }
            //////end
            //console.log("key:" + key);
            if (key == needle) {
                result = index;
                break;
            }
        }
    }
    console.log(result);
    return result;
};

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
 * @param {number} n
 * @return {string}
 */
var countAndSay = function (n) {

};

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
    if (strs === null || strs.length === 0) return "";
    let first = strs[0], i = 1;
    while (i < strs.length) {
        //match with the first letter , if not found, loop to find again
        while (strs[i].indexOf(first) !== 0) {
            first = first.substring(0, first.length - 1);
        }
        i++;
    }
    console.log(first);
    return first;
};

/**
 * find target in 2d array
 */
var FindInArray = function (target, array) {
    //2分查找
    let low = array.length;
    let j = 0, i = low - 1;
    while (i >= 0 && array[i][j]) {
        if (array[i][j] < target)
            j++;
        else if (array[i][j] > target)
            i--;
        else
            return true;
    }
    return false;
}

/**
 * Given a string, find the length of the longest substring without repeating characters.
Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    //596 ms!!!!
    let length = s.length;
    let longest = 0;
    for (let i = 0; i < length; i++) {
        let substring = "";
        let subI = i;
        while (subI < length) {
            if (substring.indexOf(s[subI]) == -1) {
                substring += s[subI];
            } else
                break;
            subI++;
        }
        if (substring.length > longest)
            longest = substring.length;
    }
    console.log("longest:" + longest);
    return longest;
};

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5

 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    //140 ms!!!
    //1.merge two array
    let newArray = [];
    let length = nums1.length + nums2.length;
    let num1Index = 0, num2Index = 0, index = 0;
    while (index < length) {
        //https://wsvincent.com/javascript-merge-two-sorted-arrays/
        let isArr1Depleted = num1Index >= nums1.length;
        let isArr2Depleted = num2Index >= nums2.length;

        if (!isArr1Depleted && (isArr2Depleted || (nums1[num1Index] < nums2[num2Index]))) {
            newArray[index] = nums1[num1Index];
            num1Index++;
        } else {
            newArray[index] = nums2[num2Index];
            num2Index++;
        }
        index++;
    }
    //console.log(newArray);
    //2.find out middle 2 number
    let midIndex = Math.floor(newArray.length / 2);
    if (newArray.length % 2 == 0) {
        let midIndex2 = midIndex - 1;
        let value1 = newArray[midIndex];
        let value2 = newArray[midIndex2];
        //console.log(mid);
        console.log((value1 + value2) / 2);
        return (value1 + value2) / 2;
    } else {
        console.log(newArray[midIndex]);
        return newArray[midIndex];
    }
};

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * Implement atoi which converts a string to an integer.
 * @param {*} str 
 */
var myAtoi = function (str) {
    var sign = '+'; //正負號
    var numReg = /^[0-9]/;

    //將前面的空白字串去掉,  ex. "^^^^-122a" -> "-122a" (^代表空白) 
    var i = 0;
    while (str.charAt(i) == ' ' && i < str.length) {
        i++;
    }
    str = str.slice(i);

    //處理正負號, ex. "-122a" -> "122a"
    if (str.startsWith('+')) {
        str = str.slice(1);
    } else if (str.startsWith('-')) {
        str = str.slice(1);
        sign = '-';
    }

    //處理後的字串不是數字開頭,代表字串不合法 
    if (!numReg.test(str)) return 0;

    //出現不是數字的符號就中斷
    var j = 0;
    while (j < str.length && numReg.test(str[j])) {
        j++;
    };
    // 截出開頭的數字字串, ex. '122a' -> '122'
    str = str.substr(0, j);

    //字串轉成int
    var value = parseInt(sign + str);
    if (value > 2147483647) {
        return 2147483647;
    }
    if (value < -2147483648) {
        return -2147483648;
    }
    return value;
};

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let map = new Map();
    for (let i = 0; i < nums.length; i++) {
        let needToFind = target - nums[i];
        if (map.has(needToFind)) {
            return [map.get(needToFind), i];
        }
        map.set(nums[i], i);
    }
    return "not found";
};

/**
   *使用双指针，一个 left，一个 right，前者从最左侧开始，只能向右移动；后者相反，从最右侧开始，只能向左移动。
   * 如果 sum 大于目标值，那么 right 左移；如果 sum 小于目标值，那么 left 右移。
   */
var twoSum2 = function (nums, target) {
    let result = [];
    if (nums == null || nums.length < 1)
        return result;
    let start = 0, end = nums.length - 1;
    nums.sort(function (a, b) { return a - b });
    //console.log(nums);
    while (start < end) {
        if (nums[start] + nums[end] > target)
            end--;
        else if (nums[start] + nums[end] < target)
            start++;
        else {
            //found
            result.push([nums[start], nums[end]]);
            start++;
            end--;
            while (nums[start] == nums[start - 1])
                start++;
            while (nums[end] == nums[end + 1])
                end--;
            // while (start < end && nums[start] == nums[start - 1])
            //     start++;
            // while (start < end && nums[end] == nums[end + 1])
            //     end--;
        }
    }
    console.log(result);
};

/**
 * https://leetcode.com/problems/3sum/description/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.
Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
var threeSum = function () {
    //time: O(n平方)
    //space: O(n)
    // 220 ms!!!
    let result = new Array();
    if (nums.length < 3)
        return result;
    let target = 0;
    //result[0] = [];
    let start = 0, end = nums.length - 1;
    //sort it first
    nums.sort(function (a, b) { return a - b });
    for (let i = 0; i < nums.length; i++) {
        if (i != 0 && nums[i] == nums[i - 1])//avoid duplicate
            continue;
        start = i + 1;
        end = nums.length - 1;
        while (start < end) {
            let tempValue = nums[i] + nums[start] + nums[end];
            if (tempValue > target)
                end--;
            else if (tempValue < target)
                start++;
            else {
                //found
                result.push([nums[i], nums[start], nums[end]]);
                //以下为去重作用
                start++;
                end--;
                while (nums[start] == nums[start - 1])
                    start++;
                while (nums[end] == nums[end + 1])
                    end--;
                // while (start < end && nums[start] == nums[start - 1])
                //     start++;
                // while (start < end && nums[end] == nums[end + 1])
                //     end--;
            }
        }
    }
    //console.log(result);
    return result;
};

/**
 * https://leetcode.com/problems/4sum/description/
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
Note:ß
The solution set must not contain duplicate quadruplets.
Example:
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @param {*} nums 
 * @param {*} target 
 */
var fourSum = function (nums, target) {
    //120 ms
    let result = new Array();
    let start = 0, end = nums.length - 1;
    //sort it first
    nums.sort(function (a, b) { return a - b });
    for (let i = 0; i < nums.length; i++) {
        if (i != 0 && nums[i] == nums[i - 1])//avoid duplicate
            continue;
        for (let j = i + 1; j < nums.length; j++) {
            if (j != i + 1 && nums[j] == nums[j - 1])//avoid duplicate
                continue;
            start = j + 1;
            end = nums.length - 1;
            while (start < end) {
                let tempValue = nums[i] + nums[j] + nums[start] + nums[end];
                if (tempValue > target)
                    end--;
                else if (tempValue < target)
                    start++;
                else {
                    result.push([nums[i], nums[j], nums[start], nums[end]]);
                    //!!!below is why!!??
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                }
            }
        }
    }
    console.log(result);
    return result;
};

//第一题输入是一个array, 有正数和负数，题目要求将正数移动到一侧，负数移动到另一侧。Linear Time
var moveInteger = function (nums) {
    let len = nums.length;
    let lessThanZeroArr = [], biggerThanZeroArr = [];
    if (len == 1)
        return nums
    for (let i = 0; i < len; i++) {
        if (nums[i] < 0) {
            lessThanZeroArr.push(nums[i]);
        } else {
            biggerThanZeroArr.push(nums[i]);
        }
    }
    //return lessThanZeroArr.concat(biggerThanZeroArr);
    console.log(lessThanZeroArr.concat(biggerThanZeroArr));
}

// 第二道题输入一个sorted array, 问某一个target的出现次数。
// 用二分搜索找到第一次和最后一次出现位置就好了。.
var findTargetOccurrenceCount = function (srotedArray) {
    let left = 0, right = srotedArray.length - 1;
    let matchCount = 0;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let midVal = srotedArray[mid];
        // console.log("midVal:"+midVal);
        // console.log("left:"+left);
        // console.log("right:"+right);
        if (target > midVal) {
            left = mid + 1;
        } else if (target < midVal)
            right = mid - 1;
        else {
            //return mid;
            //found out the first occurrence, loop to found again if had another
            matchCount++;
            if (srotedArray[mid] == srotedArray[mid + 1]) {
                left = mid;
                right = srotedArray.length - 1;
            } else
                return matchCount;
        }
    }
    return -1;
}

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 *  not the kth distinct element.
Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function (nums, k) {
    //280 ms!!! bad if use bubbleSort
    //bubbleSort(nums);
    //156 ms if use quickSort
    quickSort(nums, 0, nums.length - 1);
    let index = nums.length - k;
    console.log(nums[index]);
};

var bubbleSort = function (nums) {
    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
                let temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
};

var swap = function (arr, i, j) {
    let temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
};

var quickSort = function (arr, low, high) {
    if (low < high) {
        /* pi is partitioning index, arr[pi] is 
              now at right place */
        let storeIndex = quickSortPartition(arr, low, high);
        // Recursively sort elements before
        // partition and after partition
        quickSort(arr, low, storeIndex - 1);
        quickSort(arr, storeIndex + 1, high);
    }
};

/* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
var quickSortPartition = function (arr, low, high) {
    let pivot = arr[high];//// 直接选最右边的元素为基准元素
    //let i = low - 1;//index of smaller element
    let storeIndex = low;//index of smaller element
    for (let i = low; i < high; i++) {
        // If current element is smaller than or equal to pivot
        if (arr[i] < pivot) {
            //swap arr[i] and arr[j]
            swap(arr, storeIndex, i);
            storeIndex++;
        }
    }
    swap(arr, high, storeIndex);
    return storeIndex;
};

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
    //52 ms
    let result = [];
    if (digits == null)
        return result;
    //try dfs
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
    console.log(result);
};
var letterCombinationsDFS = function (digits, map, index, cur, result) {
    if (index == digits.length) {
        //here need new reference
        let cur_ = "";
        for (let i = 0; i < cur.length; i++)
            cur_ += cur[i]
        result.push(cur_);
        console.log("result.push(" + cur_ + ")");
        return;
    }
    //如digits==23,递归会先处理完a,再到b,再到c
    /**
ndex:0, i:0, a
index:1, i:0, d
result.push(ad)
index:1, i:1, e
result.push(ae)
index:1, i:2, f
result.push(af)
=================
index:0, i:1, b
index:1, i:0, d
result.push(bd)
index:1, i:1, e
result.push(be)
index:1, i:2, f
result.push(bf)
=================
index:0, i:2, c
index:1, i:0, d
result.push(cd)
index:1, i:1, e
result.push(ce)
index:1, i:2, f
result.push(cf)
=================
=================
[ 'ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce', 'cf' ]
     */
    let codeArray = map.get(parseInt(digits.charAt(index)));
    for (let i = 0; i < codeArray.length; i++) {
        cur[index] = codeArray[i];
        letterCombinationsDFS(digits, map, index + 1, cur, result);
    }
    console.log("=================");
};

/**
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/description/
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
 */
var isMatch = function (s, p) {
    if (p == "") return true;
};

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {

};