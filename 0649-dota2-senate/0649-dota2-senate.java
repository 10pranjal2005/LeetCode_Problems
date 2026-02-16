class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        
        java.util.Queue<Integer> radiant = new java.util.LinkedList<>();
        java.util.Queue<Integer> dire = new java.util.LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            
            int rIndex = radiant.poll();
            int dIndex = dire.poll();
            
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n);
            } else {
                dire.offer(dIndex + n);
            }
        }
        
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
