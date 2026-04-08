class Solution {
    public int trap(int[] height) {
        // find left max.
        // find right max

        // area for each = min (left max , right max)-own
        // sum all

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
   
        int max=height[0];
        for(int i=0;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
            }
            leftMax[i]=max;
        }

        int max2=height[height.length-1];
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>max2){
                max2=height[i];
            }
            rightMax[i]=max2;
        }


        int sum=0;
        for(int i =0;i<height.length;i++){
            int area = Math.min(leftMax[i],rightMax[i])-height[i];
            sum+=area;
        }
        return sum;
    }
}