package LeetCode_684

/**
 * LeetCode_146
 * https://leetcode.com/problems/redundant-connection/description/
 * https://www.youtube.com/watch?v=4hJ721ce010&list=LLaIZDn4w2rZnhRNMRMelhfg
 * */
class Solution {

    class UnionFindSet constructor(N: Int) {
        private var parents_: IntArray? = null
        //记录触点的个数
        private var ranks_: IntArray? = null
        private var count = 0

        init {
            count = N
            //初始化分量数组
            parents_ = IntArray(count + 1)
            for (i in parents_!!.indices) {
                parents_?.set(i,i)
            }
            ranks_ = IntArray(count + 1)
            //每个触点都是独立的一个分量，每个分量的大小都是1
            ranks_?.fill(1)
        }

        /**
         * merge sets that contains u and v
         * return true if merged, false if v and v are already in one set
         * */
        /*fun union(u: Int, v: Int): Boolean {
            val pu = find(u)
            val pv = find(v)
            if (pu == pv) {
                return false
            }

            if (ranks_!![pv] > ranks_!![pu])
                parents_!![pu] = pv
            else if (ranks_!![pu] > ranks_!![pv])
                parents_!![pv] = pu
            else {
                parents_!![pv] = pu
                ranks_!![pu] += 1
            }

            return true
        }*/

        fun union(u: Int, v: Int): Boolean {
            val pu = find(u)
            val pv = find(v)
            if (pu == pv) {
                return false
            }
            var rankPV = ranks_?.get(pv) ?: -1
            var rankPU = ranks_?.get(pu) ?: -1
            //merge low ranks_ tree into high ranks_ tree
            if (rankPV > rankPU) {
                parents_?.set(pu, pv)
            } else if (rankPV < rankPU) {
                parents_?.set(pv, pu)
            } else {
                parents_?.set(pv, pu)
                rankPU++
                ranks_?.set(pu, rankPU)
            }
            return true
        }

        /*fun find(u: Int): Int {
            var u_ = u
            while (parents_!![u_] != u_) {
                parents_!![u_] = parents_!![parents_!![u_]]
                u_ = parents_!![u_]
            }
            return u_
        }*/

        fun find(i: Int): Int {
            var index = i
            while (index != parents_?.get(index)) {
                //将i节点链接到其爷爷触点
                val p = parents_?.get(parents_?.get(index) ?: -1)
                if (p != null) {
                    parents_?.set(index, p)
                }
                index = parents_?.get(index) ?: -1
            }
            return index
        }
    }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val size = edges.size
        val unionFindSet = UnionFindSet(size)
        for (edge in edges) {
            //there are 2 nodes in every edge
            //if they are have same parent, union() return false, so just return this edge
            if (!unionFindSet.union(edge[0], edge[1])) {
                return edge
            }
        }
        return IntArray(1)
    }
}