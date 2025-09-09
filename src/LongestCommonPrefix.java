public class LongestCommonPrefix {


    public static void main(String[] args) {

        String[] s = {"flower","flow", "flight"};
        System.out.println(findLongestCommenPrefix(s));
    }

    private static String findLongestCommenPrefix(String[] s) {
        String assume = s[0];
        for (int i = 1; i < s.length; i++) {
            while (!s[i].startsWith(assume)) {
               assume = assume.substring(0, assume.length()-1);
           }
        }
        return assume;
    }
}
