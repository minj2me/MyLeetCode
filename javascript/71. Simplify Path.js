/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/description/
 * https://www.cnblogs.com/grandyang/p/4347125.html
 * 
 * Given an absolute path for a file (Unix-style), simplify it. 

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
path = "/a/../../b/../c//.//", => "/c"
path = "/a//b////c/d//././/..", => "/a/b/c"

path = "/a/./b/../c/", => "/a/c"
path = "/a/./b/c/", => "/a/b/c"

In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path. 
Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was. 
For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style

Corner Cases:

Did you consider the case where path = "/../"?, In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */
/**
 * @param {string} path
 * @return {string}
 * 
 * 我们从example中可以知道中间是"."的情况直接去掉，是".."时删掉它上面挨着的一个路径，而下面的边界条件给的一些情况中可以得知，
 * 如果是空的话返回"/"，如果有多个"/"只保留一个。那么我们可以把路径看做是由一个或多个"/"分割开的众多子字符串，把它们分别提取出来一一处理即可
 */
var simplifyPath = function (path) {
    let stack = [];
    let arr = path.split("/");
    for (let ch of arr) {
        // console.log(ch);
        // console.log(stack);
        if (stack.length > 0 && ch === "..")
            stack.pop();//".."时删掉它上面挨着的一个路径
            /**
             * 如/a/./b/../../c/
             * 入了a,b,当遇到..时会先弹出a,再遇到..,又弹出b
             */
        else if (ch !== "." && ch !== "" && ch !== "..")
            stack.push(ch);
    }
    return "/" + stack.join("/");
};