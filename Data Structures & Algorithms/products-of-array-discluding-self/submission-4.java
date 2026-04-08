class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] preproduct = new int[nums.length];
        int[] postproduct  = new int[nums.length];

        preproduct[0]=1;
        for (int i=1; i<nums.length;i++){
            preproduct[i] =nums[i-1]*preproduct[i-1];
        }
        
        postproduct[nums.length - 1] =1;
        for(int i=nums.length-1-1;i>=0;i--){
            postproduct[i]=postproduct[1+i]*nums[1+i];
        }

        for(int i=0;i<nums.length;i++){
            nums[i]=preproduct[i]*postproduct[i];
        }
        return nums;
    }
}  
