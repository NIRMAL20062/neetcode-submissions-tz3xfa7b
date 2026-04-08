class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.add(i);
        }

        int max = 1;
        int currMax = 1;

        int prev = pq.poll(); // smallest element

        while (!pq.isEmpty()) {
            int curr = pq.poll();

            if (curr == prev) {
                // duplicate → ignore
                continue;
            } 
            else if (curr == prev + 1) {
                currMax++;
            } 
            else {
                currMax = 1;
            }

            max = Math.max(max, currMax);
            prev = curr;
        }

        return max;
    }
}
