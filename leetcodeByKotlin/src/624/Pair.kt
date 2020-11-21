package `LeetCode_624`

class Pair constructor(name_: Int, value_: Int) : Comparable<Pair> {

    var first: Int = name_
    var second: Int = value_

    override fun compareTo(other: Pair): Int {
        if (second > other.second) {
            return 1
        } else if (second < other.second) {
            return -1
        }
        return 0
    }

    override fun hashCode(): Int {
        val hash = 3
        return hash
    }

    override fun equals(other: Any?): Boolean {
        val other_ = other as Pair
        return this.first == other_.first && this.second == other_.second
    }
}