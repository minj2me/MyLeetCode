/**
 * Lock by leetcode
 * 286. Walls and Gates
 * https://www.lintcode.com/problem/walls-and-gates/description
 */
/**
 * @param rooms: m x n 2D grid
 * @return: 
 */
const wallsAndGates = function (rooms) {
    let m = rooms.length, n = rooms[0].length;
    //console.log(result);
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            //start scan when find the door
            if (rooms[i][j] == 0)
                dfs(i, j, rooms, 0);
        }
    }
    return rooms;
}

var dfs = function (x, y, rooms, val) {
    //console.log("n:"+n);
    if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] < val)
        return;
    //console.log(rooms[x][y]);
    rooms[x][y] = val;
    dfs(x + 1, y, rooms, val + 1);
    dfs(x, y + 1, rooms, val + 1);
    dfs(x - 1, y, rooms, val + 1);
    dfs(x, y - 1, rooms, val + 1);
}
