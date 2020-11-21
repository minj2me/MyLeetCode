package LeetCode_1603

/**
 * 1603. Design Parking System
 * https://leetcode.com/problems/design-parking-system/description/
 * */
class ParkingSystem(big: Int, medium: Int, small: Int) {
    val array = IntArray(4)

    init {
        //carType is 1, 2, or 3
        array[1] = big
        array[2] = medium
        array[3] = small
    }

    fun addCar(carType: Int): Boolean {
        if (array[carType] > 0) {
            array[carType]--
            return true
        }
        return false
    }
}
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */