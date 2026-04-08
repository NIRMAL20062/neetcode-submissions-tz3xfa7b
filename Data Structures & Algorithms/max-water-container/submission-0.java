class Solution {
    public int maxArea(int[] heights) {
        int maxArea=0;
        int low=0;
        int high = heights.length-1;
        while(low<high){
             int height = Math.min(heights[low], heights[high]);
             int bredth=high-low;
             int area = height*bredth;
             maxArea=Math.max(area,maxArea);

            if (heights[low] < heights[high]) {
                low++;
            } else {
                high--;
            }

        }
        return maxArea;
    }
}
