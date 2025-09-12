class Solution {
    public String reverseWords(String s) {
        String trimmedString = s.trim();
        List<String> words = Arrays.asList(trimmedString.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}