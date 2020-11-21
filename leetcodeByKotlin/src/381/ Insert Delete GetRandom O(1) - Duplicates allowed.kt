package LeetCode_381

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/
 *
 * Design a data structure that supports all following operations in average O(1) time.
Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements.
The probability of each element being returned is linearly related to the number of same value the collection contains.
 * */
class RandomizedCollection() {
    /*
    *solution: HashMap+Array;
    * key of HashMap: number, value of HashMap is the list of index of the element in array,
    * Array<Pair<Int,Int>>, first: element, second: the index of element in the value(index list) of HashMap,
    * insert O(1): HashMap,
    * delete O(1), HashMap,
    * getRandom O(1), Array, because it save item in memory continuously
    * */

    /** Initialize your data structure here. */
    val map = HashMap<Int, ArrayList<Int>>()
    val list = ArrayList<Pair<Int, Int>>()
    val random = java.util.Random()

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        val indexList = map.getOrDefault(`val`, ArrayList())
        //add the index of element in array
        indexList.add(list.size)
        map.put(`val`, indexList)
        list.add(Pair(`val`, indexList.lastIndex))
        return indexList.size == 1
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) {
            return false
        }
        val indexList = map.get(`val`)
        val indexNeedEvict = indexList!!.get(indexList.lastIndex)
        val lastPair = list.get(list.lastIndex)

        //update index, replace the position between the element need to delete and the last element
        map.get(lastPair.first)!!.set(lastPair.second, indexNeedEvict)
        //swap
        list.set(indexNeedEvict, lastPair)

        //clean it
        list.removeAt(list.lastIndex)
        indexList.removeAt(indexList.lastIndex)
        if (indexList.size == 0) {
            map.remove(`val`)
        }
        return true
    }

    /** Get a random element from the collection. */
    fun getRandom(): Int {
        val randomIndex = random.nextInt(list.size)
        return list.get(randomIndex).first
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * var obj = RandomizedCollection()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */