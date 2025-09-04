class Solution{
    public int strStr(String haystack, String needle){
        int haystacklen=haystack.length();
        int needlelen=needle.length();
        if(needlelen>haystacklen){
            return -1;
        }
        for(int i=0;i<=haystacklen-needlelen;i++){
            int j;
            for(j=0;j<needlelen;j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    break;
                }
            }
            if(j==needlelen){
                return i;
            }
        }
        return -1;
    }
}
