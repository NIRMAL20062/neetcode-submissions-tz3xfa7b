class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int low=0;
        int high=numbers.length-1;

        while(low<high){
            int sum=numbers[low]+numbers[high];
            if(target==sum){
                return new int[]{low+1,high+1};
            }
            if(target<sum){
                high--;
            }
            else{
                low++;
            }
        }
        return new int[]{low,high};
    }
}