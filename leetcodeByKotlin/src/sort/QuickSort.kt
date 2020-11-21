package sort

/**
 * QuickSort best case O(nlgn), worst case O(n^2)
 * worst case will occurred in:
 * 1. all element sorted
 * 2. partition unbalanced
 * */
class QuickSort {

    fun sort(array: IntArray): IntArray {
        sortArray(array, 0, array.size - 1)
        printArray(array)
        return array
    }

    private fun printArray(array: IntArray) {
        println("")
        for (item in array) {
            print("$item ,")
        }
    }

    private fun sortArray(array: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        val pivotPosition = partition(array, left, right)
        sortArray(array, left, pivotPosition - 1)
        sortArray(array, pivotPosition + 1, right)
    }

    private fun partition(array: IntArray, left: Int, right: Int): Int {
        var i = left
        var j = right
        val pivot = array[j]
        while (i < j) {
            while (i < j && array[i] < pivot) {
                i++
            }
            swap(array, i, j)
            while (i < j && array[j] >= pivot) {
                j--
            }
            swap(array, i, j)
        }
        return i
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}