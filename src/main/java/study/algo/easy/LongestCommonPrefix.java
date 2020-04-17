package study.algo.easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flaw"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        String longestCommonPrefix = "";
        if (strs == null || strs.length ==0) {
            return null;
        }

        int index = 0;
        for (char character: strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i ++) {
                if( index >= strs[i].length() || character != strs[i].charAt(index) ) {
                    return longestCommonPrefix;
                }
            }
            longestCommonPrefix += character;
            index++;
        }

        return longestCommonPrefix;

    }


}
