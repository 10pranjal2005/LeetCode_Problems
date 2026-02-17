class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        
        List<String> result = new ArrayList<>();
        
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                
                // Count total LEDs ON
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    
                    // Format minute to always 2 digits
                    String time = hour + ":" + String.format("%02d", minute);
                    result.add(time);
                }
            }
        }
        
        return result;
    }
}
