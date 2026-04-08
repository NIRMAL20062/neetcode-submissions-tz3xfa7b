class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Map to store the frequency of characters in t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int startNode = 0;
        int required = targetMap.size(); // Number of unique chars in t to be met
        int formed = 0; // Number of unique chars in current window meeting target frequency

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If current char frequency matches target frequency
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window while it is valid
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update result if this window is smaller than previous best
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startNode = left;
                }

                // Remove leftmost character and update 'formed' status
                windowMap.put(c, windowMap.get(c) - 1);
                if (targetMap.containsKey(c) && windowMap.get(c) < targetMap.get(c)) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startNode, startNode + minLen);
    }
}