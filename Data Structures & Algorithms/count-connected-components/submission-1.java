class Solution {
    public int countComponents(int n, int[][] edges) {


        // build graph
        List<List<Integer>> graph  = new ArrayList<>();

        for(int i =0 ; i<n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: Visited array
        boolean[] visited = new boolean[n];

        int components = 0;

        // Step 3: Traverse all nodes
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                components++; // found one component
            }
        }

        return components;

        
    }

    public void dfs(int node ,List<List<Integer>> graph ,boolean[] visited){
        visited[node]= true;

        for(int neighbour:graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, graph, visited);
            }
        }
    }
}
