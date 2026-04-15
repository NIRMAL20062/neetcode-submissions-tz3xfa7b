/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node , Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        
        if(node==null){
            return node;
        }

        return dfs(node);
    }


    public Node dfs(Node node){
        // if already in map return
        if(map.containsKey(node)){
            return map.get(node);
        }

        // make a new node
        Node clone = new Node(node.val);

        map.put(node, clone);

        // store in map

        // add neighbours
        for(Node neighbour : node.neighbors){
            clone.neighbors.add(dfs(neighbour));
        
        }
    return clone;
    }
}