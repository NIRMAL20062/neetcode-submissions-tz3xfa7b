class Solution {
    public int search(int[] nums, int target) {
        int st=0;
        int ed=nums.length-1;

        while(st<=ed){
            int mid = st+(ed-st)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                ed--;
            }
            else{
                st++;
            }
        }
        return -1;
    }
}
