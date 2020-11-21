
import java.util.HashMap;

public class Solution_340 {

    /**
     * 340.Longest Substring with At Most K Distinct Characters
     * (Locked by leetcode)
     * https://www.lintcode.com/problem/longest-substring-with-at-most-k-distinct-characters/description
     * https://www.cnblogs.com/grandyang/p/5185561.html
     * <p>
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.
     * <p>
     * Example 1:
     * Input: s = "eceba", k = 2
     * Output: 3
     * Explanation: T is "ece" which its length is 3.
     * <p>
     * Example 2:
     * Input: s = "aa", k = 1
     * Output: 2
     * Explanation: T is "aa" which its length is 2.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int [][] colors = {{0,1,0}, {1,0,1}, {2,0,1}, {0,1,2}, {1,0,2}, {2,0,2}, {0,2,0}, {1,2,0}, {2,1,0}, {0,2,1},{1,2,1}, {2,1,2}};

        int result = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            while (map.size() > k) {
                char leftChat = s.charAt(left);
                //System.out.println("leftChat:" + leftChat);
                map.put(leftChat, map.get(leftChat) - 1);
                if (map.get(leftChat) == 0) {
                    map.remove(leftChat);
                }
                left++;
                /*System.out.println("map.size:" + map.size());
                System.out.print("");
                for (Object m : map.keySet()) {
                    System.out.print("key:" + m);
                    System.out.print(",");
                    System.out.print("value:" + map.get(m));
                    System.out.println();
                }*/
            }
            result = Math.max(result, i - left + 1);
        }

        return result;
    }
}
