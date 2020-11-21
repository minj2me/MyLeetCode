package _interview_question

/**
 * Find Itinerary from a given list of tickets
Given a list of tickets, find itinerary in order using the given list.

Example:
Input:
"Chennai" -> "Banglore"
"Bombay" -> "Delhi"
"Goa"    -> "Chennai"
"Delhi"  -> "Goa"
Output:
Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
It may be assumed that the input list of tickets is not cyclic and there is one ticket from every city except final destination.
 * */
class Solution3 {

    /*
    * Because input tickers is not cyclic, so we can build graph and do Topological Sort
    * Time complexity: O(n)
    * */
    fun findItineraryFromTickets() {
        //create map for from->to
        val map = HashMap<String, String>()
        map.put("Chennai", "Banglore")
        map.put("Bombay", "Delhi")
        map.put("Goa", "Chennai")
        map.put("Delhi", "Goa")
        //create reverse map to store map above
        val reverseMap = HashMap<String, String>()
        for (item in map) {
            reverseMap.put(item.value, item.key)
        }
        //find out the starting point of itinerary
        //If a key is not present, then we found the starting point.
        var start = ""
        for (item in map) {
            if (!reverseMap.containsKey(item.key)) {
                start = item.key
                break
            }
        }
        //input wrong
        if (start == "") {
            return
        }
        //get next by starting point
        var to = map.get(start)
        while (to != null) {
            print("$start -> $to")
            print(",")
            start = to
            to = map.get(start)
            //Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,
        }
    }
}