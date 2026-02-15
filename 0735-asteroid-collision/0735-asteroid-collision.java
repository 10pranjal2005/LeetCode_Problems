class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        int[] stack = new int[n];
        int top = -1;
        
        for (int asteroid : asteroids) {
            
            boolean destroyed = false;
            
            while (top >= 0 && stack[top] > 0 && asteroid < 0) {
                
                if (Math.abs(stack[top]) < Math.abs(asteroid)) {
                    top--; // stack asteroid explodes
                    continue;
                } 
                else if (Math.abs(stack[top]) == Math.abs(asteroid)) {
                    top--; // both explode
                }
                
                destroyed = true;
                break;
            }
            
            if (!destroyed) {
                stack[++top] = asteroid;
            }
        }
        
        int[] result = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            result[i] = stack[i];
        }
        
        return result;
    }
}
