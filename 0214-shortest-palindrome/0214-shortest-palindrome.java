class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String reversed_s = new StringBuilder(s).reverse().toString();
        String temp = s + "#" + reversed_s;     
        int[] lps = computeLPSArray(temp);
        int palindromicPrefixLength = lps[temp.length() - 1];
        String suffixToPrepend = s.substring(palindromicPrefixLength);
        return new StringBuilder(suffixToPrepend).reverse().toString() + s;
    }
    private int[] computeLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int length = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}