import LeetCode_647.Solution

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Main {
    //    fun main(args: Array<String>) {
//        println("Hello kotlin")
//    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val board = Array(4) { CharArray(4) }
            board[0] = charArrayOf('X', 'X', 'X', 'X')
            board[1] = charArrayOf('X', 'O', 'O', 'X')
            board[2] = charArrayOf('X', 'X', 'O', 'X')
            board[3] = charArrayOf('X', 'O', 'X', 'X')
            //solution.solve(board)

            //[[1,2], [3], [3], []]
            val graph = Array(3, { IntArray(3) })
            graph[0] = intArrayOf(1, 2, 3)
            graph[1] = intArrayOf(5, 7)
            graph[2] = intArrayOf(8, 9)
            //solution.allPathsSourceTarget(graph)
            //negative
            /*
            * [[0,0,0],
                [0,1,0],
                [1,1,1]]
            * */
            val matrix = Array(3) { IntArray(3) }
            matrix[0] = intArrayOf(0, 0, 0)
            matrix[1] = intArrayOf(0, 1, 0)
            matrix[2] = intArrayOf(1, 1, 1)

            //["eat", "tea", "tan", "ate", "nat", "bat"],
            //val strings = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
            //val tasks = charArrayOf('A','A','A','B','B','B')
            val array = intArrayOf(1, 2, 3, 4)
            val s = "abcdefg"
            val shift = Array(4) { IntArray(2) }//[1,1],[1,1],[0,2],[1,3]
            shift[0] = intArrayOf(1, 1)
            shift[1] = intArrayOf(1, 1)
            shift[2] = intArrayOf(0, 2)
            shift[3] = intArrayOf(1, 3)

            val hasApple = listOf(false, false, true, false, true, true, false)

            //[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]], [0,0],[0,1],[0,-1]
            //val coordinates = Array(3) { IntArray(2) }
            val coordinates = Array(6) { IntArray(2) }
            /*coordinates[0] = intArrayOf(1,2)
            coordinates[1] = intArrayOf(2,3)
            coordinates[2] = intArrayOf(3,5)*/
            /*coordinates[0] = intArrayOf(2,1)
            coordinates[1] = intArrayOf(4,2)
            coordinates[2] = intArrayOf(6,3)*/
            /*coordinates[0] = intArrayOf(1,1)
            coordinates[1] = intArrayOf(2,2)
            coordinates[2] = intArrayOf(3,4)
            coordinates[3] = intArrayOf(4,5)
            coordinates[4] = intArrayOf(5,6)
            coordinates[5] = intArrayOf(7,7)*/
            coordinates[0] = intArrayOf(1, 2)
            coordinates[1] = intArrayOf(2, 3)
            coordinates[2] = intArrayOf(3, 4)
            coordinates[3] = intArrayOf(4, 5)
            coordinates[4] = intArrayOf(5, 6)
            coordinates[5] = intArrayOf(6, 7)
            //solution.maxRotateFunction(intArrayOf(-2147483648,-2147483648))

            //[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
            //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
            val tickers = ArrayList<ArrayList<String>>()
            val list = ArrayList<String>()
            list.add("JFK")
            list.add("SFO")
            tickers.add(list)
            val list2 = ArrayList<String>()
            list2.add("JFK")
            list2.add("ATL")
            tickers.add(list2)
            val list3 = ArrayList<String>()
            list3.add("SFO")
            list3.add("ATL")
            tickers.add(list3)
            val list4 = ArrayList<String>()
            list4.add("ATL")
            list4.add("JFK")
            tickers.add(list4)
            val list5 = ArrayList<String>()
            list5.add("ATL")
            list5.add("SFO")
            tickers.add(list5)

            //solution.minWindow("ADOBECODEBANC","ABC")
            //solution.coinChange(intArrayOf(186,419,83,408),6249)
            //solution.canPartition(intArrayOf(1, 2, 3, 5))
            val intervals = Array(3) { IntArray(2) }//[1,1],[1,1],[0,2],[1,3]
            intervals[0] = intArrayOf(1, 4)
            intervals[1] = intArrayOf(3, 5)
            intervals[2] = intArrayOf(4, 6)

            /*
            n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
            * */
            val edges = Array(3) { IntArray(3) }
            edges[0] = intArrayOf(0, 1, 100)
            edges[1] = intArrayOf(1, 2, 100)
            edges[2] = intArrayOf(0, 2, 500)
            //A = 'abcde', B = 'cdeab'
            //[[1,4],[0,4]]
            //intervals = [[1,3],[6,9]], newInterval = [2,5]
            val intervals1 = Array(2, { IntArray(2) })
            intervals1[0] = intArrayOf(1, 3)
            intervals1[1] = intArrayOf(6, 9)
            val newInterval = intArrayOf(2, 5)

            val A = Array(5, { IntArray(2) })
            A[0] = intArrayOf(0, 0)
            A[1] = intArrayOf(2, 0)
            A[2] = intArrayOf(1, 1)
            A[3] = intArrayOf(2, 1)
            A[4] = intArrayOf(2, 2)
            //[[0,0],[2,0],[1,1],[2,1],[2,2]]
            /*
            [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
            ]
            * */
            val matrix2 = Array(3, { IntArray(3) })
            matrix2[0] = intArrayOf(1, 2, 3)
            matrix2[1] = intArrayOf(4, 5, 6)
            matrix2[2] = intArrayOf(7, 8, 9)

            val list1 = arrayOf("amazon", "apple", "facebook", "google", "leetcode")
            var list11 = arrayOf("e", "oo")

            val bomatrix3 = Array(9, { CharArray(9) })
            bomatrix3[0] = charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.')
            bomatrix3[1] = charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.')
            bomatrix3[2] = charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.')
            bomatrix3[3] = charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3')
            bomatrix3[4] = charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1')
            bomatrix3[5] = charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6')
            bomatrix3[6] = charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.')
            bomatrix3[7] = charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5')
            bomatrix3[8] = charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')

            //[[0, 1], [1, 2], [3, 4]]
            //[[0, 1], [1, 2], [2, 3], [3, 4]]
            val edges2 = Array(4, { Pair<Int, Int>(-1, -1) })
            edges2[0] = Pair(0, 1)
            edges2[1] = Pair(1, 2)
            edges2[2] = Pair(2, 3)
            edges2[3] = Pair(3, 4)
            //-2147483648
            //1
            //-1
            //-2147483648
            //solution.fractionToDecimal(2,3)

            //[[10,16], [2,8], [1,6], [7,12]]
            val A1 = Array(4, { IntArray(2) })
            A1[0] = intArrayOf(10, 16)
            A1[1] = intArrayOf(2, 8)
            A1[2] = intArrayOf(1, 6)
            A1[3] = intArrayOf(7, 12)

            //difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
            val arrays = arrayOf(
                "b",
                "br",
                "bre",
                "brea",
                "break",
                "breakf",
                "breakfa",
                "breakfas",
                "breakfast",
                "l",
                "lu",
                "lun",
                "lunc",
                "lunch",
                "d",
                "di",
                "din",
                "dinn",
                "dinne",
                "dinner"
            )
            val N = 4
            val dislikes = Array(3, { IntArray(2) })//[[1,2],[1,3],[2,4]]
            dislikes[0] = intArrayOf(1, 2)
            dislikes[1] = intArrayOf(1, 3)
            dislikes[2] = intArrayOf(2, 4)

            /*
            * INF  -1  0  INF
              INF INF INF  -1
              INF  -1 INF  -1
              0  -1 INF INF
            * */
            val grid = Array(4, { IntArray(4) })
            val INF = Int.MAX_VALUE
            grid[0] = intArrayOf(INF, -1, 0, INF)
            grid[1] = intArrayOf(INF, INF, INF, -1)
            grid[2] = intArrayOf(INF, -1, INF, -1)
            grid[3] = intArrayOf(0, -1, INF, INF)
            //solution.fillEmptyRoom(grid)

            /*
            * ["John", "johnsmith@mail.com", "john00@mail.com"],
                ["John", "johnnybravo@mail.com"],
                ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
                ["Mary", "mary@mail.com"]
                ]
            * */
            val accounts = ArrayList<ArrayList<String>>()
            accounts.add(arrayListOf("John", "johnsmith@mail.com", "john00@mail.com"))
            accounts.add(arrayListOf("John", "johnnybravo@mail.com"))
            accounts.add(arrayListOf("John", "johnsmith@mail.com", "john_newyork@mail.com"))
            accounts.add(arrayListOf("Mary", "mary@mail.com"))

            //[1,2],[2,3],[3,4],[1,3]
            val intevals = Array(4, { IntArray(2) })
            intevals[0] = intArrayOf(1, 2)
            intevals[1] = intArrayOf(2, 3)
            intevals[2] = intArrayOf(3, 4)
            intevals[3] = intArrayOf(1, 3)
            //solution.eraseOverlapIntervals(intevals)

            val beginWord = "hit"
            val endWord = "cog"
            val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")

            //Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
            val grid2 = Array(3) { IntArray(5) }
            grid2[0] = intArrayOf(1, 0, 2, 0, 1)
            grid2[1] = intArrayOf(0, 0, 0, 0, 0)
            grid2[2] = intArrayOf(0, 0, 1, 0, 0)
            //Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
            //"ababacb" 3
            //solution.longestSubstring("ababbc",2)
            //"bbaaacbd" 3
            /*
            * [["a","b"],["b","c"]]
                [2.0,3.0]
            [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
            * */
            val listab1 = listOf("a", "b")
            val listab2 = listOf("b", "c")
            val allList1 = listOf(listab1, listab2)
            val doubleArray = doubleArrayOf(2.0, 3.0)
            val listq1 = listOf("a", "c")
            val listq2 = listOf("b", "a")
            val listq3 = listOf("a", "e")
            val listq4 = listOf("a", "a")
            val listq5 = listOf("x", "x")
            val allQuery = listOf(listq1, listq2, listq3, listq4, listq5)
            //[-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648]
            //3
            //A= [4,8,13]
            //B=[0,9,12]
            //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
            val maze = Array(6, { IntArray(2) })
            maze[0] = intArrayOf(1,1)
            maze[1] = intArrayOf(3,2)
            maze[2] = intArrayOf(5,3)
            maze[3] = intArrayOf(4,1)
            maze[4] = intArrayOf(2,3)
            maze[5] = intArrayOf(1,4)
            val maze2 = Array(1, { IntArray(2) })
            maze2[0] = intArrayOf(0,0)

            val nums = intArrayOf(0,1,2,3,4)
            val indexs = intArrayOf(0,1,2,2,1)
            //"cabwefgewcwaefgcf"
            //"cae"
            //[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
            /*
            * [[1,2,2,1],
[3,1,2],
[1,3,2],
[2,4],
[3,1,2],
[1,3,1,1]]
            * */
            val lists = ArrayList<List<Int>>()//= listOf(4,10,15,24,26)
            lists.add(listOf(1,2,2,1))
            lists.add(listOf(3,1,2))
            lists.add(listOf(1,3,2))
            lists.add(listOf(2,4))
            lists.add(listOf(3,1,2))
            lists.add(listOf(1,3,1,1))

            //["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
            val solution = LeetCode_33.Solution()
            /*
            * 11000
              11000
              00011
              00011

              11011
              10000
              00001
              11011
            * */
            val arrays2 = Array(4){IntArray(5)}
            arrays2[0] = intArrayOf(1,1,0,1,1)
            arrays2[1] = intArrayOf(1,0,0,0,0)
            arrays2[2] = intArrayOf(0,0,0,0,1)
            arrays2[3] = intArrayOf(1,1,0,1,1)
            //solution.closeStrings("uau", "ssx")
            // [1,1,4,2,3]
            //5
            solution.search(intArrayOf(4,5,6,7,0,1,2),0)
            //solution.minWindow("cabwefgewcwaefgcf","cae")

            //test let
            /* "test_let".let {
                 println(it);
                 println(it);
             }

             //test apply
             ArrayList<Int>().apply {
                 add(1)
                 add(2)
             }.let {
                 println(it)
             }

             //lateinit 只用于变量 var，而 lazy 只用于常量 val
             //lazy 应用于单例模式(if-null-then-init-else-return)，而且当且仅当变量被第一次调用的时候，委托方法才会执行。
             val lazyValue:String by lazy {
                 println("inited")
                 "hello"
             }
             println(lazyValue);
             println(lazyValue);*/

        }
    }

    abstract class Animal2 {
        private val loveFish: Boolean = false
        abstract fun talk(): String
        //方法, 可以私有的，非abstract方法，必须实现；接口没有私有，默认是public，abstract 类型
        fun speaking() {
            println("say hi")
        }
    }

    abstract class Animal2_ {
        private val loveFish: Boolean = false
        abstract fun talk(): String
    }

    class Tigar : Animal2() {
        override fun talk(): String {
            return "Tigar says WOO!"
        }

    }

    //    class Cat2:Animal2(){
//        override fun talk(): String {
//            return "Cat says Meow!"
//        }
//    }
//    class Dog2:Animal2(){
//        override fun talk(): String {
//            return "Dog says Woof!"
//        }
//    }
    //test parametric polymorphism
    interface Animal {
        fun talk(): String
        fun footCount(): Int
        fun speaking() {
            println("say hi")
        }
    }

    interface Animal_ {
        fun talk(): String
        fun footCount(): Int
    }

    class Cat : Animal {
        override fun talk(): String {
            return "Cat says Meow!"
        }

        override fun footCount(): Int {
            return 3
        }
    }

    class Dog : Animal {
        override fun talk(): String {
            return "Dog says Woof!"
        }

        override fun footCount(): Int {
            return 4
        }
    }

    //test thread
    class TestThread : Thread {
        var testThread2: TestThread2? = null
        var value: Int = 0;

        constructor(v: Int) {
            testThread2 = TestThread2(6)
            testThread2?.start()
            value = v;
        }

        override fun run() {
            super.run()
            for (i in 0..value) {
                if (i == 2)
                    testThread2?.join()
                println(Thread.currentThread().name + ":" + i);
            }
        }
    }

    class TestThread2 : Thread {
        var value: Int = 0;

        constructor(v: Int) {
            value = v;
        }
        //        @Synchronized
//        fun printlnVal(v: Int) {
//            while (true) {
//                println(v);
//            }
//        }

        override fun run() {
            super.run()
            for (i in 0..value)
                println(Thread.currentThread().name + ":" + i);
        }
    }
}