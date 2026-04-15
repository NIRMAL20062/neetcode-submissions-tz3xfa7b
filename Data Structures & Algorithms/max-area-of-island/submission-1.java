class Solution {

    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
    
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {

                if (grid[r][c] == 1) { 
                    int x = dfs(grid, r, c);
                    max = Math.max(max, x);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            grid[r][c] != 1) return 0; 

        grid[r][c] = 0;   // mark visited

        return 1
            + dfs(grid, r + 1, c)
            + dfs(grid, r - 1, c)
            + dfs(grid, r, c + 1)
            + dfs(grid, r, c - 1);
    }
}