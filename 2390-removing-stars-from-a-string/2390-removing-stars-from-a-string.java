class Solution {
    public String removeStars(String s) {
        
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (char ch : s.toCharArray()) {
            
            if (ch == '*') {
                top--;  // remove previous character
            } else {
                stack[++top] = ch;  // push character
            }
        }
        
        return new String(stack, 0, top + 1);
    }
}
