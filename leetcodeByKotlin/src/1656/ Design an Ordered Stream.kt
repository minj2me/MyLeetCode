package LeetCode_1656

/**
 * 1656. Design an Ordered Stream
 * https://leetcode.com/problems/design-an-ordered-stream/
 * There are n (id, value) pairs, where id is an integer between 1 and n and value is a string.
 * No two pairs have the same id.
Design a stream that takes the n pairs in an arbitrary order, and returns the values over several calls in increasing order of their ids.
Implement the OrderedStream class:
1. OrderedStream(int n) Constructs the stream to take n values and sets a current ptr to 1.
2. String[] insert(int id, String value) Stores the new (id, value) pair in the stream. After storing the pair:
a. If the stream has stored a pair with id = ptr, then find the longest contiguous incrementing sequence of ids starting with id = ptr and return a list of the values associated with those ids in order.
Then, update ptr to the last id + 1.
b. Otherwise, return an empty list.

Example:
Input
["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
[[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
Output
[null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
Explanation
OrderedStream os= new OrderedStream(5);
os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].

Constraints:
1. 1 <= n <= 1000
2. 1 <= id <= n
3. value.length == 5
4. value consists only of lowercase letters.
5. Each call to insert will have a unique id.
6. Exactly n calls will be made to insert.
 * */
class OrderedStream(n: Int) {

    var size = 0
    //need global pointer to keep checking
    var curPtr = 0
    var list: ArrayList<String>? = null

    init {
        size = n
        list = ArrayList(n)
        for (i in 0 until n) {
            list?.add("")
        }
    }

    fun insert(id: Int, value: String): List<String> {
        list!!.set(id - 1, value)
        val result = ArrayList<String>()
        while (curPtr < size && list?.get(curPtr) != "") {
            result.add(list!!.get(curPtr))
            curPtr++
        }
        return result
    }
}
/**
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = OrderedStream(n)
 * var param_1 = obj.insert(id,value)
 */