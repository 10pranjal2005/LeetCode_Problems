class Solution{
    public int firstMissingPositive(int[] nums){
        int n=nums.length;
        int i=0;
        while(i<n){
            int index=nums[i]-1;
            if(nums[i]>0&&nums[i]<=n&&nums[i]!=nums[index]){
                int t=nums[i];
                nums[i]=nums[index];
                nums[index]=t;
            }else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
