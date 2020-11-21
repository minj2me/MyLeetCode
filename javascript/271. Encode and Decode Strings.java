/**
 * Lock by leetcode
 * 
 * 271. Encode and Decode Strings
 * https://www.lintcode.com/problem/encode-and-decode-strings/description
 */
 public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
   public String encode(List<String> strs) {
         if (strs==null || strs.size()==0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (String s:strs){
            int len = s.length();
            sb.append(len).append("/");
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        //str: 4/lint4/code4/love3/you
        List<String> res = new ArrayList();
        if (str==null || str.length()==0)
            return res;
        int index=0;
        while (index<str.length()){
            //indexOf(int ch, int fromIndex)
            int forwardIndex = str.indexOf("/",index);
            int len = Integer.valueOf(str.substring(index,forwardIndex));
            res.add(str.substring(forwardIndex+1,forwardIndex+len+1));
            index = forwardIndex+len+1;
        }
        return res;
    }
}