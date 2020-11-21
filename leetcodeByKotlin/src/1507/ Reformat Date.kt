package LeetCode_1507
import java.lang.StringBuilder
/**
 * 1507. Reformat Date
 * https://leetcode.com/problems/reformat-date/description/
 *
 * Given a date string in the form Day Month Year, where:
    1.Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
    2.Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
    3.Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:
    1.YYYY denotes the 4 digit year.
    2.MM denotes the 2 digit month.
    3.DD denotes the 2 digit day.

Example 1:
Input: date = "20th Oct 2052"
Output: "2052-10-20"

Example 2:
Input: date = "6th Jun 1933"
Output: "1933-06-06"

Example 3:
Input: date = "26th May 1960"
Output: "1960-05-26"

Constraints:
The given dates are guaranteed to be valid, so no error handling is necessary.
 * */
class Solution {
    fun reformatDate(date: String): String {
        val monthMaps = mapOf("Jan" to "01","Feb" to "02","Mar" to "03","Apr" to "04","May" to "05",
            "Jun" to "06","Jul" to "07","Aug" to "08","Sep" to "09","Oct" to "10","Nov" to "11","Dec" to "12")
        val list = date.split(" ")
        val sb = StringBuilder()
        for (i in list.size-1 downTo 0){
            when(i){
                2->sb.append(list.get(i)).append("-")
                1->sb.append(monthMaps.get(list.get(i))).append("-")
                0->sb.append(setDay(list.get(i)))
            }
        }
        return sb.toString()
    }

    private fun setDay(str:String):String{
        val sb = StringBuilder()
        val day = str.replace("st","").replace("nd","").replace("rd","").replace("th","")
        if (day.toInt()<10){
            sb.append("0")
        }
        sb.append(day)
        return sb.toString()
    }
}