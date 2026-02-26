class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        
        // Traverse from right to left (ignore MSB)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            
            if (bit + carry == 1) {
                // Odd case: add 1 then divide
                steps += 2;
                carry = 1;
            } else {
                // Even case: just divide
                steps += 1;
            }
        }
        
        // If carry remains, one extra step
        return steps + carry;
    }
}