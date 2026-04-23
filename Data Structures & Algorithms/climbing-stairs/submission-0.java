class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1); 
        return util(n, dp);
    }

    static int util(int n, int[] dp) {
        if (n == 1) return 1;  // 1 way  → {1}
        if (n == 2) return 2;  // 2 ways → {1,1} or {2}
        if (dp[n] != -1) return dp[n];

        dp[n] = util(n - 1, dp) + util(n - 2, dp);
        return dp[n];
    }
}