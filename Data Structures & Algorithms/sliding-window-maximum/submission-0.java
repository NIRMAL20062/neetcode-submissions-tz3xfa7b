class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque <Integer> D = new ArrayDeque<>();
        for (int i=0;i<n;i++){
            if(!D.isEmpty() && D.peekFirst()<=i-k){
                D.pollFirst();
            }
            while (!D.isEmpty() && nums[D.peekLast()] <= nums[i]) {
                D.pollLast();
            }
            D.offerLast(i);
            if (i >= k - 1) {
                    result[i - k + 1] = nums[D.peekFirst()];
                }
        }
        return result;
    }
}