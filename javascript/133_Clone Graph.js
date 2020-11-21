/**
 * Definition for undirected graph.
 * function UndirectedGraphNode(label) {
 *     this.label = label;
 *     this.neighbors = [];   // Array of UndirectedGraphNode
 * }
 */

/**
 * @param {UndirectedGraphNode} graph
 * @return {UndirectedGraphNode}
 */
var cloneGraph = function (graph) {
    if (graph == null)
        return null;
    let map = new Map(),stack = [],head = new UndirectedGraphNode(graph.lable);
    map.set(graph, head);
    stack.push(graph);
    while (stack.length > 0) {
        let curnode = stack.pop();
        //for (let aneighbor in curnode.neighbors){//check each neighbor
        let curNeighbors = curnode.neighbors;
        for (let i = 0; i < curNeighbors.length; i++) {
            let aneighbor = curNeighbors[i];
            if (!map.has(aneighbor)) {//if not visited, push to stack
                stack.push(aneighbor);
                let newNeighbor = new UndirectedGraphNode(aneighbor.label);
                map.set(aneighbor, newNeighbor);
            }
            map.get(curnode).neighbors.push(map.get(aneighbor));
        }
    }
    return head;
};