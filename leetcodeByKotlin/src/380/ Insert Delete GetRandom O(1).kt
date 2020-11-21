package LeetCode_380

/**
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
Design a data structure that supports all following operations in average O(1) time.
==insert(val): Inserts an item val to the set if not already present.
==remove(val): Removes an item val from the set if present.
==getRandom: Returns a random element from current set of elements (it's guaranteed that at least one element exists when this method is called).
Each element must have the same probability of being returned.
 * */
class RandomizedSet() {
    /*
    * solution: HashMap+Array;  HashMap: key is num,  value: the index of num in Array
    * insert O(1):HashMap
    * delete O(1):HashMap
    * get random O(1):List or Array, because it save item in memory continuously
    * */
    /** Initialize your data structure here. */
    val map = HashMap<Int, Int>()
    val list = ArrayList<Int>()
    //kotlin's random was not work here??
    var random = java.util.Random()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) {
            return false
        }
        //insert value into the tail of Array
        val index = list.size
        list.add(`val`)
        map.put(`val`, index)
        return true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) {
            return false
        }
        val indexInArray = map.get(`val`)!!
        map.put(list.elementAt(list.lastIndex), indexInArray)
        //replace val with the element in the last of array and remove it
        list.set(indexInArray, list.elementAt(list.lastIndex))
        //remove the element in the last of array
        list.removeAt(list.lastIndex)
        //remove key in map
        map.remove(`val`)
        return true
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        val randomIndex = random.nextInt(list.size)
        return list[randomIndex]
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */