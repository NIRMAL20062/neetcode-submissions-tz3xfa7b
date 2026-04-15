class Solution {
    public boolean validTree(int n, int[][] edges) {

        //condition 1
        if(edges.length!=n-1) return false;

        // build graph
        List<List<Integer>> graph  = new ArrayList<>();

        for(int i =0 ; i<n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(0 ,graph ,visited);

        // condition 2
        for(boolean v : visited){
            if (!v) return false;
        }

        return true;
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