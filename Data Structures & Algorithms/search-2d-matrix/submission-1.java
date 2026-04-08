class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low=0;
        int high = row*col-1;

        while(low<=high){
            int mid= low+(high-low)/2;
            int midval= matrix[mid/col][mid%col];

            if(midval==target){
                return true;
            }else if(midval<target){
                low++;
            }
            else{
                high--;
            }
        }
        return false;
    }
}