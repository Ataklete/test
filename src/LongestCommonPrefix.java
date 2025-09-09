/*
* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
* 
* 
* */

public class LongestCommonPrefix {


    public static void main(String[] args) {

        String[] strs = {"flower","flow", "flight"};
        System.out.println(findLongestCommenPrefix(strs));
    }

    private static String findLongestCommenPrefix(String[] strs) {
        String assume = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(assume)) {
               assume = assume.substring(0, assume.length()-1);
           }
        }
        return assume;
    }
}
