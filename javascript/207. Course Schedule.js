/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/description/
 * https://www.programcreek.com/2014/05/leetcode-course-schedule-java/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
    let visit = new Array(numCourses).fill(0);
    let map = new Map();
    for (let a of prerequisites) {
        //console.log(p);
        if (map.has(a[1])) {
            map.get(a[1]).push(a[0]);
        } else {
            let l = [];
            l.push(a[0]);
            map.set(a[1], l);
        }
    }
    //console.log(map);
    for (let i = 0; i < numCourses; i++) {
        if (!canFinishDFS(map, visit, i)) {
            return false
        }
    }
    return true;
};
var canFinishDFS = function (map, visit, i) {
    if (visit[i] == -1)
        return false;
    if (visit[i] == 1)
        return true;

    visit[i] = -1;
    if (map.has(i)) {
        for (let j of map.get(i)) {
            if (!canFinishDFS(map, visit, j))
                return false;
        }
    }
    visit[i] = 1;
    return true;
};