/**
 * Lock by leetcode
 * 
 * 261. Graph Valid Tree
 * https://www.lintcode.com/problem/graph-valid-tree/description
 * https://www.cnblogs.com/grandyang/p/5257919.html
 * 
 * Description
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
var validTree = function (n, edges) {
    /*
    根据pair来建立一个图的结构，用邻接链表来表示
    0->1,2,3
    1->0,4
    2->0
    3->0
    4->1
    */
    let map = new Map();
    for (let i = 0; i < n; i++) {
        let list = new Array();
        map.set(i, list);
    }
    for (let edge of edges) {
        map.get(edge[0]).push(edge[1]);
        map.get(edge[1]).push(edge[0]);
    }
    //console.log(map);
    let visit = new Array(n).fill(false);
    if (!validTreeHelp(0, -1, map, visit))
        return false;
    for (let v of visit) {
        if (!v)
            return false;
    }
    return true;
};

var validTreeHelp = function (cur, parent, map, visit) {
    if (visit[cur])
        return false;
    visit[cur] = true;
    console.log(map.get(cur));
    for (let i of map.get(cur)) {
        console.log(i);
        if (i != parent && !this.validTreeHelp(i, cur, map, visit))
            return false;//说明图不是完全连通的
    }
    return true;
};