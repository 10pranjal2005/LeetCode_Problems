class Solution {
    public String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : s.toCharArray()) {
            if (top >= 0 && stack[top] == c) {
                top--;          
            } else {
                stack[++top] = c; 
            }
        }
        return new String(stack, 0, top + 1);
    }
}
