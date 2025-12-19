class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        int rem=(int)(totalsum%p);
        if(rem==0)return 0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        long prefixsum=0;
        int minLen=nums.length;
        for (int i=0;i<nums.length;i++){
            prefixsum=(prefixsum+nums[i])%p;
            int currMod=(int)prefixsum;
            int target=(currMod-rem+p)%p;
            if(map.containsKey(target)){
                minLen=Math.min(minLen,i-map.get(target));
            }
            map.put(currMod,i);
        }
        return minLen==nums.length?-1:minLen;
    }
}