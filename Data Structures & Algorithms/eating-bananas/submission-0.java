class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // find max pile (upper bound)
        for (int p : piles) {
            if (p > high) high = p;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;
            long hours = 0;

            // calculate hours needed at speed = mid
            for (int p : piles) {
                hours += (p + mid - 1) / mid;   // ceil division
            }

            if (hours <= h) {
                high = mid - 1;   // try smaller speed
            } else {
                low = mid + 1;    // need faster speed
            }
        }

        return low;
    }
}
