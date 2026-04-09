class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: edges must be n-1
        if (edges.length != n - 1) return false;

        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        // DFS from node 0
        dfs(0, graph, visited);

        // Condition 2: all nodes must be visited
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}